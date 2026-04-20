package day_0420.emp;

public class EmpTest {
    public static void main(String[] args) {
        RempVO vo = new RempVO();
        vo.name = "홍길동";
        vo.deptId = "1111";
        System.out.println(vo.name);

        Employee 승리 = new RempVO();

        승리.name = "김승리";
        승리.age = 30;
        승리.phone = "010-2222-3333";
        승리.empDate= "2020-01-01";
        승리.dept="개발부";
        승리.marriage = true;
//        승리.deptId = "1111"; // 접근 불가능 - RempVO에만 정의
        System.out.printf("사원명 : %s, 나이 : %d, 전화번호 : %s, 입사일 : %s", 승리.name, 승리.age , 승리.phone, 승리.empDate);
    }
}
