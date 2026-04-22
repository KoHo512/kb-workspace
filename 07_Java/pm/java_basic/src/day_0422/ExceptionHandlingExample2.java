package day_0422;

public class ExceptionHandlingExample2 {
    public static void printLength(String data) {
        int result = 0;

        try {
            result = data.length();
        } catch (NullPointerException e) {
            System.out.println("null 값이라 길이를 셀 수 없음");
        } catch (Exception e) {
            System.out.println("Exception 클래스로 예외 잡음");
        } catch (Throwable e) {
            System.out.println("Throwable 클래스로 예외 잡음");
        } finally {
            System.out.println("** 항상 실행 **");
        }

        System.out.println("문자 길이 : " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");  // 10
        printLength(null);          // java.lang.NullPointerException 예외 발생
        System.out.println("[프로그램 종료]\n");
    }
}
