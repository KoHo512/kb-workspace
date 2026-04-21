package day_0421;

public class ArrayExample2 {
    public static void main(String[] args) {
        // 배열의 선언과 값을 한번에 할당
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 데이터 : "Spring", "Summer", "Fall", "Winter"
        // 4가지의 데이터를 저장하는 배열을 선언하고 데이터 할당해 출력
        String[] seasons = {"Spring", "Summer", "Fall", "Winter"};

        // 인덱스 2의 데이터를 winter2로 수정
        seasons[2] = "Winter2";

        for (int i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i]);
        }
    }
}
