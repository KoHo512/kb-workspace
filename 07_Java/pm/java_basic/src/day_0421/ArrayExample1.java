package day_0421;

public class ArrayExample1 {
    public static void main(String[] args) {
        // 정수 배열에 5개의 숫자 1,2,3,4,5 할당

        // 1. 정수 배열 선언
        int[] numbers;

        // 2. 정수 배열 인스턴스
        numbers = new int[5];

        // 3. 배열에 데이터 할당
//        // 3-1 직접 할당 - 비효율적
//        numbers[0] = 1;
//        numbers[1] = 2;
//        numbers[2] = 3;
//        numbers[3] = 4;
//        numbers[4] = 5;

        // 3-2 for문을 통해 할당
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // 4. 할당된 데이터 확인
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
