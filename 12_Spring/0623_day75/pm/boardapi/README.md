오늘 수업의 핵심 흐름

- 기존 게시판 프로젝트를 `boardapi` 형태의 REST API 프로젝트로 전환
- JSP View 기반 Controller 제거
- `@RestController` 기반 API 서버 구성
- `ResponseEntity`로 JSON 응답 반환
- `@RequestBody`, `@PathVariable`을 이용한 요청 데이터 바인딩
- API 서버에서 CUD(Create, Update, Delete) 처리 결과 객체 반환
- Swagger UI를 이용한 REST API 문서 자동화
- Springfox Swagger 2.9.2 설정
- `SwaggerConfig`, `WebConfig`, `ServletConfig` 설정
- `@Api`, `@ApiOperation`, `@ApiParam`을 통한 API 문서 보강

---

## 2. 구성

```text
rest-swagger-training-package
├── README.md
├── teacher-boardapi
│   ├── build.gradle
│   ├── settings.gradle
│   ├── sql
│   │   └── tbl_board.sql
│   └── src
│       └── main
│           ├── java/org/scoula/...
│           ├── resources/org/scoula/board/mapper/BoardMapper.xml
│           └── webapp/WEB-INF/views/index.jsp
└── student-boardapi-todo
    ├── build.gradle
    ├── settings.gradle
    ├── sql
    │   └── tbl_board.sql
    └── src
        └── main
            ├── java/org/scoula/...
            ├── resources/org/scoula/board/mapper/BoardMapper.xml
            └── webapp/WEB-INF/views/index.jsp
```

---

# PART 1. 중요 개념 30개

## 1. REST API

REST API는 서버가 화면을 직접 반환하지 않고 JSON, XML 같은 데이터를 반환하는 방식입니다. 본 프로젝트에서는 게시판 목록, 상세, 등록, 수정, 삭제 결과를 JSON으로 응답합니다.

## 2. `@Controller`와 `@RestController`

`@Controller`는 View 이름을 반환하고 JSP로 이동할 때 사용합니다. `@RestController`는 모든 메서드에 `@ResponseBody`가 붙은 것처럼 동작하여 객체를 JSON으로 변환해 응답합니다.

## 3. `@ResponseBody`

메서드 반환값을 View 이름으로 해석하지 않고 HTTP 응답 Body에 직접 기록합니다. `@RestController`를 사용하면 메서드마다 별도로 붙이지 않아도 됩니다.

## 4. Jackson

Java 객체를 JSON 문자열로 변환하거나 JSON 요청 Body를 Java 객체로 변환하는 라이브러리입니다. Spring MVC에서 REST API 구현 시 핵심 역할을 합니다.

## 5. `ResponseEntity<T>`

HTTP 상태 코드, Header, Body를 함께 제어할 수 있는 응답 객체입니다. 예를 들어 `ResponseEntity.ok(board)`는 상태 코드 200과 JSON Body를 반환합니다.

## 6. `@RequestMapping`

Controller 클래스 또는 메서드의 공통 URL을 지정합니다. 본 프로젝트에서는 `/api/board`를 게시판 REST API 기본 경로로 사용합니다.

## 7. `@GetMapping`

HTTP GET 요청을 처리합니다. 주로 목록 조회와 상세 조회에 사용합니다.

## 8. `@PostMapping`

HTTP POST 요청을 처리합니다. 주로 신규 데이터 생성에 사용합니다.

## 9. `@PutMapping`

HTTP PUT 요청을 처리합니다. 주로 기존 데이터 전체 수정에 사용합니다.

## 10. `@DeleteMapping`

HTTP DELETE 요청을 처리합니다. 주로 데이터 삭제에 사용합니다.

## 11. `@PathVariable`

URL 경로에 포함된 값을 메서드 파라미터로 바인딩합니다. 예: `/api/board/10`에서 `10`을 게시글 번호로 받습니다.

## 12. `@RequestBody`

HTTP 요청 Body의 JSON 데이터를 Java 객체로 변환합니다. 등록/수정 API에서 `BoardDTO`를 받을 때 사용합니다.

## 13. DTO

Controller와 클라이언트 사이에서 데이터를 주고받는 객체입니다. API 요청/응답 모델로 사용합니다.

## 14. VO

DB 테이블과 가깝게 설계된 도메인 객체입니다. MyBatis Mapper와 SQL 결과 매핑에 사용합니다.

## 15. DTO ↔ VO 변환

Controller는 DTO를 받고, Service/Mapper 계층에서는 VO를 사용합니다. 계층별 책임을 분리하기 위해 변환 메서드를 둡니다.

## 16. MyBatis Mapper Interface

Java 메서드와 SQL을 연결하는 인터페이스입니다. 메서드명과 XML의 SQL id가 일치해야 합니다.

## 17. Mapper XML

SQL을 작성하는 XML 파일입니다. `select`, `insert`, `update`, `delete`를 정의합니다.

## 18. `resultMap`

DB 컬럼명과 Java 필드명이 다르거나 관계 매핑이 필요한 경우 사용하는 MyBatis 매핑 설정입니다.

## 19. `useGeneratedKeys`

MySQL `AUTO_INCREMENT`로 생성된 PK 값을 insert 후 Java 객체에 다시 채워 넣는 MyBatis 옵션입니다.

## 20. Service 계층

Controller가 직접 Mapper를 호출하지 않도록 비즈니스 로직을 담당하는 계층입니다. 트랜잭션 처리도 주로 Service 계층에서 수행합니다.

## 21. `@Transactional`

여러 SQL을 하나의 작업 단위로 묶습니다. 정상 종료 시 commit, RuntimeException 발생 시 rollback합니다.

## 22. `@EnableTransactionManagement`

`@Transactional`이 실제로 동작하도록 Spring 트랜잭션 기능을 활성화합니다.

## 23. HikariCP

DB Connection Pool 라이브러리입니다. 매번 DB 연결을 새로 만들지 않고 재사용하여 성능을 높입니다.

## 24. Swagger

개발한 REST API를 문서화하고, 브라우저에서 직접 테스트할 수 있게 도와주는 도구입니다.

## 25. Springfox

Spring MVC 프로젝트에서 Swagger 문서를 생성하기 위해 사용하는 라이브러리입니다. 본 PDF에서는 `springfox-swagger2`, `springfox-swagger-ui` 2.9.2를 사용합니다.

## 26. `@EnableSwagger2`

Springfox Swagger 2 기능을 활성화하는 설정 어노테이션입니다.

## 27. `Docket`

Swagger 문서 생성 범위와 API 정보를 설정하는 핵심 Bean입니다.

## 28. `ApiInfo`

Swagger UI 상단에 표시되는 API 이름, 설명, 버전 정보를 설정합니다.

## 29. `@Api`, `@ApiOperation`, `@ApiParam`

Swagger 문서에 Controller 그룹명, 엔드포인트 설명, 파라미터 설명을 추가하는 어노테이션입니다.

## 30. Swagger Resource Handler

Spring MVC에서 Swagger UI 정적 리소스를 접근할 수 있도록 `/swagger-ui.html`, `/webjars/**`, `/swagger-resources/**`, `/v2/api-docs` 경로를 등록해야 합니다.

---

# PART 2. Swagger

## 1. Swagger란?

Swagger는 개발한 REST API를 자동으로 문서화하고, 브라우저에서 직접 API를 호출해 테스트할 수 있게 해주는 도구입니다.

기존 방식에서는 API 명세를 별도 문서로 작성해야 했습니다.

```text
API 개발
  ↓
엑셀/문서에 URL, Method, Parameter, Response 작성
  ↓
Postman으로 따로 테스트
```

Swagger를 사용하면 다음처럼 바뀝니다.

```text
Controller 작성
  ↓
Swagger Annotation 작성
  ↓
/swagger-ui.html 접속
  ↓
API 문서 확인 + 직접 테스트
```

## 2. 프로젝트의 Swagger 접속 주소

Tomcat의 Application Context를 `/`로 설정했을 때:

```text
http://localhost:8080/swagger-ui.html
```

## 3. build.gradle Swagger 의존성

```gradle
implementation 'io.springfox:springfox-swagger2:2.9.2'
implementation 'io.springfox:springfox-swagger-ui:2.9.2'
```

## 4. SwaggerConfig 핵심

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
```

설명:

```text
@RestController가 붙은 클래스만 Swagger 문서 대상으로 삼는다.
모든 URL path를 문서화한다.
API 제목, 설명, 버전은 apiInfo()에서 설정한다.
```

## 5. Swagger Annotation 사용 예

```java
@Api(tags = "게시글 관리")
@RestController
@RequestMapping("/api/board")
public class BoardController {

    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @ApiOperation(value = "상세정보 얻기", notes = "게시글 상세 정보를 얻는 API")
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(
        @ApiParam(value = "게시글 ID", required = true, example = "1")
        @PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }
}
```

주의: 숫자 파라미터는 `example = "1"`처럼 숫자 예시를 명확히 주어야 Swagger 테스트 시 변환 오류를 줄일 수 있습니다.

---

# PART 3. 프로젝트 설정 상세 설명

## 1. settings.gradle

```gradle
rootProject.name = 'boardapi'
```

IntelliJ와 Gradle이 프로젝트 이름을 인식합니다.

## 2. build.gradle

본 프로젝트는 Spring Boot가 아니라 전통적인 Spring MVC WAR 프로젝트입니다.

핵심 플러그인:

```gradle
plugins {
    id 'java'
    id 'war'
}
```

중요 의존성:

```gradle
implementation 'org.springframework:spring-webmvc:5.3.27'
implementation 'org.mybatis:mybatis:3.5.13'
implementation 'org.mybatis:mybatis-spring:2.1.1'
implementation 'com.zaxxer:HikariCP:5.0.1'
implementation 'mysql:mysql-connector-java:8.0.33'
implementation 'com.fasterxml.jackson.core:jackson-databind:2.15.2'
implementation 'io.springfox:springfox-swagger2:2.9.2'
implementation 'io.springfox:springfox-swagger-ui:2.9.2'
```

## 3. WebConfig

`AbstractAnnotationConfigDispatcherServletInitializer`를 상속하여 `web.xml` 없이 Java 설정으로 DispatcherServlet을 등록합니다.

중요 메서드:

```java
protected Class<?>[] getRootConfigClasses()
protected Class<?>[] getServletConfigClasses()
protected String[] getServletMappings()
```

## 4. RootConfig

DB, MyBatis, Transaction 등 웹 화면과 직접 관련 없는 Root Bean을 등록합니다.

포함 내용:

- DataSource
- SqlSessionFactory
- DataSourceTransactionManager
- MapperScan
- `@EnableTransactionManagement`

## 5. ServletConfig

Spring MVC 웹 계층 설정입니다.

포함 내용:

- `@EnableWebMvc`
- Controller Component Scan
- ViewResolver
- Static Resource Handler
- Swagger UI Resource Handler

## 6. Tomcat 설정

IntelliJ에서 Tomcat 실행 설정 시:

```text
Deployment: Gradle : org.scoula : boardapi-1.0-SNAPSHOT.war
Application context: /
```

Application context가 `/`이면 Swagger 주소는 다음과 같습니다.

```text
http://localhost:8080/swagger-ui.html
```

Application context가 `/boardapi`이면 다음 주소가 됩니다.

```text
http://localhost:8080/boardapi/swagger-ui.html
```

---

# PART 4. 4지 선다형 20문제

## 문제 1

REST API 서버에서 View 이름이 아니라 JSON 데이터를 응답하기 위해 사용하는 Controller 어노테이션은?

1. `@Controller`
2. `@RestController`
3. `@Repository`
4. `@Configuration`

정답: 2

## 문제 2

`@RestController`에 기본적으로 포함된 기능은?

1. `@RequestBody`
2. `@ResponseBody`
3. `@Autowired`
4. `@MapperScan`

정답: 2

## 문제 3

HTTP 응답 상태 코드와 Body를 함께 제어하는 Spring 객체는?

1. `Model`
2. `ResponseEntity`
3. `ViewResolver`
4. `SqlSessionFactory`

정답: 2

## 문제 4

JSON 요청 Body를 Java 객체로 변환할 때 사용하는 어노테이션은?

1. `@RequestBody`
2. `@PathVariable`
3. `@RequestParam`
4. `@ModelAttribute`

정답: 1

## 문제 5

`/api/board/10`에서 `10`을 메서드 파라미터로 받기 위한 어노테이션은?

1. `@RequestBody`
2. `@PathVariable`
3. `@ResponseBody`
4. `@Bean`

정답: 2

## 문제 6

REST에서 신규 게시글 등록에 가장 적합한 HTTP Method는?

1. GET
2. POST
3. PUT
4. DELETE

정답: 2

## 문제 7

REST에서 기존 게시글 수정에 주로 사용하는 HTTP Method는?

1. GET
2. POST
3. PUT
4. TRACE

정답: 3

## 문제 8

REST에서 게시글 삭제에 주로 사용하는 HTTP Method는?

1. DELETE
2. PATCH
3. OPTIONS
4. HEAD

정답: 1

## 문제 9

Swagger의 주된 목적은?

1. DB Connection Pool 관리
2. API 문서 자동화와 테스트
3. JSP 렌더링
4. SQL 실행

정답: 2

## 문제 10

PDF 기준 Swagger 의존성으로 사용된 라이브러리는?

1. Springfox
2. Thymeleaf
3. Hibernate
4. JPA

정답: 1

## 문제 11

Swagger 2 기능을 활성화하는 어노테이션은?

1. `@EnableWebMvc`
2. `@EnableSwagger2`
3. `@EnableTransactionManagement`
4. `@MapperScan`

정답: 2

## 문제 12

Swagger 문서 생성 설정의 핵심 Bean은?

1. `Docket`
2. `DataSource`
3. `MultipartResolver`
4. `ViewResolver`

정답: 1

## 문제 13

Swagger에서 Controller 그룹명을 지정하는 어노테이션은?

1. `@Api`
2. `@ApiOperation`
3. `@ApiParam`
4. `@ApiModelProperty`

정답: 1

## 문제 14

Swagger에서 특정 API 엔드포인트의 설명을 작성하는 어노테이션은?

1. `@Api`
2. `@ApiOperation`
3. `@Bean`
4. `@Service`

정답: 2

## 문제 15

Swagger에서 파라미터 설명과 예시 값을 작성하는 어노테이션은?

1. `@ApiParam`
2. `@PathVariable`
3. `@RequestMapping`
4. `@ComponentScan`

정답: 1

## 문제 16

MyBatis Mapper Interface와 XML을 연결할 때 반드시 일치해야 하는 것은?

1. 패키지명과 DB명
2. 메서드명과 SQL id
3. 클래스명과 테이블명만
4. 변수명과 URL만

정답: 2

## 문제 17

MySQL AUTO_INCREMENT 값을 Java 객체에 다시 채워 넣는 MyBatis 옵션은?

1. `resultMap`
2. `useGeneratedKeys`
3. `mapperLocations`
4. `typeAliasesPackage`

정답: 2

## 문제 18

DB 연결 풀을 담당하는 라이브러리는?

1. HikariCP
2. Jackson
3. Lombok
4. Swagger UI

정답: 1

## 문제 19

트랜잭션 기능을 활성화하는 어노테이션은?

1. `@EnableSwagger2`
2. `@EnableWebMvc`
3. `@EnableTransactionManagement`
4. `@RestController`

정답: 3

## 문제 20

Controller에서 직접 SQL을 실행하지 않고 Service를 거치게 하는 주된 이유는?

1. JSP 경로를 짧게 하기 위해
2. 비즈니스 로직과 트랜잭션 책임을 분리하기 위해
3. HTML 색상을 변경하기 위해
4. Tomcat 포트를 자동으로 바꾸기 위해

정답: 2

---

# PART 5. 단답형 20문제

1. 모든 메서드에 `@ResponseBody`가 적용되는 Controller 어노테이션은?  
   정답: `@RestController`

2. JSON 요청 Body를 Java 객체로 변환하는 어노테이션은?  
   정답: `@RequestBody`

3. URL 경로 값을 파라미터로 받는 어노테이션은?  
   정답: `@PathVariable`

4. HTTP 응답 상태와 Body를 함께 반환하는 Spring 객체는?  
   정답: `ResponseEntity`

5. Java 객체와 JSON 변환을 담당하는 대표 라이브러리는?  
   정답: Jackson

6. 신규 데이터 생성에 주로 사용하는 HTTP Method는?  
   정답: POST

7. 데이터 조회에 주로 사용하는 HTTP Method는?  
   정답: GET

8. 데이터 수정에 주로 사용하는 HTTP Method는?  
   정답: PUT

9. 데이터 삭제에 주로 사용하는 HTTP Method는?  
   정답: DELETE

10. API 문서 자동화 및 테스트 도구는?  
    정답: Swagger

11. PDF에서 사용한 Swagger 라이브러리 계열은?  
    정답: Springfox

12. Swagger 2를 활성화하는 어노테이션은?  
    정답: `@EnableSwagger2`

13. Swagger 설정의 핵심 Bean 타입은?  
    정답: `Docket`

14. Swagger에서 API 그룹명을 지정하는 어노테이션은?  
    정답: `@Api`

15. Swagger에서 API 엔드포인트 설명을 작성하는 어노테이션은?  
    정답: `@ApiOperation`

16. Swagger에서 파라미터 설명을 작성하는 어노테이션은?  
    정답: `@ApiParam`

17. MyBatis에서 Java 메서드와 SQL id가 맞지 않으면 주로 발생하는 오류는?  
    정답: `Invalid bound statement`

18. DB Connection Pool로 사용한 라이브러리는?  
    정답: HikariCP

19. `@Transactional`을 활성화하는 설정 어노테이션은?  
    정답: `@EnableTransactionManagement`

20. Spring MVC에서 Front Controller 역할을 하는 Servlet은?  
    정답: `DispatcherServlet`

---

# PART 6. 실습 과제

## TODO 구현 범위

학생용 프로젝트는 다음 파일에 TODO가 포함되어 있습니다.

```text
student-boardapi-todo
├── org.scoula.config.SwaggerConfig
├── org.scoula.config.ServletConfig
├── org.scoula.board.controller.BoardController
├── org.scoula.board.service.BoardServiceImpl
├── org.scoula.board.dto.BoardDTO
└── org/scoula/board/mapper/BoardMapper.xml
```

## 구현 과제

1. `SwaggerConfig`에서 `@EnableSwagger2`와 `Docket` Bean 완성
2. `ServletConfig`에서 Swagger Resource Handler 완성
3. `BoardController`에 REST CRUD API 완성
4. `BoardServiceImpl`에서 생성/수정/삭제 후 처리 객체 반환
5. `BoardDTO`에서 DTO ↔ VO 변환 완성
6. `BoardMapper.xml`에서 CRUD SQL 완성
7. Swagger UI에서 API 문서 확인 및 테스트

## 실행 순서

1. MySQL 실행
2. `sql/tbl_board.sql` 실행
3. `RootConfig.java`의 DB 계정 수정
4. IntelliJ에서 Gradle 프로젝트 Import
5. Tomcat 9 설정
6. Application Context `/` 설정
7. 실행 후 Swagger 접속

```text
http://localhost:8080/swagger-ui.html
```

---

# PART 7. Swagger 테스트 예시 JSON

## 게시글 등록

```json
{
  "title": "Swagger 등록 테스트",
  "content": "Swagger UI에서 JSON으로 등록합니다.",
  "writer": "user00"
}
```

## 게시글 수정

```json
{
  "no": 1,
  "title": "Swagger 수정 테스트",
  "content": "PUT 요청으로 수정합니다.",
  "writer": "user00"
}
```

---

# PART 8. 자주 발생하는 오류와 해결

## 1. `/swagger-ui.html` 404

원인:

- `SwaggerConfig`가 ServletConfigClasses에 등록되지 않음
- ResourceHandler 누락
- URL 매핑에 `/swagger-ui.html`, `/webjars/**` 등이 누락

해결:

```java
return new Class[] { ServletConfig.class, SwaggerConfig.class };
```

```java
registry.addResourceHandler("/swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
```

## 2. JSON 요청이 객체로 변환되지 않음

원인:

- `@RequestBody` 누락
- `Content-Type: application/json` 누락
- Jackson 의존성 누락

## 3. `Invalid bound statement`

원인:

- Mapper Interface 메서드명과 XML SQL id 불일치
- XML namespace 불일치
- Mapper XML 위치 오류

## 4. Swagger 숫자 파라미터 오류

원인:

- `@ApiParam(example = "문자열")`처럼 숫자 타입에 맞지 않는 예시를 준 경우

해결:

```java
@ApiParam(value = "게시글 ID", required = true, example = "1")
```
