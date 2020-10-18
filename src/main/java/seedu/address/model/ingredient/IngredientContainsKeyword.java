package seedu.address.model.ingredient;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;



public class IngredientContainsKeyword implements Predicate<Ingredient> {

	private final List<String> keywords;

	/**
	 * Constructor
	 * @param keywords
	 */
	public IngredientContainsKeyword(List<String> keywords) {
		this.keywords = keywords;
	}


	public boolean test(Ingredient i) {
		return keywords.stream()
				.anyMatch(keyword -> StringUtil.containsWordIgnoreCase(i.getIngredientName().toString(), keyword));
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof IngredientContainsKeyword // instanceof handles nulls
				&& keywords.equals(((IngredientContainsKeyword) other).keywords)); // state check
	}

}
