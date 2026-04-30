package day_0430.stream;

import java.util.Arrays;

public class Ex09_MatchingTodo {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6};

        // TODO 1: 모든 요소가 2의 배수인지 검사
        boolean allEven = Arrays.stream(arr)
                .allMatch(n -> n % 2 == 0);
        System.out.println("모든 요소가 2의 배수인지 : " + allEven);


        // TODO 2: 하나라도 3의 배수가 있는지 검사
        boolean anyMultiOfThree = Arrays.stream(arr)
                .anyMatch(n -> n % 3 == 0);
        System.out.println("하나라도 3의 배수가 있는지 : " + anyMultiOfThree);


        // TODO 3: 3의 배수가 하나도 없는지 검사
        boolean noneMatchOfThree = Arrays.stream(arr)
                .noneMatch(n -> n % 3 == 0);
        System.out.println("3의 배수가 하나도 없는지 : " + noneMatchOfThree);
    }
}
