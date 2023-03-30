package trackr.model.order;

import java.util.HashMap;

import trackr.model.commons.Status;

/**
 * Represents an Order's status in the order list.
 * Guaruntees: immutable; is valid as declared in {@link #isValidStatus(String, HashMap)}
 */
public class OrderStatus extends Status {

    public static final HashMap<String, String> STATUSES;

    static {
        STATUSES = new HashMap<>();
        STATUSES.put("N", "Not Delivered");
        STATUSES.put("I", "In Progress");
        STATUSES.put("D", "Delivered");
    }

    /**
     * Constructs a {@code OrderStatus}.
     *
     * @param status A valid status.
     */
    public OrderStatus(String status) {
        super(status, "Order", STATUSES);
    }

    /**
     * Constructs a {@code TaskStatus}.
     */
    public OrderStatus() {
        this("N");
    }

    /**
     * Compares this status to a given status.
     * @return -1, 1 or 0 according to the status sorting criteria.
     *         OrderStatus have descending sorting priority in the order: N > I > D.
     *         Returns -1 this order status has a higher sorting priority,
     *         1 if this order status has a lower sorting priority,
     *         0 if both statuses are the same.
     */

    @Override
    public int compare(Status other) {
        if (toJsonString().equalsIgnoreCase(other.toJsonString())) {
            //both statuses are the same
            return 0;
        }

        //this status has a higher sorting priority than the other status

        //this status is not done or in progress and the other status is done
        if (toJsonString().equalsIgnoreCase("N")
                || toJsonString().equalsIgnoreCase("I")
                && other.toJsonString().equalsIgnoreCase("D")) {
            return -1;
        }
        //this status is not done and the other is in progress
        if (toJsonString().equalsIgnoreCase("N")
                && other.toJsonString().equalsIgnoreCase("I")) {
            return -1;
        }

        // this status has a lower sorting priority than the other status
        return 1;
    }

}
