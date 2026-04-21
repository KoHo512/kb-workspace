package student.ch05_array_reference;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_StudentScoreAnalysisTodo {
    public static void main(String[] args) {

        // TODO 1: Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // TODO 2: 학생 수 변수 선언
        int studentNum = 0;

        // TODO 3: 점수 배열 선언 (아직 생성 X)
        int[] scores = null;

        // TODO 4: while(true) 반복문 작성
        while (true) {

            // TODO 5: 메뉴 출력
            // --------------------------------------
            // 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
            // --------------------------------------
            System.out.println("--------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------");

            // TODO 6: 사용자 선택 입력 받기 (nextLine 사용)
            System.out.print("선택 > ");
            String input = scanner.nextLine();

            // TODO 7: 선택에 따른 기능 구현
            switch (input) {
                // [1] 학생 수 입력
                // - "학생수>" 출력
                // - 입력값을 정수로 변환
                // - scores 배열 생성
                case "1" -> {
                    System.out.print("학생 수 입력 > ");
                    studentNum = Integer.parseInt(scanner.nextLine());
                    scores = new int[studentNum];
                }

                // [2] 점수 입력
                // - 반복문으로 scores[i] 입력 받기
                case "2" -> {
                    if (scores != null) {
                        for (int i = 0; i < scores.length; i++) {
                            System.out.printf("scores[%d] 점수 입력 > ", i);
                            scores[i] = Integer.parseInt(scanner.nextLine());
                        }
                    }
                }

                // [3] 점수 리스트 출력
                // - scores[i]: 값 형태로 출력
                case "3" -> {
                    if (scores != null) {
                        System.out.println("학생의 점수");
                        for (int i = 0; i < scores.length; i++) {
                            System.out.printf("scores[%d] : %d\n", i, scores[i]);
                        }
                    }
                }

                // [4] 분석
                // - 최대값 구하기
                // - 평균 구하기
                // - 출력
                case "4" -> {
                    if (scores != null) {
                        int max = scores[0];
                        int total = 0;

                        for (int i = 0; i < scores.length; i++) {
                            max = max > scores[i] ? max : scores[i];
                            total += scores[i];
                        }

                        System.out.println("최대값 : " + max);
                        System.out.printf("평균 : %.2f\n", (double) total / scores.length);
                    }
                }

                // [5] 종료
                // - "프로그램 종료" 출력 후 break
                case "5" -> {
                    System.out.println("프로그램 종료");

                    // TODO 8: Scanner 닫기
                    scanner.close();
                    return;
                }

                default -> System.out.println("잘못된 입력입니다. 1~5 사이의 수를 입력해주세요.");
            }

        }
    }
}