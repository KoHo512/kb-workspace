package ch06.sec15;

public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        /** 컴파일 에러
         Singleton obj1 = new Singleton();
         Singleton obj2 = new Singleton();
         */

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("같은 Singleton 객체");  // 동일한 객체 참조
        } else {
            System.out.println("다른 Singleton 객체");
        }
    }
}
