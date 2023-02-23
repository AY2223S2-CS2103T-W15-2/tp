package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.Address;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Name;
import seedu.address.model.order.OrderName;
import seedu.address.model.order.Phone;
import seedu.address.model.order.Quantity;
import seedu.address.model.tag.Tag;


public class OrderParserUtil {

    public static OrderName parseOrderName(String ordername) throws ParseException {
        requireNonNull(ordername);
        System.out.println(ordername);
        String trimmedOrderName = ordername.trim();
        System.out.println(trimmedOrderName);
        if(!OrderName.isValidOrderName(trimmedOrderName)) {
            throw new ParseException(OrderName.MESSAGE_CONSTRAINTS);
        }
        return new OrderName(trimmedOrderName);
    }

    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if(!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    public static DeliveryDateTime parseDeliveryDateTime(String deliverydatetime) throws ParseException {
        requireNonNull(deliverydatetime);
        String trimmedDeliveryDateTime = deliverydatetime.trim();
        if(!DeliveryDateTime.isValidDate(trimmedDeliveryDateTime)) {
            throw new ParseException(DeliveryDateTime.MESSAGE_CONSTRAINTS);
        }
        return new DeliveryDateTime(trimmedDeliveryDateTime);
    }

    public static Quantity parseQuantity(String quantity) throws ParseException {
        requireNonNull(quantity);
        String trimmedQuantity = quantity.trim();
        if(!Quantity.isValidQuantity(trimmedQuantity)) {
            throw new ParseException(Quantity.MESSAGE_CONSTRAINTS);
        }
        return new Quantity(trimmedQuantity);
    }

    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
