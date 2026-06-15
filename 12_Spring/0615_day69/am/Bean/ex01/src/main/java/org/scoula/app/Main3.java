package org.scoula.app;

import org.scoula.config.ProjectConfig3;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);

        Parrot p = context.getBean(Parrot.class);

        System.out.println(p);
        System.out.println(p.getName());

        // domain.Parrot에 @Component만 추가하면 p.getName() => null
        // @Bean은 인스턴스 생성 후 후처리 가능하지만, @Component는 생성 후 후처리 불가능
        // => javax.annotaion-api의 @PostConstruct 사용해 후처리 메소드 지정
    }
}
