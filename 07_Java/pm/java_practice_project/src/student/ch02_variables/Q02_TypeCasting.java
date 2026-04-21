package student.ch02_variables;

/*
문제 4. 타입 변환
정수 87을 double 타입으로 변환하여 출력하고,
실수 19.99를 int 타입으로 강제 변환하여 출력하세요.

출력 예시:
scoreDouble: 87.0
priceInt: 19
*/
public class Q02_TypeCasting {
    public static void main(String[] args) {
        int score = 87;
        double price = 19.99;

        // TODO: score를 double로 변환해서 scoreDouble에 저장하세요.
        double scoreDouble = (double) score;

        // TODO: price를 int로 변환해서 priceInt에 저장하세요.
        int priceInt = (int) price;

        // TODO: 결과를 출력하세요.
        System.out.printf("scoreDouble : %.1f\n", scoreDouble);
        System.out.printf("priceInt: %d\n", priceInt);
    }
}
