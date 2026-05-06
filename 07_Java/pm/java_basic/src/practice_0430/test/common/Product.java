package practice_0430.test.common;

public class Product {
    private final int id;
    private final String name;
    private final String category;
    private final int price;
    private final int stock;
    public Product(int id, String name, String category, int price, int stock) {
        this.id = id; this.name = name; this.category = category; this.price = price; this.stock = stock;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    @Override public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + ", stock=" + stock + "}";
    }
}
