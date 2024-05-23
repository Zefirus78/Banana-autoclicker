package hw_7.coffee.order;

public class Application {
    public static void main(String[] args) {
        CoffeeOrderBoard pendingOrders = new CoffeeOrderBoard();

        pendingOrders.add("Mike");
        pendingOrders.add("Bob");
        pendingOrders.add("Jack");
        pendingOrders.add("Tom");
        pendingOrders.add("Jack");

        pendingOrders.draw();

        pendingOrders.deliver();

        pendingOrders.draw();

        pendingOrders.deliver(3);

        pendingOrders.draw();
    }
}
