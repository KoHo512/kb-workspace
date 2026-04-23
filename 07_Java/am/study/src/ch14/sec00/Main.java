package ch14.sec00;

public class Main {
    public static void main(String[] args) {
        System.out.println("시뮬레이션 시작");

        Bridge bridge = new Bridge();
        new Knight(bridge, "홍길동", "홍천").start();
        new Knight(bridge, "임꺽정", "임실").start();
        new Knight(bridge, "일지매", "일산").start();
        new Knight(bridge, "장보고", "장흥").start();
        new Knight(bridge, "이순신", "이천").start();

        // 실행하면 계속 문제 발생

        // 실패 시나리오 1 - 이름과 출생지가 다르게 나옴
        // 첫번째 스레드가 통과해서 chech() 실행
        // 동일 시점에 두번째 스레드가 생성자에서 `this.name = name`까지 실행
        // `if (name.charAt(0) != address.charAt(0))` 검사가 실패

        // 실패 시나리오 2 - 이름과 출생지가 같게 나옴
        // `if (name.charAt(0) != address.charAt(0))` 통과 못했는데
        // 그 사이에 데이터가 변경돼서 다른 스레드의 데이터 출력

        // => across() 함수 앞에 synchronized 추가하면 문제 발생 X
    }
}
