package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Yoda");
        coffeeOrderBoard.add("Obi-Wan");
        coffeeOrderBoard.add("Vader");
        coffeeOrderBoard.add("Luke");

        System.out.println(coffeeOrderBoard.draw());
        
        System.out.println();

        System.out.println(coffeeOrderBoard.deliver());

        System.out.println();

        System.out.println(coffeeOrderBoard.draw());

        System.out.println();

        System.out.println(coffeeOrderBoard.deliver(3));

        System.out.println();

        System.out.println(coffeeOrderBoard.draw());

        System.out.println(coffeeOrderBoard.deliver(3));
    }
}
