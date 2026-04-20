package day_0420.dogcat_hier;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("고양이가 먹는다.");
    }

    public void night() {
        System.out.println("밤에 고양이 눈은 빛난다.");
    }
}
