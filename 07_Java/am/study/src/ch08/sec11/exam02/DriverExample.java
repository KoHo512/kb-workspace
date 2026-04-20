package ch08.sec11.exam02;

import java.util.Scanner;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        // 사용자에게 메뉴 제시
        // 운전할 차를 선택하세요. 1) Taxi, 2) Bus
        // 선택에 따라 실제 운전

        Vehicle vehicle;
        Scanner scanner = new Scanner(System.in);

        System.out.print("운전할 차를 선택하세요(1: 택시, 2: 버스, 3: 트럭) : ");
        int type = scanner.nextInt();


//        if (type == 1) {
//            vehicle = new Taxi();
//        } else if (type == 2) {
//            vehicle = new Bus();
//        }
//
//        driver.drive(vehicle);


//        vehicle = switch (type) {
//            case 1 -> new Taxi();
//            case 2 -> new Bus();
//            default -> null;
//        };
//
//        driver.drive(vehicle);


        Vehicle cars[] = {
                new Taxi(),
                new Bus(),
                new Truck(), // 만 추가하면 됨 - 확장성
        };

        cars[type - 1].run();
    }
}
