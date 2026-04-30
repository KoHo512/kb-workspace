package day_0430.stream;

import java.util.Arrays;

public class Ex10_BasicAggregateTodo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // TODO: 짝수 기준 count, sum, average, max, min을 구하고 출력하세요.
        long count = Arrays.stream(arr).filter(n -> n % 2 == 0).count();
        System.out.println("짝수 개수 : " + count);

        long sum = Arrays.stream(arr).filter(n -> n % 2 == 0).sum();
        System.out.println("짝수 합계 : " + sum);

        double average = Arrays.stream(arr).filter(n -> n % 2 == 0).average().orElse(0.0);
        System.out.println("짝수 평균 : " + average);

        int max = Arrays.stream(arr).filter(n -> n % 2 == 0).max().orElse(0);
        System.out.println("짝수 최댓값 : " + max);

        int min = Arrays.stream(arr).filter(n -> n % 2 == 0).min().orElse(0);
        System.out.println("짝수 최솟값 : " + min);

        // TODO: 3의 배수 중 첫 번째 값을 findFirst로 구하세요.
        long findFirst = Arrays.stream(arr).filter(n -> n % 3 == 0).findFirst().orElse(-1);
        System.out.println("첫 번째 3의 배수 : " + findFirst);
    }
}
