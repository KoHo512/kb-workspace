package day_0416;

public class FourArithmeticMethod {
    public static void main(String[] args) {
        int a, b;
        a = 12;
        b = 2;

        for (int i = 1; i < 6; i++) {
            System.out.printf("=== %d번 호출 ===\n", i);
            fourMethod(a, b);
        }
    }

    public static void fourMethod(int a, int b) {
        int result;

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
