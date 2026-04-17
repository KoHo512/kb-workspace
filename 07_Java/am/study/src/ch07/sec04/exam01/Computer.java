package ch07.sec04.exam01;

public class Computer extends Calculator {
    @Override
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }

//    /*
//    Alt+Insert, Ctrl+O 단축키로 Override 기본 골격 생성 가능
//     */
//    @Override
//    public double areaCircle(double r) {
//        return super.areaCircle(r);
//    }
}
