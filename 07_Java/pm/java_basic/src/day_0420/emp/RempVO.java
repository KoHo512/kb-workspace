package day_0420.emp;

public class RempVO extends Employee {
    public String deptId;

    RempVO() {
        super();
    }

    RempVO(String name, int age, String phone, String empDate, String dept, boolean marriage) {
        super(name,age,phone,empDate,dept,marriage);
    }
}
