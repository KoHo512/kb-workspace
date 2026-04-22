package day_0422;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length();
        System.out.println("문자 길이 : " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");  // 10
        printLength(null);          // java.lang.NullPointerException 예외 발생
        System.out.println("[프로그램 종료]\n");
    }
}
