package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

//        Parrot p = context.getBean(Parrot.class); // => 예외 발생
//        System.out.println(p.getName());

        // Parrot 타입의 인스턴스가 3개 등록되어 있어서 어느 것을 참조할지 결정할 수 없어 예외 발생
        // => 이름으로 추출해야 함 (이름을 직접 정의하지 않으면 메소드명이 이름)

        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());

        // 일반적으로는 하나의 타입만 등록해서 관리
    }
}
