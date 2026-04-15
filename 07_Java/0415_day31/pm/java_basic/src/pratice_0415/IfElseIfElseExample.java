package pratice_0415;

/* score값의구간을검사하여, 점수와등급을출력하는클래스를완성하세요.
  조건:
    0~69   D등급
    70~79  C등급
    80~89  B등급
    90~100 A등급

  출력:
   점수가70~79입니다.
   등급은C입니다.

 */

public class IfElseIfElseExample {
    public static void main(String[] args) {
        int score = 75;

        String scorerange = "0~69";
        String grade = "D";

        if (score >= 90) {
            scorerange = "90~100";
            grade = "A";
        } else if (score >= 80) {
            scorerange = "80~89";
            grade = "B";
        } else if (score >= 70) {
            scorerange = "70~79";
            grade = "C";
        }

        System.out.println("점수가 " + scorerange + "입니다.\n등급은 " + grade + "입니다.");
    }
}