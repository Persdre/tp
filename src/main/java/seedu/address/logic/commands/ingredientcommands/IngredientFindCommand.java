package seedu.address.logic.commands.ingredientcommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.FindCommand;
import seedu.address.model.Model;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientContainsKeyword;


public class IngredientFindCommand extends Command {

	public static final String COMMAND_WORD = "i-find";

	public static final char LINE_SEPARATOR = '\n';

	public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all ingredients whose names contain any of "
			+ "the specified keywords (case-insensitive) and displays them. \n"
			+ "Parameters: KEYWORD [MORE_KEYWORDS]... \n"
			+ "Example: " + COMMAND_WORD + " Pearl";

	public static final String MESSAGE_SUCCESS = "Here is the ingredient and its level: %1$s";
	private final IngredientContainsKeyword target;
	private String ingredientList = "";


	public IngredientFindCommand(IngredientContainsKeyword target) {
		this.target = target;
	}

	@Override
	public CommandResult execute(Model model) {
		requireNonNull(model);
		List<Ingredient> lastShownList = model.getFilteredIngredientList();
		for (Ingredient i : lastShownList) {
			if(target.test(i)) {
				ingredientList += i.toString() + LINE_SEPARATOR;
			}
		}
		return new CommandResult(MESSAGE_SUCCESS + ingredientList);
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof FindCommand // instanceof handles nulls
				&& target.equals(((IngredientFindCommand) other).target)); // state check
	}
}
