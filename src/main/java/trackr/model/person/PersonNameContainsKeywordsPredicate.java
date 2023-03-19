package trackr.model.person;

import java.util.List;
import java.util.function.Predicate;

import trackr.commons.util.StringUtil;

/**
 * Tests that a {@code Suppliers}'s {@code Name} matches any of the keywords given.
 */
public class PersonNameContainsKeywordsPredicate implements Predicate<Supplier> {
    private final List<String> keywords;

    public PersonNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Supplier supplier) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(supplier.getPersonName().getName(), keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((PersonNameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
