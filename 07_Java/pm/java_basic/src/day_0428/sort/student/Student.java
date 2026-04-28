package day_0428.sort.student;

public class Student implements Comparable<Student> {
    private String name;
    private int score;
    private int age;

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    // Comparable: Student 객체의 기본 정렬 기준
    // 여기서는 점수 오름차순을 기본 정렬 기준으로 설정한다.
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
}
