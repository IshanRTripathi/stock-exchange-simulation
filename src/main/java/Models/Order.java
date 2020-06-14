package Models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParsePosition;

public class Order {
    private String timeStamp;
    private BigInteger id;
    private String client;
    private Side side;
    private String stock;
    private BigDecimal quantity;
    private BigDecimal price;

    public Order(String line) {
        String[] parts = line.split("[ @]");
        if ((parts.length != 5) && (parts.length != 8)) {
            throw new IllegalArgumentException("Incorrect number of parameters " + parts.length);
        }

        int offset = 0;
        if (parts.length == 8) {
            offset = 3;
            timeStamp = parts[0] + " " + parts[1];
            id = new BigInteger(parts[2]);
        } else {
            timeStamp = Environment.getCurrentTimeStamp();
            id = Environment.getNextOrderId();
        }

        client = parts[0 + offset];
        side = Side.valueOf(parts[1 + offset]);
        stock = parts[2 + offset];
        quantity = (BigDecimal) Environment.decimalFormat.parse(parts[3 + offset], new ParsePosition(0));
        price = (BigDecimal) Environment.decimalFormat.parse(parts[4 + offset], new ParsePosition(0));
    }

    public String toString() {
        return timeStamp + " " +
                id + " " +
                toStringShort();
    }

    public String toStringShort() {
        return client + " " +
                stock + " " +
                side + " " +
                Environment.decimalFormat.format(quantity) + "@" +
                Environment.decimalFormat.format(price);
    }

    public void decrease(BigDecimal decrement) {
        if (decrement.signum() <= 0) {
            throw new IllegalArgumentException("Decrement <= 0");
        }
        if (decrement.compareTo(quantity) > 0) {
            throw new IllegalArgumentException("Decrement > Quantity");
        }
        quantity = quantity.subtract(decrement);
    }

    String getTimeStamp() {
        return timeStamp;
    }

    String getClient() {
        return client;
    }

    public Side getSide() {
        return side;
    }

    String getStock() {
        return stock;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    BigInteger getId() {
        return id;
    }
}
