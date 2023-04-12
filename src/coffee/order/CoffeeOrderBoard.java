package coffee.order;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoffeeOrderBoard {

    private List<Order> orders;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }

    public void add(String customerName) {
        long maxOrderNum = 0;
        for (Order orderNum : orders) {
            maxOrderNum = Math.max(maxOrderNum, orderNum.getOrderNumber());
        }
        Order order = new Order(maxOrderNum + 1, customerName);
        for (Order existingOrder : orders) {
            if (existingOrder == order) {
                System.out.println("Order with number " + order.getOrderNumber() + " already exist");
                return;
            }
        }
        orders.add(order);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            System.out.println("No orders in queue");
            return null;
        }
        Order closestOrder = orders.get(0);
        orders.remove(0);
        return closestOrder;
    }

    public Order deliver(int orderNum) {
        Objects.requireNonNull(orderNum);
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNum) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }


    public List<Order> draw() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
        return orders;
    }
}
