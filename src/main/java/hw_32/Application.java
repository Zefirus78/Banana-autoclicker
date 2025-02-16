package hw_32;

import hw_32.coffee.CoffeeOrderBoard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Application {

    private static final Logger LOGGER  = LogManager.getLogger(Application.class.getName());

    public static void main(String[] args) {
        CoffeeOrderBoard pendingOrders = new CoffeeOrderBoard();

        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\nCoffee Order Board:\n");
            System.out.println("1. Add Order");
            System.out.println("2. Deliver Order");
            System.out.println("3. Deliver Order with specific Id");
            System.out.println("4. Exit");
            System.out.println("Enter your option: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter customer Name: ");
                    String customerName = sc.nextLine();
                    pendingOrders.add(customerName);
                    pendingOrders.draw();
                    break;
                case 2:
                    pendingOrders.deliver();
                    pendingOrders.draw();
                    break;
                case 3:
                    System.out.println("Enter customer ID to be delivered: ");
                    int id = sc.nextInt();
                    pendingOrders.deliver(id);
                    pendingOrders.draw();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    LOGGER.error("Invalid option");
                    System.out.println("Invalid option!");

            }
        }
    }
}
