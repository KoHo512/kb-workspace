package practice_0430.test.common;

public class CartItem {
    private final String name;
    private final int price;
    private final int quantity;
    public CartItem(String name, int price, int quantity) {
        this.name = name; this.price = price; this.quantity = quantity;
    }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public int getTotalPrice() { return price * quantity; }
    @Override public String toString() {
        return "CartItem{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }
}
