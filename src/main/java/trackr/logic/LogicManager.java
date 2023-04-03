package trackr.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import trackr.commons.core.GuiSettings;
import trackr.commons.core.LogsCenter;
import trackr.logic.commands.Command;
import trackr.logic.commands.CommandResult;
import trackr.logic.commands.exceptions.CommandException;
import trackr.logic.parser.TrackrParser;
import trackr.logic.parser.exceptions.ParseException;
import trackr.model.Model;
import trackr.model.ReadOnlyMenu;
import trackr.model.ReadOnlyOrderList;
import trackr.model.ReadOnlySupplierList;
import trackr.model.ReadOnlyTaskList;
import trackr.model.menu.ItemProfit;
import trackr.model.menu.ItemSellingPrice;
import trackr.model.menu.MenuItem;
import trackr.model.order.Order;
import trackr.model.person.Supplier;
import trackr.model.task.Task;
import trackr.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final TrackrParser trackrParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        trackrParser = new TrackrParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = trackrParser.parseCommand(commandText);
        commandResult = command.execute(model);
        try {
            storage.saveTrackr(model.getSupplierList(), model.getTaskList(), model.getMenu(), model.getOrderList());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlySupplierList getSupplierList() {
        return model.getSupplierList();
    }

    @Override
    public ObservableList<Supplier> getFilteredSupplierList() {
        return model.getFilteredSupplierList();
    }

    @Override
    public ReadOnlyTaskList getTaskList() {
        return model.getTaskList();
    }

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return model.getFilteredTaskList();
    }

    @Override
    public ReadOnlyMenu getMenu() {
        return model.getMenu();
    }

    @Override
    public ObservableList<MenuItem> getFilteredMenu() {
        return model.getFilteredMenu();
    }

    @Override
    public ReadOnlyOrderList getOrderList() {
        return model.getOrderList();
    }

    @Override
    public ObservableList<Order> getFilteredOrderList() {
        return model.getFilteredOrderList();
    }

    @Override
    public ItemProfit getTotalProfits() {
        ObservableList<Order> allOrders = model.getFilteredOrderList();
        Double total = allOrders.stream()
                        .map(x -> x.getTotalProfit().getValue())
                        .reduce(0.0, (subTotal, element) -> subTotal + element);
        return new ItemProfit(total);
    }

    @Override
    public ItemSellingPrice getTotalSales() {
        ObservableList<Order> allOrders = model.getFilteredOrderList();
        Double total = allOrders.stream()
                        .map(x -> x.getTotalRevenue().getValue())
                        .reduce(0.0, (subTotal, element) -> subTotal + element);
        return new ItemSellingPrice(total);
    }

    @Override
    public Path getTrackrFilePath() {
        return model.getTrackrFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
