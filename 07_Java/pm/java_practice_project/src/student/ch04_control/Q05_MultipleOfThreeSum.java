package student.ch04_control;

// 파일명: MultipleOfThreeSum.java

import java.util.stream.IntStream;

public class Q05_MultipleOfThreeSum {

    public static void main(String[] args) {
        printResult(SumMultipleOfThree(100));
        SumMultipleOfThreeApi(100);
        mathResult(100);
    }

    private static int SumMultipleOfThree(int n) {
        // TODO 1: 총합을 저장할 변수 선언
        int total = 0;

        // TODO 2: 1부터 100까지 반복하는 for문 작성
        for (int i = 1; i <= n; i++) {

            // TODO 3: 3의 배수인지 조건문 작성
            if (i % 3 == 0) {

                // TODO 4: 총합에 값을 누적
                total += i;
            }
        }

        // TODO 5: 결과 출력
        return total;
    }

    private static void printResult(int result) {
        System.out.println("1-100까지 3의 배수의 합 : " + result);
    }

    private static void SumMultipleOfThreeApi(int n) {
        int sum = IntStream.rangeClosed(1, n).filter(i -> i % 3 == 0).sum();
        printResult(sum);
    }

    private static void mathResult(int n) {
        int number = n / 3;
        int sum = 3 * number * (number + 1) / 2;
        printResult(sum);
    }
}