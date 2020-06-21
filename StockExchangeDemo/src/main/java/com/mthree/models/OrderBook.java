package com.mthree.models;
import com.mthree.support.*;
import java.math.BigDecimal;
import java.util.*;

public class OrderBook {

    /**
     * {stock:GOOGL} => {price:42.21} => [ {order2}, {order1}, ... ]
     */
    private final Map<String, SortedMap<BigDecimal, SortedSet<Order>>> orderBook = new HashMap<>();

    private final Side side;

    private final Comparator<BigDecimal> priceComparator;

    private final Comparator<Order> orderComparator = Comparator.comparing(Order::getTimeStamp).thenComparing(Order::getId);

    public static OrderBook buildBuyOrderBook()
    {
        return new OrderBook(Side.BUY, Comparator.reverseOrder());
    }

    public static OrderBook buildSellOrderBook()
    {
        return new OrderBook(Side.SELL, BigDecimal::compareTo);
    }

    private OrderBook(final Side side, final Comparator<BigDecimal> priceComparator) {
        this.side = side;
        this.priceComparator = priceComparator;
    }

    public void addOrder(final Order order) {
        if (order.getSide() != this.side)
            throw new IllegalArgumentException("Trying to add an illegal order side.");

        orderBook.putIfAbsent(order.getStock(), new TreeMap<>(priceComparator));
        orderBook.get(order.getStock()).putIfAbsent(order.getPrice(), new TreeSet<>(orderComparator));
        orderBook.get(order.getStock()).get(order.getPrice()).add(order);
    }

    public Order matchOrder(final Order order) {
        if (order.getSide() != this.side.getOppositeSide())
            throw new IllegalArgumentException("Trying to match an illegal order side.");

        if (!orderBook.containsKey(order.getStock()))
            return null;

        SortedMap<BigDecimal, SortedSet<Order>> ordersByPrice = orderBook.get(order.getStock());
        BigDecimal matchingPrice = !ordersByPrice.isEmpty() ? ordersByPrice.firstKey() : null;
        if (matchingPrice != null && isPriceAcceptable(matchingPrice, order.getPrice())) {
            return ordersByPrice.get(matchingPrice).first();
        } else {
            return null;
        }
    }

    private boolean isPriceAcceptable(final BigDecimal ourPrice, final BigDecimal priceOffered) {
        return side == Side.BUY && ourPrice.compareTo(priceOffered) >= 0 ||
                side == Side.SELL && ourPrice.compareTo(priceOffered) <= 0;
    }

    public void removeOrder(final Order order) {
        if (order.getSide() != this.side)
            throw new IllegalArgumentException("Trying to remove an illegal order side.");

        SortedMap<BigDecimal, SortedSet<Order>> ordersByPrice = orderBook.get(order.getStock());
        if (ordersByPrice != null && ordersByPrice.containsKey(order.getPrice())) {
            ordersByPrice.get(order.getPrice()).remove(order);
            if (ordersByPrice.get(order.getPrice()).isEmpty()) {
                ordersByPrice.remove(order.getPrice());
            }
        }
    }
}
