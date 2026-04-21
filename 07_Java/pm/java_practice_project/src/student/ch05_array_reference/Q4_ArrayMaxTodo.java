package student.ch05_array_reference;

public class Q4_ArrayMaxTodo {
    public static void main(String[] args) {

        int[] array = {1, 5, 3, 8, 2};

        // TODO 1: 최대값을 저장할 변수 선언
        // (힌트: 배열의 첫 번째 값을 초기값으로 설정)
        int maxValue = array[0];

        // TODO 2: for문 작성 (배열 전체 순회)
        for (int i = 0; i < array.length; i++) {
            // TODO 3: 현재 값과 최대값 비교
            if (maxValue < array[i]) {
                // TODO 4: 더 큰 값으로 최대값 갱신
                maxValue = array[i];
            }
        }

        // TODO 5: 최대값 출력
        System.out.println(maxValue);
    }
}
