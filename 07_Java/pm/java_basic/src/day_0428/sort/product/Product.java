package day_0428.sort.product;

import java.time.LocalDateTime;

public class Product implements Comparable<Product> {
    private Long id;
    private String name;
    private int price;
    private LocalDateTime createdAt;

    public Product(Long id, String name, int price, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // 상품의 기본 정렬 기준: 상품 ID 오름차순
    @Override
    public int compareTo(Product other) {
        return Long.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
