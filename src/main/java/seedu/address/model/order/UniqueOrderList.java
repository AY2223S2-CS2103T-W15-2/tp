package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.order.exceptions.DuplicateOrderException;
import seedu.address.model.order.exceptions.OrderNotFoundException;


/**
 * @see Order#isSameOrder(Order)
 */
public class UniqueOrderList implements Iterable<Order> {

    private final ObservableList<Order> internalList = FXCollections.observableArrayList();
    private final ObservableList<Order> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * returns true if the order is in the order list
     * @param toCheck
     * @return true or false
     */
    public boolean contains(Order toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameOrder);
    }

    /**
     * adds the order into the list
     * @param toAdd
     */
    public void add(Order toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateOrderException();
        }
        internalList.add(toAdd);
    }

    /**
     * set the target order to the editedOrder
     * @param target
     * @param editedOrder
     */
    public void setOrder(Order target, Order editedOrder) {
        requireAllNonNull(target, editedOrder);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new OrderNotFoundException();
        }

        if (!target.isSameOrder(editedOrder) && contains(editedOrder)) {
            throw new DuplicateOrderException();
        }
        internalList.set(index, editedOrder);
    }

    /**
     * remove the order
     * @param toRemove
     */
    public void remove(Order toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new OrderNotFoundException();
        }
    }

    /**
     * set the order as the replacement
     * @param replacement
     */
    public void setOrders(UniqueOrderList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * set the list of orders
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        requireNonNull(orders);
        if (!ordersAreUnique(orders)) {
            throw new DuplicateOrderException();
        }
        internalList.setAll(orders);
    }

    /**
     * returns the list
     * @return
     */
    public ObservableList<Order> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Order> iterator() {
        return internalList.iterator();
    }

    /**
     * returns true if all the orders are unique
     * @param orders
     * @return true or false
     */
    public boolean ordersAreUnique(List<Order> orders) {
        for (int i = 0; i < orders.size() - 1; i++) {
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(i).isSameOrder(orders.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

}
