package day_0427.generic_interface;

public class CarAgency implements Rentable<Car> {
    @Override
    public Car rent() {
        return new Car();
    }
}