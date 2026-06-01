package com.example.jdbc.domain;

//import lombok.*;

import lombok.Builder;
import lombok.EqualsAndHashCode;

//@Getter
//@Setter
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@EqualsAndHashCode
public class Person {
    private int id;
    private String name;

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
