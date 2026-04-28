package day_0428.sort.order;

import java.time.LocalDateTime;

public class Order implements Comparable<Order> {
    private Long orderId;
    private String customerName;
    private int totalPrice;
    private LocalDateTime orderDate;

    public Order(Long orderId, String customerName, int totalPrice, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    // 주문의 기본 정렬 기준: 주문번호 오름차순
    @Override
    public int compareTo(Order other) {
        return Long.compare(this.orderId, other.orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}
