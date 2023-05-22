package coffee.order;


import java.util.*;

public class CoffeeOrderBoard {

    private Set<Order> orderSet;

    public CoffeeOrderBoard() {
        this.orderSet = new LinkedHashSet<>();
    }
    private static long maxOrderNum = 0;

    public void add(String customerName) {
        Order order = new Order( maxOrderNum + 1, customerName);
        maxOrderNum = order.getOrderNumber();
            if (orderSet.contains(order)) {
                throw new OrderException("Order with number " + order.getOrderNumber() + " already exist");
            }
        orderSet.add(order);
    }

    public void deliver() {
        if (orderSet.isEmpty()) {
            throw new OrderException("No orders in queue");
        }
        List<Order> orderList = orderSet.stream()
                .toList();
        Order closestOrder = orderList.get(0);
        orderSet.remove(closestOrder);
    }

    public void deliver(int orderNum) {
        if (orderNum < 0) {
            throw new OrderException("Order number must be above 0!");
        }
        orderSet.stream()
                .filter(order -> order.getOrderNumber() == orderNum)
                .findFirst()
                .ifPresent(order -> orderSet.remove(order));
    }


    public String draw() {
        String res = "Num | Name\n";
        String ordersString = "";
        for (Order order : orderSet) {
            ordersString = order.getOrderNumber() + " | " + order.getCustomerName() + "\n";
            res = res + ordersString;
        }
        return res;
    }
}
