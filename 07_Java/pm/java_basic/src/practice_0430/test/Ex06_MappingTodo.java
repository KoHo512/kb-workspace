package practice_0430.test;

import practice_0430.test.common.Order;

import java.util.Arrays;
import java.util.List;

public class Ex06_MappingTodo {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "홍길동", "DONE", 30000),
                new Order(2, "김수영", "READY", 12000)
        );
        List<String> tagLines = List.of("java,stream,backend", "spring,api");

        // TODO 1: 주문 객체를 주문 금액 int 스트림으로 변환해 출력하세요.
        orders.stream()
                .mapToInt(Order::getAmount)
                .forEach(System.out::println);

        System.out.println();

        // TODO 2: 주문 객체를 고객명 문자열 스트림으로 변환해 출력하세요.
        orders.stream()
                .map(Order::getCustomer)
                .forEach(System.out::println);

        System.out.println();

        // TODO 3: tagLines를 콤마 기준으로 분리하여 단일 태그 스트림으로 출력하세요.
        tagLines.stream()
                .flatMap(tag -> Arrays.stream(tag.split(",")))
                .forEach(System.out::println);
    }
}
