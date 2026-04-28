package day_0428.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 나이 순으로 sort
public class Main2 {
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
                        return Integer.compare(o1.age, o2.age);
                    }
                }
        );

        // Java9 람다식 축약
        Arrays.sort(users, (User u1, User u2) -> Integer.compare(u1.age, u2.age));

        for (User user : users) {
            System.out.println(user.name + " : " + user.age);
        }
    }
}
