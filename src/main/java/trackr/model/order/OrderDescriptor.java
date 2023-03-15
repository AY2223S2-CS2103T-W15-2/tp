package trackr.model.order;

import java.util.Optional;

import trackr.commons.util.CollectionUtil;

/**
 * Stores the details of an order. Each non-empty field value will replace the corresponding field value of the order.
 */
public class OrderDescriptor {
    private OrderName orderName;
    private OrderDeadline orderDeadline;
    private OrderStatus orderStatus;

    public OrderDescriptor() {}

    /**
     * Copy constructor.
     */
    public OrderDescriptor(OrderDescriptor toCopy) {
        setOrderName(toCopy.orderName);
        setOrderDeadline(toCopy.orderDeadline);
        setOrderStatus(toCopy.orderStatus);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldNonNull() {
        return CollectionUtil.isAnyNonNull(orderName, orderDeadline, orderStatus);
    }

    public void setOrderName(OrderName orderName) {
        this.orderName = orderName;
    }

    public Optional<OrderName> getOrderName() {
        return Optional.ofNullable(orderName);
    }

    public void setOrderDeadline(OrderDeadline orderDeadline) {
        this.orderDeadline = orderDeadline;
    }

    public Optional<OrderDeadline> getOrderDeadline() {
        return Optional.ofNullable(orderDeadline);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Optional<OrderStatus> getOrderStatus() {
        return Optional.ofNullable(orderStatus);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof OrderDescriptor)) {
            return false;
        }

        // state check
        OrderDescriptor orderDescriptor = (OrderDescriptor) other;

        return getOrderName().equals(orderDescriptor.getOrderName())
                && getOrderDeadline().equals(orderDescriptor.getOrderDeadline())
                && getOrderStatus().equals(orderDescriptor.getOrderStatus());
    }
}
