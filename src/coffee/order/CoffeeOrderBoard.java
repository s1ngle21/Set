package coffee.order;


import java.util.*;

public class CoffeeOrderBoard {

    private Queue<Order> orderQueue;
    private long maxOrderNum = 1;

    public CoffeeOrderBoard() {
        this.orderQueue = new LinkedList<>();
    }

    public void add(String customerName) {
        Order order = new Order(maxOrderNum, customerName);
        maxOrderNum = order.getOrderNumber();
        maxOrderNum++;
        orderQueue.add(order);
    }

    public Order deliver() {
        if (orderQueue.isEmpty()) {
            throw new OrderException("No orders in queue");
        }
        return orderQueue.poll();
    }

    public Order deliver(final int orderNum) {
        if (orderNum < 0) {
            throw new OrderException("Order number must be above 0!");
        }
        Order order = orderQueue.stream()
                .filter(o -> o.getOrderNumber() == orderNum)
                .findFirst()
                .orElseThrow(() -> new OrderException("There is no order with such order number: " + orderNum));
        orderQueue.remove(order);
        return order;
    }


    public String draw() {
        String res = "Num | Name\n";
        String ordersString = "";
        for (Order order : orderQueue) {
            ordersString = order.getOrderNumber() + " | " + order.getCustomerName() + "\n";
            res = res + ordersString;
        }
        return res;
    }
}
