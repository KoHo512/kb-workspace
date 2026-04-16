package practice_0416;

public class Calculator {
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    int plus(int n1, int n2) {
        return n1 + n2;
    }

    double divide(int n1, int n2) {
        return (double) n1 / n2;
    }

    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    double areaRectangle(int n1) {
        return n1 * n1;
    }

    double areaRectangle(int n1, int n2) {
        return n1 * n2;
    }
}
