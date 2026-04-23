package practice_0423.Inheritance.prob2;

public class Tv {
    String color;
    boolean power;
    int channel;

    public Tv() {
        color = "black";
        power = false;
        channel = 0;
    }

    void power() {
        power = !power;
    }

    void channelUp() {
        channel++;
    }

    void channelDown() {
        channel--;
    }

    void print() {
        System.out.printf("color : %s   power : %b  channel : %d\n", color, power, channel);
    }
}
