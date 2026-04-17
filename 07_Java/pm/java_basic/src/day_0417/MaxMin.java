package day_0417;

import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("첫번째 값 : ");
        int a = input.nextInt();
        System.out.print("두번째 값 : ");
        int b = input.nextInt();

        int max = a > b ? a : b;    // Math.max(a, b)
        int min = a < b ? a : b;    // Math.min(a, b) 함수를 사용할 수 있음

        System.out.printf("max: %d, min: %d", max, min);
    }
}
