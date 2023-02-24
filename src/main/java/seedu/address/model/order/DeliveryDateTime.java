package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Delivery Date and time of the order
 */
public class DeliveryDateTime {

    public static final String MESSAGE_CONSTRAINTS = "Date and time should only contain numbers," +
    "and it should be in the form dd/MM/yyyy HHmm";
    private static final String pattern = "dd/MM/yyyy HHmm";

    public final LocalDateTime value;

    /**
     * Constructs the delivery date and time of the order
     * @param datetime
     */
    public DeliveryDateTime(String datetime) {
        requireNonNull(datetime);
        checkArgument(isValidDate(datetime), MESSAGE_CONSTRAINTS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime parseDateTime = LocalDateTime.parse(datetime, formatter);
        value = parseDateTime;
    }

    /**
     * returns true if the date and time are valid
     * @param test
     * @return
     */
    public static boolean isValidDate(String test) {
        try {
            new SimpleDateFormat(pattern).parse(test);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this
            || (other instanceof DeliveryDateTime
            && value.equals(((DeliveryDateTime) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
