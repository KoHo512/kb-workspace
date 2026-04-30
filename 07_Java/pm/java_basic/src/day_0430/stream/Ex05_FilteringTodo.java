package day_0430.stream;

import java.util.List;

public class Ex05_FilteringTodo {
    public static void main(String[] args) {
        List<String> names = List.of("홍길동", "신용권", "감자바", "신용권", "신민철");

        // TODO 1: distinct()로 중복 제거 후 출력
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        // TODO 2: filter()로 "신"으로 시작하는 이름만 출력
        names.stream()
                .filter(name ->name.startsWith("신"))
                .forEach(System.out::println);

        System.out.println();

        // TODO 3: 중복 제거 후 "신"으로 시작하는 이름만 출력
        names.stream()
                .distinct()
                .filter(name ->name.startsWith("신"))
                .forEach(System.out::println);
    }
}
