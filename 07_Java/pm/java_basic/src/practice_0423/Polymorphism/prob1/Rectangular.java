package practice_0423.Polymorphism.prob1;

public class Rectangular extends Shape {
    private double width;
    private double height;

    public Rectangular() {
    }
    public Rectangular(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    void calculationArea() {
        area = width * height;
    }
}
