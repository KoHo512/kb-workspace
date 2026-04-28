package day_0428.sort.product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductSortExample {
    public static void run() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3L, "키보드", 45000, LocalDateTime.of(2026, 4, 20, 10, 0)));
        products.add(new Product(1L, "마우스", 25000, LocalDateTime.of(2026, 4, 21, 9, 30)));
        products.add(new Product(4L, "모니터", 230000, LocalDateTime.of(2026, 4, 18, 15, 20)));
        products.add(new Product(2L, "노트북", 1200000, LocalDateTime.of(2026, 4, 22, 11, 10)));

        System.out.println("상품 ID 오름차순: Comparable");
        Collections.sort(products);
        print(products);

        System.out.println("\n가격 낮은 순: Comparator");
        products.sort(Comparator.comparingInt(Product::getPrice));
        print(products);

        System.out.println("\n가격 높은 순: Comparator");
        products.sort(Comparator.comparingInt(Product::getPrice).reversed());
        print(products);

        System.out.println("\n최신 등록순: Comparator");
        products.sort(Comparator.comparing(Product::getCreatedAt).reversed());
        print(products);
    }

    private static void print(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
