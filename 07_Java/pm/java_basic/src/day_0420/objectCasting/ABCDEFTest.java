package day_0420.objectCasting;

public class ABCDEFTest {
    public static void main(String[] args) {
        A a = new A();

        // up casting - 자식 객체를 부모 타입으로 참조 - 항상 가능
        a = new B();
        a = new C();
        a = new D();
        a = new E();
        a = new F();

        B b = new B();
        b = new D();
        b = new E();
//        b = new F(); // F는 B의 자식이 아니라 담을 수 없음
//        b = new C();

        C c = new C();
//        c = new D(); // D는 C의 자식이 아니라 담을 수 없음
        c = new F();


        // down casting - 부모 타입을 자식 타입으로 형 변환
        // 실제 객체가 해당 자식일 때만 가능
        B b1 = new B();

        // 실제 객체가 자식이 아니므로 런타임 에러 발생 - 불가능
//        D d1 = (D) b1;
//        F f1 = (F) b1;

//        B b2 = (B) new A();

        // 자식 객체를 부모에 담았다가 자식으로 형 변환 - 가능
        A a1 = new B();
        b1 = (B) a1;
    }
}
