package day_0430.stream.common;

public class Student {
    private final String name;
    private final String sex;
    private final int score;

    public Student(String name, String sex, int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public String getName() { return name; }
    public String getSex() { return sex; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + "(" + sex + ", " + score + ")";
    }
}
