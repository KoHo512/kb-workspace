package practice_0423.Polymorphism.prob1;

public abstract class Shape {
    protected double area;
    private String name;

    public Shape() {
    }
    public Shape(String name) {
        this.name = name;
    }

    abstract void calculationArea();

    public void print() {
        this.calculationArea();
        System.out.printf("%s의 면적은 %.5f\n", name, area);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
