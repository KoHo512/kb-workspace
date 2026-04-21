package student.ch04_control;

import java.util.stream.IntStream;

/*
문제 12. 중첩 for문
다음과 같이 별이 출력되도록 코드를 작성하세요.

출력 결과:
*
**
***
****
*****
*/
public class Q04_StarTriangle {
    public static void main(String[] args) {
        // TODO: 중첩 for문으로 별 삼각형을 출력하세요.
        printTriangle(5);
        printTriangle_api(5);
    }

    private static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printTriangle_api(int n) {
        IntStream.rangeClosed(1, n).forEach(i -> System.out.println("*".repeat(i)));
    }
}
