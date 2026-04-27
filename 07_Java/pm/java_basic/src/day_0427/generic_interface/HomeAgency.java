package day_0427.generic_interface;

public class HomeAgency implements Rentable<Home> {
    @Override
    public Home rent() {
        return new Home();
    }
}
