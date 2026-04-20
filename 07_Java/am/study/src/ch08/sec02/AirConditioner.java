package ch08.sec02;

public class AirConditioner implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("에어컨을 켭니다.");
    }
}
