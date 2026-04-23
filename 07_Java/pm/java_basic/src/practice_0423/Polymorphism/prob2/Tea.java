package practice_0423.Polymorphism.prob2;

public class Tea extends Beverage{
    static int amount = 0;

    public Tea(String name) {
        super(name);
        calcPrice();
        amount++;
    }

    @Override
    void calcPrice() {
        price = switch (getName()) {
            case "lemonTea" -> 1500;
            case "ginsengTea" -> 2000;
            case "redginsengTea" -> 2500;
            default -> 0;
        };
    }
}
