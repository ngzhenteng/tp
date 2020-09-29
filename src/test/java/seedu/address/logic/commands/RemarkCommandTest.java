package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TypicalPersons;

class RemarkCommandTest {

    private Model actualModel = new ModelManager(TypicalPersons.getTypicalAddressBook(), new UserPrefs());
    
    @Test
    void execute_addRemarkUnfilteredList_success() {

        Person personToEdit = actualModel.getFilteredPersonList().get(Index.fromZeroBased(0).getZeroBased());
        Person editedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), new Remark("very good guy"), personToEdit.getTags());

        RemarkCommand rCommand = new RemarkCommand(Index.fromZeroBased(0), new Remark("very good guy"));
        // CommandResult
        String expectedMessage = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, editedPerson);
        Model expectedModel = new ModelManager(actualModel.getAddressBook(), new UserPrefs());
        expectedModel.setPerson(personToEdit, editedPerson);

        CommandTestUtil.assertCommandSuccess(rCommand, actualModel, expectedMessage, expectedModel);

    }

    @Test
    void execute_deleteRemarkUnfilteredList_success() {

        RemarkCommand remarkCommand = new RemarkCommand(Index.fromZeroBased(0), new Remark(""));

        Person personToEdit = actualModel.getFilteredPersonList().get(Index.fromZeroBased(0).getZeroBased());
        Person editedPerson = new PersonBuilder(personToEdit).withRemark("").build();

        String expectedMessage = String.format(RemarkCommand.MESSAGE_DELETE_REMARK_SUCCESS, editedPerson);
        Model expectedModel = new ModelManager(actualModel.getAddressBook(), new UserPrefs());
        expectedModel.setPerson(personToEdit, editedPerson);

        CommandTestUtil.assertCommandSuccess(remarkCommand, actualModel, expectedMessage, expectedModel);

    }

    @Test
    void execute_invalidIndexUnfilteredList_failure() {

        Index outOfBounds = Index.fromZeroBased(actualModel.getFilteredPersonList().size());
        RemarkCommand remarkCommand = new RemarkCommand(outOfBounds, new Remark("out of bounds!"));

        CommandTestUtil.assertCommandFailure(remarkCommand, actualModel,
                Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);

    }

}
