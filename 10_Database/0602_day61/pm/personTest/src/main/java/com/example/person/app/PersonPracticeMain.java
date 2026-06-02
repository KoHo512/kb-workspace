package com.example.person.app;

import com.example.person.dao.PersonDao;
import com.example.person.service.PersonService;

public class PersonPracticeMain {
    public static void main(String[] args) throws Exception {
        PersonService personService = new PersonService(new PersonDao());

        Integer personId = personService.save("홍길동");
        System.out.println("저장된 person id = " + personId);

        personService.findAll().forEach(System.out::println);
    }
}
