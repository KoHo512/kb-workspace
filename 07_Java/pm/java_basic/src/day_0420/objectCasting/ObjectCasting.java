package day_0420.objectCasting;

import day_0420.dogcat_hier.Animal;
import day_0420.dogcat_hier.Cat;
import day_0420.dogcat_hier.Dog;

public class ObjectCasting {
    public static void main(String[] args) {
        Animal ani;

        // up casting
        ani = new Dog();
        ani.eat();

        ani = new Cat();
        ani.eat();

        // down casting
//        ani.night(); // Animal type에 night가 없음
        ((Cat) ani).night();
    }
}
