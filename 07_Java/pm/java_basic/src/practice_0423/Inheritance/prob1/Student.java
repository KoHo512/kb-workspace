package practice_0423.Inheritance.prob1;

public class Student {
    private String name;
    private String subject;
    private int fee;
    private double returnFee;

    public Student(String name, String subject, int fee) {
        this.name = name;
        this.subject = subject;
        this.fee = fee;
    }

    public void calcReturnFee() {
        returnFee = switch (subject) {
            case "javaprogram" -> fee * 0.25;
            case "jspprogram" -> fee * 0.20;
            default -> {
                System.out.println("그런 과정명은 없습니다.");
                yield 0;
            }
        };
    }

    public void print() {
        System.out.printf("%s 씨의 과정명은 %s이고, 교육비는 %d원이며, 환급금은 %.2f원입니다.\n", name, subject, fee, returnFee);
    }

        public static void main(String args[]) {
        Student stu = new Student("차은우", "jspprogram", 500000);
        stu.calcReturnFee();
        stu.print();
    }
}
