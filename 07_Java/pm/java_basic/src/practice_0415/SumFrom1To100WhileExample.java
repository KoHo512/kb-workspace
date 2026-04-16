package practice_0415;

/*
 * while문을사용하여1부터100까지의합을구하고, 그결과를출력하세요
 *
 * 출력조건
 * 1~100 합 : 5050
 * */
public class SumFrom1To100WhileExample {
    public static void main(String[] args) {
        int i = 1;
        int total = 0;

        while (i <= 100) {
            total += i++;
//            i++;
        }

        System.out.println("1~100 합 : " + total);
    }
}
