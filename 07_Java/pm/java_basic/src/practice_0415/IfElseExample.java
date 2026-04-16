package practice_0415;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 85;
        // intscore = 93

        // 1. score가 85인 경우
        // 점수가 90보다 작습니다.
        // 등급은 B입니다

        // 2. score가 93인 경우
        // 점수가 90보다 큽니다.
        // 등급은 A입니다.

        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다.\n등급은 A입니다.");
        } else {
            System.out.println("점수가 90보다 작습니다.\n등급은 B입니다.");
        }
    }
}
