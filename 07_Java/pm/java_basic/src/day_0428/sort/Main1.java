package day_0428.sort;

import java.util.Arrays;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) {
        class User implements Comparable<User> {
            String name;
            int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(User o) {
                if (this.age < o.age) return -1;
                else if (this.age == o.age) return 0;
                else return 1;
            }
        }

        User[] users = {
                new User("홍길동", 20),
                new User("김길동", 10),
                new User("최길동", 40),
        };

        System.out.println("=== sort 전 ===");
        for (User user : users) {
            System.out.println(user.name + " => " + user.age);
        }

        System.out.println();

        // 나이 순으로 users 정렬하여 출력
        System.out.println("=== sort 후 ===");
        Arrays.sort(users);

        for (User user : users) {
            System.out.println(user.name + " => " + user.age);
        }

        System.out.println();

        // 나이 역순으로 users 정렬하여 출력
        System.out.println("=== 역순 sort 후 ===");
        Arrays.sort(users, Collections.reverseOrder());

        for (User user : users) {
            System.out.println(user.name + " => " + user.age);
        }
    }
}
