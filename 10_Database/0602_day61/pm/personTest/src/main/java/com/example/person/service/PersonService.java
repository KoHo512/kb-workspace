package com.example.person.service;

import com.example.person.common.TransactionManager;
import com.example.person.dao.PersonDao;
import com.example.person.domain.Person;

import java.util.List;
import java.util.Optional;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Integer save(String name) throws Exception {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수값입니다.");
        }

        return TransactionManager.execute(con -> personDao.insert(con, Person.builder().name(name).build()));
    }

    public Optional<Person> findBtId(Integer id) throws Exception {
        return TransactionManager.execute(con -> personDao.findById(con, id));
    }

    public List<Person> findAll() throws Exception {
        return TransactionManager.execute(personDao::findAll);
    }

    public int update(Person person) throws Exception {
        if (person.getId() == null) {
            throw new IllegalArgumentException("수정하려면 person id가 필요합니다.");
        }

        return TransactionManager.execute(con -> personDao.update(con, person));
    }

    public int delete(Integer id) throws Exception {
        return TransactionManager.execute(con -> personDao.delete(con, id));
    }
}
