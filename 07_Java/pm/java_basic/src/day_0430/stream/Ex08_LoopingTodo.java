package day_0430.stream;

import java.util.Arrays;

public class Ex08_LoopingTodo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // TODO 1: 짝수만 필터링하고 peek로 중간 출력한 뒤 sum으로 합계를 구하세요.
        int total = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("peek() 중간 확인 : " + n))
                .sum();
        System.out.println("합계 : " + total);

        // TODO 2: forEach로 짝수만 최종 출력하세요.
        Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
