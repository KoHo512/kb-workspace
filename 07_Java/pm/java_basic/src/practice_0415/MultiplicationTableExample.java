package practice_0415;

/*
* 이중for루프를사용하여 2단부터 9단까지 구구단을출력하세요.
* 출력조건
*
  *** 2단 ***
  2 x 1 = 2
  2 x 2 = 4
  2 x 3 = 6
      …
  *** 9단 ***
  9 x 1 = 9
  9 x 2 = 18
      …
  9 x 8 = 72
  9 x 9 = 81

* */

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            System.out.println("*** " + i + "단 ***");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " x " + j + " = " + i * j);
            }
        }
    }
}
