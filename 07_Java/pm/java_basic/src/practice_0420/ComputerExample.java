package practice_0420;

public class ComputerExample {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        double result1 = cal.areaCircle(10.0);
//        System.out.println("Calculator 결과 : " + result1);
        System.out.printf("Calculator 결과 : %.2f\n", result1);

        Computer com = new Computer();
        double result2 = com.areaCircle(10.0);
//        System.out.println("Computer 결과 : " + result2);
        System.out.printf("Computer 결과 : %.2f\n", result2);
    }
}
