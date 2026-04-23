package practice_0423.Polymorphism.prob1;

public class TestShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        Circle circle = new Circle("원", 10);
        Rectangular rectangular = new Rectangular("직사각형", 10, 20);

        shapes[0] = circle;
        shapes[1] = rectangular;

        for (Shape shape : shapes) {
            shape.print();
        }
    }
}
