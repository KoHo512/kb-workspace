package practice_0423.Polymorphism.prob2;

public class Coffee extends Beverage {
    static int amount = 0;

    public Coffee(String name) {
        super(name);
        calcPrice();
        amount++;
    }

    @Override
    void calcPrice() {
        price = switch (getName()) {
            case "Americano" -> 1500;
            case "CafeLatte" -> 2500;
            case "Cappuccino" -> 3000;
            default -> 0;
        };
    }
}
