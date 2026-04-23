package practice_0423.Polymorphism.prob2;

public abstract class Beverage {
    private String name;
    protected int price;

    public Beverage(String name) {
        this.name = name;
    }

    abstract void calcPrice();

    void print() {
        System.out.printf("%s (%d원)\n", name, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
