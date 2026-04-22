package practice_0422.ch11.sec02;

public class ExceptionHandlingExample2 {
    public static void printLength(String data) {
        int result = 0;
        try {
            result = data.length();  //data가 null일경우 NullPointerException 발생 가능
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            System.out.println("항상 난 실행되는 문장이예요");
        }
        System.out.println("문자수: " + result);

    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);  //매개변수로 null 대입 , NullPoint Exception 발생
        System.out.println("[프로그램 종료]");
    }
}
