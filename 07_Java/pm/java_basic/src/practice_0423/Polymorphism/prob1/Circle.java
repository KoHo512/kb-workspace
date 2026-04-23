package practice_0423.Polymorphism.prob1;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    void calculationArea() {
        area = radius * radius * Math.PI;
    }
}
