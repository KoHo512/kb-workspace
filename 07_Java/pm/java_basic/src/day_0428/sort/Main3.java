package day_0428.sort;

import java.util.Arrays;
import java.util.Comparator;

// 이름 순으로 sort
public class Main3 {
    public static void main(String[] args) {
        class User {
            String name;
            int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        User[] users = {
                new User("홍길동", 20),
                new User("김길동", 10),
                new User("최길동", 40),
        };

        Arrays.sort(
                users, new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.name.compareTo(o2.name);
                    }
                }
        );

        for (User user : users) {
            System.out.println(user.name + " : " + user.age);
        }
    }
}
