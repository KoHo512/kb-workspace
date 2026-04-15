package pratice_0415;

/*
 * for문을사용하여1부터100까지의합을구하고, 그결과를출력하세요
 * 출력조건
 * 1~100 합 : 5050

 * */
public class SumFrom1To100Example {
    public static void main(String[] args) {
        int total = 0;

        for (int i = 1; i <= 100; i++) {
            total += i;
        }

        System.out.println("1~100 합 : " + total);
    }
}
