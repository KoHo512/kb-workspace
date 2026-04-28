package day_0428.sort.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderSortExample {
    public static void run() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1003L, "김고객", 45000, LocalDateTime.of(2026, 4, 20, 10, 0)));
        orders.add(new Order(1001L, "이고객", 120000, LocalDateTime.of(2026, 4, 21, 11, 30)));
        orders.add(new Order(1004L, "박고객", 120000, LocalDateTime.of(2026, 4, 22, 9, 20)));
        orders.add(new Order(1002L, "최고객", 30000, LocalDateTime.of(2026, 4, 19, 15, 40)));

        System.out.println("주문번호 오름차순: Comparable");
        Collections.sort(orders);
        print(orders);

        System.out.println("\n주문금액 높은 순: Comparator");
        orders.sort(Comparator.comparingInt(Order::getTotalPrice).reversed());
        print(orders);

        System.out.println("\n주문일 최신순: Comparator");
        orders.sort(Comparator.comparing(Order::getOrderDate).reversed());
        print(orders);

        System.out.println("\n주문금액 높은 순, 금액이 같으면 주문일 최신순");
        orders.sort(
                Comparator.comparingInt(Order::getTotalPrice).reversed()
                        .thenComparing(Comparator.comparing(Order::getOrderDate).reversed())
        );
        print(orders);
    }

    private static void print(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
