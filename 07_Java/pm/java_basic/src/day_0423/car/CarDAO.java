package day_0423.car;

// DAO : 검증된 데이터 처리를 담당하는 모델
public class CarDAO {
    public void createInsert(CarDTO car) {
        // DB 연결 - Insert Query
        System.out.println("Car 정보가 DB에 저장됨");
    }
}
