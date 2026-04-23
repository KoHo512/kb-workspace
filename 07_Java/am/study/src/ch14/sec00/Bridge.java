package ch14.sec00;

public class Bridge {
    int counter;    // 전체 통과 횟수
    String name;    // 현재 통과 중인 기사의 이름
    String address; // 현재 통과 중인 기사의 주소

    public Bridge() {
        counter = 0;
        name = "이름";
        address = "주소";
    }

//    public void across(String name, String address) {
    synchronized public void across(String name, String address) {
        counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("** 문제 발생 ** " + this);
        }
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
