package trackr.logic.commands;

import static java.util.Objects.requireNonNull;
import static trackr.logic.parser.CliSyntax.PREFIX_TAB;
import static trackr.ui.TabPanel.switchToTab;

import trackr.commons.core.index.Index;
import trackr.logic.commands.exceptions.CommandException;
import trackr.model.Model;

public class TabCommand extends Command {
    public static final String MESSAGE_SUCCESS = "Switched tab.";
    public static final String COMMAND_WORD = "switch";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Switches to specified tab. "
            + "Parameters: "
            + PREFIX_TAB + "TAB NAME\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TAB + "Home";

    private final Index targetTab;

    /**
     * Creates a SwitchTabCommand to switch to specified tab {@code index}
     */
    public TabCommand(Index targetTab) {
        requireNonNull(targetTab);
        this.targetTab = targetTab;
    }

    @Override
    public CommandResult execute(Model unused) throws CommandException {
        switchToTab(targetTab);
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
