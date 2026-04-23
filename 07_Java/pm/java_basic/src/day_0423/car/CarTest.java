package day_0423.car;

public class CarTest {
    public static void main(String[] args) {
        Car bmw5200 = new Car();
        String carsn = "1111";
        String carname = "BMW5200";
        int carprice = 8500000;

        CarDTO dto = new CarDTO();
        dto.carSn = carsn;
        dto.carName = carname;
        dto.carPrice = carprice;

        System.out.println(dto.toString());
    }
}
