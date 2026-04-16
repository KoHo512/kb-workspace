package day_0416;

public class PrintfExample {
    public static void main(String[] args) {
        int a, b;
        a = 12;
        b = 2;

        String str1 = "Hello, Java";
        float f1 = 3.1234f;

        System.out.printf("안녕 printf()\n");
//        System.out.printf("인사말 : %s\n", str1); // 문자열
        System.out.printf("a = %d, b = %d\n", a, b); // 정수
        System.out.printf("f1 = %f\n", f1); // 실수
        System.out.printf("f1 = %.2f\n", f1); // 실수 소숫점 처리
        System.out.printf("번호 : %5d\n", 10); // 우측 정렬
        System.out.printf("번호 : %-5d\n", 10); // 좌측 정렬
        System.out.printf("번호 : %05d\n", 10); // 우측 정렬 (빈자리 0으로)

        String item = "노트북";
        int quantity = 10;
        double price = 1500000.48;
        System.out.printf("상품명 : %s, 현재 남은 수량 : %d개, 개당 가격 : %.1f원, 총 금액 : %.1f원\n", item, quantity, price, quantity * price);

        double rate = 87.5;
        System.out.printf("성공률 : %.1f%%\n", rate);

        String userId = "admin";
        String action = "service debugging";
        System.out.printf("[INFO] 사용자 : %s, 요청 : %s\n", userId, action);

        System.out.printf("총 금액 : %,d원\n", 1000000);
        System.out.printf("주문번호 : ORD-%05d원\n", 7666);

        int ack = PrintfAction();
        System.out.printf("exit code method : %d\n", ack);
    }

    static int PrintfAction() {
        String str1 = "Hi!";
        System.out.printf("인사말 : %s\n", str1); // 문자열

        return 0;
    }
}
