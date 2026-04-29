package day_0429.lambda.todo;

/**
 * Runnable : 매개변수가 없고 반환값도 없는 함수형 인터페이스
 * 함수형 인터페이스 : 추상메소드가 1개만 존재하는 인터페이스
 * Runnable의 추상메소드는 run() 하나이므로 람다식으로 구현 가능
 */
public class Ex01RunnableLambdaTodo {
    public static void main(String[] args) {
        // TODO: Runnable을 람다식으로 작성하여 "작업을 실행합니다."를 출력하세요.
        Runnable task = ()-> System.out.println("작업을 실행합니다.");
        task.run();
    }
}
