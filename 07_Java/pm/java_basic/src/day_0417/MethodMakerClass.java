package day_0417;

import java.util.Scanner;

class MethodAdd {
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int subtract(int n1, int n2) {
        return n1 - n2;
    }
}

public class MethodMakerClass {
    public static void main(String[] args) {
        // 사용자에게 2개의 점수 전달 받아
        // add라는 메소드를 호출해 전달 받은 두 수의 합을 받아 출력
        int n1, n2, result;

        Scanner input = new Scanner(System.in);

        System.out.print("첫번째 숫자 : ");
        n1 = input.nextInt();
        System.out.print("두번째 숫자 : ");
        n2 = input.nextInt();

        MethodAdd ma1 = new MethodAdd();
        result = ma1.add(n1, n2);
        System.out.println("합 : " + result);

        MethodAdd ma2 = new MethodAdd();
        result = ma2.add(n1, n2);
        System.out.println("합 : " + result);
    }

}
