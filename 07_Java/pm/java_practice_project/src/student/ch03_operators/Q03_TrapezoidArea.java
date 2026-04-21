package student.ch03_operators;

/*
문제 8. 사다리꼴 넓이
윗변 6, 아랫변 10, 높이 5인 사다리꼴의 넓이를 구하세요.
정확한 실수 결과가 나오도록 작성하세요.

공식: (윗변 + 아랫변) * 높이 / 2
출력 예시:
넓이: 40.0
*/
public class Q03_TrapezoidArea {
    public static void main(String[] args) {
        int top = 6;
        int bottom = 10;
        int height = 5;

        // TODO: 실수 결과가 나오도록 넓이를 계산하세요.
        double answer = (top + bottom) * height / 2;

        // TODO: 결과를 출력하세요.
        System.out.printf("넓이 : %.1f", answer);
    }
}
