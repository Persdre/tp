package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INGREDIENT;

import java.util.Arrays;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.ingredientcommands.IngredientFindCommand;
import seedu.address.logic.commands.ingredientcommands.IngredientViewSingleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientContainsKeyword;
import seedu.address.model.ingredient.IngredientName;

public class IngredientFindCommandParser implements Parser<IngredientFindCommand> {


	public IngredientFindCommand parse(String args) throws ParseException {
		requireNonNull(args);
		ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INGREDIENT);

		if (!arePrefixesPresent(argMultimap, PREFIX_INGREDIENT)
				|| !argMultimap.getPreamble().isEmpty()) {
			throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
					IngredientViewSingleCommand.MESSAGE_USAGE));
		}

		String trimmedArgs = args.trim();
		if (trimmedArgs.isEmpty()) {
			throw new ParseException(
					String.format(MESSAGE_INVALID_COMMAND_FORMAT, IngredientFindCommand.MESSAGE_USAGE));
		}

		String[] keyWords = trimmedArgs.split("\\s+");

		return new IngredientFindCommand(new IngredientContainsKeyword(Arrays.asList(keyWords)));
	}

	/**
	 * Returns true if none of the prefixes contains empty {@code Optional} values in the given
	 * {@code ArgumentMultimap}.
	 */
	private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
		return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
	}
}
