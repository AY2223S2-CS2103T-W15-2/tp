package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Order Object
 */
public class Order {

    private final OrderName ordername;
    private final Name name;
    private final Phone phone;
    private final Address address;
    private final DeliveryDateTime deliveryDateTime;
    private final Quantity quantity;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Order constructor
     * @param ordername
     * @param name
     * @param phone
     * @param address
     * @param deliveryDateTime
     * @param quantity
     * @param tags
     */
    public Order(OrderName ordername, Name name, Phone phone, Address address,
        DeliveryDateTime deliveryDateTime, Quantity quantity, Set<Tag> tags) {
        requireAllNonNull(ordername, name, phone, address, deliveryDateTime, quantity, tags);
        this.ordername = ordername;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.deliveryDateTime = deliveryDateTime;
        this.quantity = quantity;
        this.tags.addAll(tags);
    }

    /**
     * returns the order name of the order
     * @return
     */
    public OrderName getOrderName() {
        return ordername;
    }

    /**
     * returns the customer name
     * @return
     */
    public Name getName() {
        return name;
    }

    /**
     * returns the phone number of the order
     * @return
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * returns the address of the order
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * returns of the quantity of the rder
     * @return
     */
    public Quantity getQuantity() {
        return quantity;
    }

    /**
     * returns the delivery date and time of the order
     * @return
     */
    public DeliveryDateTime getDeliveryDatetime() {
        return deliveryDateTime;
    }

    /**
     * returns the tags of the order
     * @return
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * returns true if the order is the same
     * @param otherOrder
     * @return
     */
    public boolean isSameOrder(Order otherOrder) {
        if (otherOrder == this) {
            return true;
        }

        return otherOrder != null
            && otherOrder.getName().equals(getName())
            && otherOrder.getOrderName().equals(getOrderName())
            && otherOrder.getAddress().equals(getAddress())
            && otherOrder.getPhone().equals(getPhone())
            && otherOrder.getDeliveryDatetime().equals(getDeliveryDatetime())
            && otherOrder.getTags().equals(getTags());
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }

        if(!(other instanceof Order)) {
            return false;
        }

        Order otherOrder = (Order) other;
        return otherOrder.getName().equals(getName())
            && otherOrder.getAddress().equals(getAddress())
            && otherOrder.getOrderName().equals(getOrderName())
            && otherOrder.getPhone().equals(getPhone())
            && otherOrder.getDeliveryDatetime().equals(getDeliveryDatetime())
            && otherOrder.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ordername, address, phone, deliveryDateTime, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Order Name: ")
                .append(getOrderName())
                .append("; Delivery Date and Time: ")
                .append(getDeliveryDatetime())
                .append("; Address: ")
                .append(getAddress())
                .append("; Phone: ")
                .append(getPhone());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}
