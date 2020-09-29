package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Remark;

//@@author ngzhenteng-reused
//Reused from https://nus-cs2103-ay2021s1.github.io/tp/tutorials/AddRemark.html
public class RemarkCommandParser implements Parser {

    /**
     * Parses {@code userInput} into a command and returns it.
     *
     * @param userInput
     */
    @Override
    public RemarkCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argsMultiMap = ArgumentTokenizer.tokenize(userInput, PREFIX_REMARK);

        Index index;
        try {
            index = ParserUtil.parseIndex(argsMultiMap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    RemarkCommand.MESSAGE_USAGE), ive);
        }

        String remark = argsMultiMap.getValue(PREFIX_REMARK).orElse("");

        return new RemarkCommand(index, new Remark(remark));
    }
}
//@@author
