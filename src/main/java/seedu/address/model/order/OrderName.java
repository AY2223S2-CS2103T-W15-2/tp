package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Order Name of the order
 */
public class OrderName {

    public static final String MESSAGE_CONSTRAINTS =
            "Order Names should only contain alphanumeric characters and spaces, and it should not be blank";

    public static final String VALIDATION_REGEK = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String value;

    /**
     * Order Name object
     * @param orderName
     */
    public OrderName(String orderName) {
        requireNonNull(orderName);
        checkArgument(isValidOrderName(orderName), MESSAGE_CONSTRAINTS);
        value = orderName;
    }

    /**
     * returns true if order name is valid
     * @param test
     * @return boolean true or false
     */
    public static boolean isValidOrderName(String test) {
        return test.matches(VALIDATION_REGEK);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof OrderName // instanceof handles nulls
                && value.equals(((OrderName) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
