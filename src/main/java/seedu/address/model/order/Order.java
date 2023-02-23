package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

public class Order {

    private final OrderName ordername;
    private final Name name;
    private final Phone phone;
    private final Address address;
    private final DeliveryDateTime deliveryDateTime;
    private final Quantity quantity;
    private final Set<Tag> tags = new HashSet<>();

    public Order(OrderName ordername, Name name, Phone phone, Address address, DeliveryDateTime deliveryDateTime, Quantity quantity, Set<Tag> tags) {
        requireAllNonNull(ordername, name, phone, address, deliveryDateTime, quantity, tags);
        this.ordername = ordername;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.deliveryDateTime = deliveryDateTime;
        this.quantity = quantity;
        this.tags.addAll(tags);
    }

    public OrderName getOrderName() {
        return ordername;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public DeliveryDateTime getDeliveryDatetime() {
        return deliveryDateTime;
    }

    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

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
