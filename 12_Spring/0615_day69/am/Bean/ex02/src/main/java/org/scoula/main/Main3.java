package org.scoula.main;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);

        System.out.println(person == person2); // true
        // 객체 생성은 context 생성 시에 이미 완료
        // 등록된 context에서 꺼내오는 거기 때문에 같은 객체 반환
        // = 싱글톤(Singleton) - 빈(Bean) 레벨에서
    }
}
