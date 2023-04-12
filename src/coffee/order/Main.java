package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-Wan");
        coffeeOrderBoard.add("Vader");
        coffeeOrderBoard.add("Luke");

        coffeeOrderBoard.draw();
        
        System.out.println();

        Order deliveredOrder = coffeeOrderBoard.deliver();
        System.out.println("Order Number: " + deliveredOrder.getOrderNumber() + " Customer Name: " + deliveredOrder.getCustomerName());

        System.out.println();

        coffeeOrderBoard.draw();

        System.out.println();

        System.out.println(coffeeOrderBoard.deliver(3));
    }
}
