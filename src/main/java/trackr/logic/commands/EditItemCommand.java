package trackr.logic.commands;

import static java.util.Objects.requireNonNull;
import static trackr.commons.util.CollectionUtil.requireAllNonNull;
import static trackr.model.Model.PREDICATE_SHOW_ALL_ITEMS;

import java.util.List;

import trackr.commons.core.Messages;
import trackr.commons.core.index.Index;
import trackr.logic.commands.exceptions.CommandException;
import trackr.model.Model;
import trackr.model.ModelEnum;
import trackr.model.item.Item;
import trackr.model.item.ItemDescriptor;
import trackr.model.menu.MenuItem;
import trackr.model.order.Order;

/**
 * Edits the details of an existing item in the item list.
 */
public abstract class EditItemCommand<T extends Item> extends Command {

    public static final String MESSAGE_EDIT_ITEM_SUCCESS = "Edited %s: %s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_ITEM = "This %1$s already exists in the %1$s list.";
    public static final String MESSAGE_NO_MENU_ITEM = "No such item in your menu. "
        + "If you'd like to have this order in the list, please add it to the menu first before trying again.";

    private final ModelEnum modelEnum;
    private final Index index;
    private final ItemDescriptor editItemDescriptor;

    /**
     * Creates an EditItemCommand to edit the specified {@code Item} at the target index with the new details.
     */
    public EditItemCommand(Index index, ItemDescriptor editItemDescriptor, ModelEnum modelEnum) {
        requireAllNonNull(index, editItemDescriptor, modelEnum);
        this.modelEnum = modelEnum;
        this.index = index;
        this.editItemDescriptor = editItemDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<? extends Item> lastShownTaskList = model.getFilteredItemList(modelEnum);

        if (index.getZeroBased() >= lastShownTaskList.size()) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_ITEM_DISPLAYED_INDEX,
                    modelEnum.toString().toLowerCase()));
        }

        Item itemToEdit = lastShownTaskList.get(index.getZeroBased());
        Item editedItem = createEditedItem((T) itemToEdit, editItemDescriptor);

        if (editedItem instanceof Order) {
            Order editedOrder = (Order) editedItem;
            List<MenuItem> currentMenuItems = model.getFilteredMenu();
            MenuItem existingItem = currentMenuItems.stream()
                .filter(item -> item.getItemName().getName()
                .equals(editedOrder.getOrderName().getName()))
                .findAny()
                .orElseThrow(() ->
                    new CommandException(MESSAGE_NO_MENU_ITEM));
        }

        if (!itemToEdit.isSameItem(editedItem) && model.hasItem(editedItem, modelEnum)) {
            throw new CommandException(String.format(MESSAGE_DUPLICATE_ITEM, modelEnum.toString().toLowerCase()));
        }

        model.setItem(itemToEdit, editedItem, modelEnum);
        model.updateFilteredItemList(PREDICATE_SHOW_ALL_ITEMS, modelEnum);
        return new CommandResult(String.format(MESSAGE_EDIT_ITEM_SUCCESS, modelEnum.toString().toLowerCase(),
                editedItem));
    }

    /**
     * Creates and returns a {@code Item} with the details of {@code itemToEdit} edited with {@code editItemDescriptor}.
     */
    protected abstract T createEditedItem(T itemToEdit, ItemDescriptor<? super T> itemDescriptor);

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditItemCommand)) {
            return false;
        }

        // state check
        EditItemCommand e = (EditItemCommand) other;
        return index.equals(e.index)
                && editItemDescriptor.equals(e.editItemDescriptor);
    }
}
