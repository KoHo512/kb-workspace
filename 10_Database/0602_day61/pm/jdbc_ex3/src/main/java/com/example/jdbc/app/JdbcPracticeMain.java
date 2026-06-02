package com.example.jdbc.app;

import com.example.jdbc.dao.BoardDao;
import com.example.jdbc.dao.PersonDao;
import com.example.jdbc.dao.UserDao;
import com.example.jdbc.domain.Board;
import com.example.jdbc.domain.User;
import com.example.jdbc.service.BoardService;
import com.example.jdbc.service.PersonService;
import com.example.jdbc.service.UserService;
import com.example.jdbc.util.FileUtil;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JdbcPracticeMain
 * ------------------------------------------------------------
 *
 * 실행 전 준비:
 * 1. MySQL에서 schema.sql 실행
 * 2. src/main/resources/db.properties의 DB 계정/비밀번호 수정
 * 3. C:/Temp/apple.jpg 파일 준비
 *     */
public class JdbcPracticeMain {

    public static void main(String[] args) throws Exception {

        PersonService personService = new PersonService(new PersonDao());
//        UserService userService = new UserService(new UserDao());
//        BoardService boardService = new BoardService(new BoardDao());

        System.out.println("===== PERSON TEST =====");

        Integer personId = personService.save("김길동");
        System.out.println("저장된 person id = " + personId);

        personService.findAll().forEach(System.out::println);

//        System.out.println("\n===== USER TEST =====");
//
//        String loginId = "admin" + System.currentTimeMillis();
//
//        Integer userPk = userService.save(
//                User.builder()
//                        .userId(loginId)
//                        .username("관리자")
//                        .userPassword("1234")
//                        .userAge(30)
//                        .userEmail("admin@test.com")
//                        .build()
//        );
//
//        System.out.println("저장된 users.id = " + userPk);
//        System.out.println("로그인 userid = " + loginId);
//
//        userService.findById(userPk).ifPresent(System.out::println);
//        userService.findByUserId(loginId).ifPresent(System.out::println);
//
//        System.out.println("\n===== BOARD TEST =====");
//
//        byte[] fileData = null;
//        String fileName = null;
//
//        Path sampleImage = Path.of("C:/Temp/apple.jpg");
//
//        if (Files.exists(sampleImage)) {
//            fileData = FileUtil.readFile(sampleImage.toString());
//            fileName = "apple.jpg";
//        } else {
//            System.out.println("C:/Temp/apple.jpg 파일이 없어 파일 없이 게시글을 저장합니다.");
//        }
//
//        Integer bno = boardService.save(
//                Board.builder()
//                        .title("users.id 구조 적용 게시글")
//                        .content("userid는 로그인 ID, id는 DB PK입니다.")
//                        .writer(loginId)
//                        .fileName(fileName)
//                        .fileData(fileData)
//                        .build()
//        );
//
//        System.out.println("저장된 게시글 번호 = " + bno);
//
//        boardService.findAll().forEach(System.out::println);
//
//        byte[] downloadedFile = boardService.downloadFile(bno);
//
//        if (downloadedFile != null) {
//            FileUtil.saveFile(downloadedFile, "C:/Temp/download-apple.jpg");
//            System.out.println("파일 다운로드 완료: C:/Temp/download-apple.jpg");
//        } else {
//            System.out.println("다운로드할 파일 데이터가 없습니다.");
//        }
    }
}
