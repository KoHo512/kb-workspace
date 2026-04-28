package day_0428.sort;

import java.util.Arrays;
import java.util.Comparator;

// 나이 - 이름 순으로 sort
// 나이 순으로 정렬하는데 나이가 같은 사람이 있으면 추가적으로 이름 순으로 정렬
// 객체의 여러 속성을 이용해 정렬하기 위해 Comparator의 compare(), thenComparing()를 이용한 체이닝 구현 가능
// 객체의 속성 이용 시 getter, setter 필요
public class Main4 {
    public static void main(String[] args) {
        class User {
            private String name;
            private int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        User[] users = {
                new User("홍길동", 20),
                new User("김길동", 10),
                new User("최길동", 40),
                new User("차길동", 20),
                new User("이길동", 20),
        };

        // 나이 순으로만 sort됨
        Arrays.sort(users, Comparator.comparing(User::getAge));
        for (User user : users) {
            System.out.println(user.name + " : " + user.age);
        }

        System.out.println();

        // 이름 순으로만 sort됨
        Arrays.sort(users, Comparator.comparing(User::getName));
        for (User user : users) {
            System.out.println(user.name + " : " + user.age);
        }

        System.out.println();

        // 나이 - 이름 순으로 sort
        Arrays.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName));
        for (User user : users) {
            System.out.println(user.name + " : " + user.age);
        }
    }
}
