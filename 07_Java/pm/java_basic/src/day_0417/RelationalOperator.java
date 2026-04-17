package day_0417;

public class RelationalOperator {
    public static void main(String[] args) {
        int a = 4;

        System.out.println(a > 5);      // false
        System.out.println(a < 5);      // true
        System.out.println(a == 6);     // false
        System.out.println(a != 4);     // false
        System.out.println(3 >= a);     // false
        System.out.println(a <= a + 1); // true
    }
}
