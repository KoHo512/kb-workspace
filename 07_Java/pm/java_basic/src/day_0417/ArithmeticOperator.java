package day_0417;

public class ArithmeticOperator {
    public static void main(String[] args) {
        int digit = 3625;

        System.out.println("일의 자릿수 : " + (digit % 10));
        System.out.println("십의 자릿수 : " + (digit / 10 % 10));
        System.out.println("백의 자릿수 : " + (digit / 100 % 10));
        System.out.println("천의 자릿수 : " + (digit / 1000 % 10));


        // 짝수 홀수
        int su = 5;

        if (su % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }
    }
}
