package trackr.model.menu;

import static java.util.Objects.requireNonNull;
import static trackr.commons.util.AppUtil.checkArgument;

public class ItemPrice {
    public static final String MESSAGE_CONSTRAINTS =
            "Price should only contain numbers, and it should be at most 3 digits long";
    public static final String VALIDATION_REGEX = "^([1-9]{0,3})$";
    public final String value;

    /**
     * Constructs an Price Quantity Object
     */
    public ItemPrice(String value) {
        requireNonNull(value);
        checkArgument(isValidPrice(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Returns true if a given string is a valid price.
     */
    public static boolean isValidPrice(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ItemPrice // instanceof handles nulls
                && value.equals(((ItemPrice) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
