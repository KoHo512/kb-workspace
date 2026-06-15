package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 지금까지 이렇게 해왔음 (강한 결합) => 앞으로 이렇게 하지 말자!
//        Parrot p = new Parrot();

        // => 컨텍스트에서 원하는 빈(Bean) 객체 추출하여 사용
        // [주의] 동일한 타입에 대해서는 1개의 빈(Bean)만 추출 가능

        // Spring Context 객체 (매개변수 : 설정 정보)
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
