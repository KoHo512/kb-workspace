package day_0420.dogcat_hier;

public class DogCatTest {
    public static void main(String[] args) {
        Dog doggy = new Dog();
        doggy.eat();

        Cat kitty = new Cat();
        kitty.eat();
        kitty.night();

        //
        // Upcasting
        Animal dog = new Dog();
        dog.eat(); // 개가 먹는다.

        Animal cat = new Cat();
        cat.eat(); // 고양이가 먹는다.

        Dog babyDog = new BabyDog();
        babyDog.eat(); // 강아지가 우유를 먹는다.

        // 오버라이딩 과정을 트레이싱해서 최종 오버라이딩된 메소드 실행 (데이터는 다름)
    }
}
