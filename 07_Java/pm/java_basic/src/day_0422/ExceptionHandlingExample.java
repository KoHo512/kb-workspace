package day_0422;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스 존재");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // forName은 throws ClassNotFoundException를 반드시 잡아줘야 사용 가능 - 처리 하지 않으면 아예 실행 불가능
            Class.forName("java.lang.String2");
            System.out.println("java.lang.String2 클래스 존재");
        } catch (ClassNotFoundException e) {
//            System.out.println("java.lang.String2 클래스 제공하지 않음");
//            e.printStackTrace();
        }
    }
}
