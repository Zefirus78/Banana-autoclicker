package hw_32.coffee;
import hw_32.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoffeeOrderBoard {

    private static final Logger LOGGER  = LogManager.getLogger(CoffeeOrderBoard.class.getName());

    private final PriorityQueue<Order> orders = new PriorityQueue<>();
    private int orderIdCount = 1;

    public void add(String customerName) {
        Order newOrder = new Order(orderIdCount++,customerName);
        orders.add(newOrder);
        LOGGER.info("Order added: {}", newOrder);
    }

    public void deliver(){
        if(!orders.isEmpty()){
            Order removedOrder = orders.remove();
            LOGGER.info("Order removed: {}", removedOrder);
        } else {
            LOGGER.warn("Order Board is empty");
        }
    }

    public void deliver(int orderId){
        for(Order o : orders){
            if(o.getOrderId() == orderId){
                orders.remove(o);
                return;
            }
            LOGGER.info("Order with number {} has been delivered", o);
        }
        LOGGER.warn("Order with number {} not found", orderId);

    }
    public void draw(){
        System.out.println("===========");
        System.out.println("ID | Name");
        for(Order o : orders){
            System.out.println(o.getOrderId() + " | " + o.getCustomer());
        }
        LOGGER.info("Order Board drawn");
    }
}
