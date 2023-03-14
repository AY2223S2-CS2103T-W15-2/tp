package trackr.logic.commands;

import static java.util.Objects.requireNonNull;

import trackr.model.SupplierList;
import trackr.model.Model;

/**
 * Clears the supplier list.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Supplier list has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAddressBook(new SupplierList());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
