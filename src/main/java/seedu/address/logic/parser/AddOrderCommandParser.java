package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DELIVERYDATETIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDERNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.orders.AddOrderCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.Address;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Name;
import seedu.address.model.order.Order;
import seedu.address.model.order.OrderName;
import seedu.address.model.order.Phone;
import seedu.address.model.order.Quantity;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddOrderCommand Object
 */
public class AddOrderCommandParser implements Parser<AddOrderCommand> {

    /**
     * Parses a given String of arguments in the context of the AddOrderCommand returns an AddOrderCommand for execution
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddOrderCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_ORDERNAME, PREFIX_QUANTITY, PREFIX_NAME,
                PREFIX_ADDRESS, PREFIX_DELIVERYDATETIME, PREFIX_PHONE, PREFIX_TAG);

        if (!arePrefixesPresent(argMultimap, PREFIX_ORDERNAME, PREFIX_QUANTITY, PREFIX_NAME,
        PREFIX_ADDRESS, PREFIX_DELIVERYDATETIME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddOrderCommand.MESSAGE_USAGE));
        }

        OrderName ordername = OrderParserUtil.parseOrderName(
            argMultimap.getValue(PREFIX_ORDERNAME).get());
        Name name = OrderParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Phone phone = OrderParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Address address = OrderParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        DeliveryDateTime deliveryDateTime = OrderParserUtil.parseDeliveryDateTime(argMultimap.getValue(PREFIX_DELIVERYDATETIME).get());
        Quantity quantity = OrderParserUtil.parseQuantity(argMultimap.getValue(PREFIX_QUANTITY).get());
        Set<Tag> tagList = OrderParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

        Order order = new Order(ordername, name, phone, address, deliveryDateTime, quantity, tagList);

        return new AddOrderCommand(order);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
