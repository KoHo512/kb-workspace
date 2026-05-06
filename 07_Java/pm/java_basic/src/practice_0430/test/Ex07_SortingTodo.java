package practice_0430.test;

import practice_0430.test.common.Product;

import java.util.Comparator;
import java.util.List;

public class Ex07_SortingTodo {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "키보드", "PC", 45000, 12),
                new Product(2, "마우스", "PC", 25000, 0),
                new Product(3, "노트북", "PC", 1200000, 3),
                new Product(4, "텀블러", "LIFE", 18000, 30)
        );

        // TODO 1: 가격 오름차순으로 정렬해 출력하세요.
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);

        System.out.println();

        // TODO 2: 재고 내림차순으로 정렬해 출력하세요.
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println();

        // TODO 3: 카테고리 오름차순, 같은 카테고리에서는 가격 내림차순으로 정렬하세요.
        products.stream()
                .sorted(Comparator.comparing(Product::getCategory)
                        .thenComparing(Comparator.comparing(Product::getPrice).reversed()))
                .forEach(System.out::println);
    }
}
