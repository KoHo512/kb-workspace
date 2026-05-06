package practice_0430.test.common;

public class Order {
    private final int id;
    private final String customer;
    private final String status;
    private final int amount;
    public Order(int id, String customer, String status, int amount) {
        this.id = id; this.customer = customer; this.status = status; this.amount = amount;
    }
    public int getId() { return id; }
    public String getCustomer() { return customer; }
    public String getStatus() { return status; }
    public int getAmount() { return amount; }
    @Override public String toString() {
        return "Order{id=" + id + ", customer='" + customer + "', status='" + status + "', amount=" + amount + "}";
    }
}
