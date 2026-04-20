package day_0420.emp;

public class Employee {
    protected String name;
    protected int age;
    protected String phone;
    protected String empDate;
    protected String dept;
    protected boolean marriage;

    public Employee() {
        super();
    }

    public Employee(String name, int age, String phone, String empDate, String dept, boolean marriage) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.empDate = empDate;
        this.dept = dept;
        this.marriage = marriage;
    }
}
