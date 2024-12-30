package hw_7.coffee.order;

public class Order {
    private int orderId;
    private String customer;

    public Order(int orderId, String customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public Order setOrderId(int orderId) {
        this.orderId = orderId;
        return null;
    }

    public String getCustomer() {
        return customer;
    }

}
