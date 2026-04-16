package day_0416;

public class FourArithmetic {
    public static void main(String[] args) {
        int a, b, result;
        a = 12;
        b = 2;

        result = a + b;
        System.out.printf("a + b = %d\n", result);

        result = a - b;
        System.out.printf("a - b = %d\n", result);

        result = a * b;
        System.out.printf("a * b = %d\n", result);

        if (b > 0) {
            result = a / b;
            System.out.printf("a / b = %d\n", result);
        } else {
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
