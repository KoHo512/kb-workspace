package practice_0423.Inheritance.prob1;

public class Alcohol extends Drink {
    double alcper;

    public Alcohol(String name, int price, int count, double alcper) {
        super(name, price, count);
        this.alcper = alcper;
    }

    @Override
    void printTitle() {
        System.out.println("상품명(도수[%])  단가      수량      금액");
    }

    @Override
    void printData() {
        System.out.printf("%s (%.1f)     %d      %d      %d\n", name, alcper, price, count, price * count);

    }
}
