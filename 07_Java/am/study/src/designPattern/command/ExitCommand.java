package designPattern.command;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner=new Scanner(System.in);

        System.out.print("종료하시겠습니까?(Y/n) : ");
        String answer = scanner.nextLine();

        // 교안 코드에 작성되어있는데 코드 있으면 InputMismatchException 발생함..
//        scanner.close();

        if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
            System.exit(0);
        }
    }
}
