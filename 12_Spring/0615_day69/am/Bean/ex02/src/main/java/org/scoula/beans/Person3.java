package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person3 {
    private String name = "Ella";

    // 권장사항
    private final Parrot2 parrot;

    // 주입 - parrot을 final로 운영할 경우
    // ** setter(setParrot)에도 @Autowired 작성 가능 - final로 운영 불가능
    @Autowired
    public Person3(Parrot2 parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }
}
