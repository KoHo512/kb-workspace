package ch14.sec00;

public class Knight extends Thread {
    Bridge bridge;  // 공유 자원
    String name;
    String address;

    public Knight(Bridge bridge, String name, String address) {
        this.bridge = bridge;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(name + " 기사 도전");
        while (true) {
            bridge.across(name, address);
        }
    }
}
