package practice_0416;

public class Car {
    // 필드 선언
//    // 각 멤버 변수가 가지는 기본 값
//    String model;   // null
//    boolean start;  // false
//    int speed;      // 0

    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car(String model, String color, int speed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = speed;
    }

    Car(String model) {
        this(model, "빨강", 200);
    }

    Car(String model, String color) {
        this(model, color, 200);
    }

    Car() {}

    int gas;

    void setGas(int gas) {
        this.gas = gas;
    }

    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        } else {
            System.out.println("gas가 있습니다.");
            return true;
        }
    }

    void run() {
        while (true) {
            if (gas > 0) {
                System.out.printf("달립니다. (gas 잔량 : %d)\n", gas--);
            } else {
                System.out.printf("멈춥니다. (gas 잔량 : %d)\n", gas);
                return;
            }
        }
    }
}
