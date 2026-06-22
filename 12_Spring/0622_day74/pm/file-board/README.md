## 1. 학습 주제

Spring MVC 게시판 프로젝트에 첨부파일 업로드/다운로드 기능을 추가하는 실습용 프로젝트입니다.

핵심 구현 흐름

```text
브라우저 multipart/form-data 요청
        ↓
Spring MultipartResolver
        ↓
BoardController
        ↓
BoardServiceImpl(@Transactional)
        ↓
게시글 저장 + 첨부파일 물리 저장 + 첨부파일 메타데이터 DB 저장
        ↓
MyBatis Mapper
        ↓
MySQL(tbl_board, tbl_board_attachment)
```

---

## 2. 프로젝트 구성

```text
file-upload-download-training
│
├── student-file-board/      # 학생용 TODO 프로젝트
├── sql/
│   └── tbl_board.sql
└── README.md
```

---

## 3. 중요 개념

1. multipart/form-data: 파일 업로드 시 브라우저가 사용하는 전송 인코딩 방식입니다.
2. MultipartFile: Spring MVC에서 업로드 파일 하나를 표현하는 인터페이스입니다.
3. MultipartResolver: multipart 요청을 해석하여 MultipartFile로 변환하는 Spring 컴포넌트입니다.
4. CommonsMultipartResolver: Apache Commons FileUpload 기반 multipart 처리 구현체입니다.
5. transferTo(): MultipartFile을 실제 서버 파일 시스템에 저장하는 메서드입니다.
6. File 클래스: Java에서 파일과 디렉토리를 다루는 표준 클래스입니다.
7. mkdirs(): 중간 경로까지 포함하여 디렉토리를 생성하는 메서드입니다.
8. 원본 파일명: 사용자가 업로드한 실제 파일명입니다. 다운로드 시 사용자에게 보여줄 이름으로 보관합니다.
9. 저장 파일명: 서버에서 중복을 피하기 위해 UUID 또는 timestamp를 붙인 실제 저장명입니다.
10. UUID: 충돌 가능성이 낮은 고유 식별자입니다.
11. Timestamp 파일명: 현재 시간을 붙여 파일명 중복을 줄이는 방식입니다.
12. Content-Type: 파일의 MIME 타입입니다. 예: image/png, application/pdf.
13. 파일 크기(size): 업로드된 파일 바이트 크기입니다.
14. 첨부파일 메타데이터: 파일명, 경로, MIME 타입, 크기, 게시글 번호 등을 DB에 저장한 정보입니다.
15. tbl_board_attachment: 첨부파일 정보를 저장하는 테이블입니다.
16. 외래키(FK): 첨부파일이 어떤 게시글에 속하는지 연결하는 제약조건입니다.
17. 1:N 관계: 게시글 1개가 여러 첨부파일을 가질 수 있는 관계입니다.
18. BoardAttachmentVO: 첨부파일 테이블의 한 행을 표현하는 도메인 객체입니다.
19. BoardVO: 게시글 도메인 객체이며 첨부파일 목록을 포함할 수 있습니다.
20. BoardDTO: 화면 Form 데이터와 업로드 파일 목록을 전달받기 위한 객체입니다.
21. DTO ↔ VO 변환: 화면 전달 객체와 DB 도메인 객체를 분리하기 위한 변환 과정입니다.
22. Factory Method: MultipartFile에서 BoardAttachmentVO를 생성하는 정적 생성 메서드입니다.
23. Builder Pattern: 객체 생성 시 필드가 많을 때 가독성을 높이는 패턴입니다.
24. MyBatis Mapper Interface: Java 메서드와 SQL ID를 연결하는 인터페이스입니다.
25. Mapper XML: 실제 SQL을 작성하는 MyBatis 설정 파일입니다.
26. resultMap: DB 컬럼과 Java 객체 필드를 명시적으로 매핑하는 설정입니다.
27. collection: MyBatis에서 1:N 관계 목록을 매핑할 때 사용하는 태그입니다.
28. LEFT OUTER JOIN: 게시글에 첨부파일이 없어도 게시글을 조회하기 위한 조인 방식입니다.
29. @Transactional: 여러 DB 작업을 하나의 트랜잭션으로 묶는 Spring 어노테이션입니다.
30. Rollback: RuntimeException 발생 시 DB 변경을 취소하는 트랜잭션 동작입니다.


## 4. 실습 과제

학생용 프로젝트에는 다음 구현부가 `TODO`로 남아 있습니다.

1. `UploadFileName.getUniqueName()` 구현
2. `UploadFiles.upload()` 구현
3. `UploadFiles.download()` 구현
4. `BoardAttachmentVO.of()` 구현
5. `BoardDTO.of()` 구현
6. `BoardDTO.toVo()` 구현
7. `BoardMapper.xml` 첨부파일 SQL 구현
8. `BoardServiceImpl.upload()` 구현
9. `BoardServiceImpl.getAttachment()` 구현
10. `BoardServiceImpl.deleteAttachment()` 구현
11. `BoardController.download()` 구현
12. JSP 파일 업로드 Form 완성

---
