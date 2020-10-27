package seedu.address.logic.commands.view;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MISSIONS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all mission deadlines.
 */
public class ViewMissionDeadlineCommand extends ViewCommand {
    public static final String MESSAGE_SUCCESS = "Listed all current mission deadlines";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateMissionsList(PREDICATE_SHOW_ALL_MISSIONS);

        return new CommandResult(MESSAGE_SUCCESS, ViewCommandType.ViewMissions);
    }
}