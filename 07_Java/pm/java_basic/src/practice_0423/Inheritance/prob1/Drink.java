package practice_0423.Inheritance.prob1;

public class Drink {
    String name;
    int price;
    int count;

    public Drink(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    int getTotalPrice() {
        return price * count;
    }

    void printTitle() {
        System.out.println("상품명     단가      수량      금액");
    }

    void printData() {
        System.out.printf("%s       %d      %d      %d\n", name, price, count, price * count);
    }
}