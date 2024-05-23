package hw_7.coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private final Queue<Order> orders = new LinkedList<>();
    private int orderIdCount = 1;

    public void add(String customerName) {
        Order newOrder = new Order(orderIdCount++,customerName);
        orders.add(newOrder);
    }

    public void deliver(){
        orders.remove();
    }

    public Order deliver(int orderId){
        for(Order o : orders){
            if(o.getOrderId() == orderId){
                orders.remove(o);
                return o;
            }
        }
        return null;
    }
    public void draw(){
        System.out.println("===========");
        System.out.println("ID| Name");
        for(Order o : orders){
            System.out.println(o.getOrderId() + " | " + o.getCustomer());
        }
    }
}
