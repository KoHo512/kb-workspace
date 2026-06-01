package com.example.jdbc.app;

import com.example.jdbc.common.DBUtil;
//import com.example.jdbc.dao.BoardDao;
import com.example.jdbc.dao.PersonDao;
import com.example.jdbc.dao.UserDao;
import com.example.jdbc.domain.Board;
import com.example.jdbc.domain.Person;
import com.example.jdbc.domain.User;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class JdbcPracticeMain {
    public static void main(String[] args) throws Exception {
        DBUtil dbUtil = DBUtil.defaultConfig();

        PersonDao personDao = new PersonDao(dbUtil);
        UserDao userDao = new UserDao(dbUtil);
//        BoardDao boardDao = new BoardDao(dbUtil);

        personDao.insert(new Person(1011, "길동"));
        userDao.insert(new User("test0111", "신호동", "123456", 20, "test@gmail.com"));

        byte[] sampleFileData = "학생 실습용 파일 데이터".getBytes(StandardCharsets.UTF_8);
//        int bno = boardDao.insert(new Board("JDBC 실습", "PreparedStatement 게시글 저장", "teacher", "sample.txt", sampleFileData));

        System.out.println("person 목록 = " + personDao.findAll());

        // 람다 출력 코드 작성 - person 리스트 출력
        List<Person> personList = personDao.findAll();
        personList.forEach(person -> System.out.println("person = " + person.getName()));

//        System.out.println("저장된 게시글 번호 = " + bno);
//        System.out.println("게시글 조회 = " + boardDao.findById(bno).map(Board::getTitle).orElse("없음"));
    }
}
