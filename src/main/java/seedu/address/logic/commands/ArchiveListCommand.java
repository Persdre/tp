package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ARCHIVED_PERSONS;

import seedu.address.model.Model;



/**
 * Shows all archived persons.
 */
public class ArchiveListCommand extends Command {

    public static final String COMMAND_WORD = "c-archive-list";

    public static final String MESSAGE_SUCCESS = "Listed all archived employees in Employee Directory.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_ARCHIVED_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
