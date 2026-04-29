package designPattern.command2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WorkService service = new WorkService();

//        Command[] commands = {
        Runnable[] commands = {
                service::add,
                service::open,
                service::print,
                Main::exit,
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1: Add, 2: Open, 3: Print, 4: Exit");
            System.out.print("선택 : ");
            int sel = scanner.nextInt();

//            commands[sel - 1].execute();
            commands[sel - 1].run();

            // 가독성을 위해 Command 인터페이스를 만들었지만
            // 반드시 정의해야 하는 것은 X
            // => Java에서 범용적으로 쓸 수 있는 인터페이스 정의
        }
    }

    static public void exit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("종료하시겠습니까?(Y/n) : ");
        String answer = scanner.nextLine();

        if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }
}
