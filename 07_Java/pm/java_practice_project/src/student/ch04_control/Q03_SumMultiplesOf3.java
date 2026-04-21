package student.ch04_control;

/*
문제 11. for문
1부터 50까지의 정수 중에서 3의 배수의 합을 구하세요.

출력 결과:
3의 배수 합: 408
*/
public class Q03_SumMultiplesOf3 {
    public static void main(String[] args) {
        int sum = 0;

        // TODO: for문을 사용하여 3의 배수 합을 구하세요.
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0) sum += i;
        }
        // TODO: 결과를 출력하세요.
        System.out.printf("3의 배수의 합 : %d", sum);
    }
}
