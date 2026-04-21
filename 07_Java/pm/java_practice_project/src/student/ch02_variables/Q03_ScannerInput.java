package student.ch02_variables;

import java.util.Scanner;

/*
문제 5. Scanner 입력
키보드로 이름과 나이를 입력받아 다음 형식으로 출력하세요.

실행 예시:
이름 입력: 소미
나이 입력: 25
안녕하세요, 소미님. 내년 나이는 26세입니다.
*/
public class Q03_ScannerInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: 이름을 입력받으세요.
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();

        // TODO: 나이를 입력받으세요.
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        // TODO: 안내 문장을 출력하세요.
        System.out.printf("안녕하세요, %s님. 내년 나이는 %d세 입니다.", name, age + 1);


        sc.close();
    }
}
