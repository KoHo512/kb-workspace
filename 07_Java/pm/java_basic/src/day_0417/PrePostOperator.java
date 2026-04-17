package day_0417;

public class PrePostOperator {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a++);    // 10
        System.out.println(a);      // 11
        System.out.println(++a);    // 12

        int b = 10;
        System.out.println(b--);    // 10
        System.out.println(b);      // 9
        System.out.println(--b);    // 8

        int x = 10;
        System.out.println(--x);    // 9
        System.out.println(x++);    // 9
        System.out.println(x--);    // 10
        System.out.println(++x);    // 10
        System.out.println(x);      // 10
    }
}
