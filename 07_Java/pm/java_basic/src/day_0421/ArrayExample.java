package day_0421;

public class ArrayExample {
    public static void main(String[] args) {
        int[] a;
        a = new int[5];
        int[] b = new int[5];

        System.out.println(b.toString()); // b[0]의 주소 출력됨

        // 배열의 index를 이용해 값 할당
        b[0] = 5;
        b[1] = 10;
        b[2] = 20;
//        b[3] = "str"; // 약속된 데이터 타입을 넣어야만 할당 가능
        b[3] = 30;
        b[4] = 40;

        System.out.println("-----");

        // index 1에 저장된 데이터 출력
        int b1 = b[1];
        System.out.println(b1); // 10
        System.out.println(b[1]); // 10

        System.out.println("-----");

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
