# security3: Spring Framework + Spring Security

이 프로젝트는 Spring Boot를 사용하지 않는 전통적 Spring Framework WAR 예제입니다.
자동 설정과 내장 서버가 없기 때문에 Servlet 초기화, MVC 설정, Security 필터 등록을
코드에서 직접 확인할 수 있습니다.

## 학습 목표

- URL별 접근 제어와 역할 기반 인가을 구현한다.
- 이전 단계와 설정 차이를 코드로 비교한다.

## 기술 기준

- Java 17
- Spring Framework 5.3.39
- Spring Security 5.8.16
- Thymeleaf 3.1.3.RELEASE
- Gradle WAR 프로젝트
- Javax Servlet 4 / Tomcat 9 계열

## 실행

1. `gradlew clean war`를 실행합니다.
2. `build/libs/security3.war`를 Tomcat 9의 `webapps` 폴더에 배포합니다.
3. Tomcat을 시작합니다.
4. `http://localhost:8080/security3/`에 접속합니다.

> WAR 파일명을 `ROOT.war`로 바꾸어 배포하면 컨텍스트 경로 없이 `/`로 접속합니다.

## 실습 계정

- `duke / 1111` (ROLE_USER)
- `admin / adminpass` (ROLE_ADMIN)

## Spring Boot 프로젝트와 달라진 점

- `@SpringBootApplication`과 `SpringApplication.run()`이 없습니다.
- 내장 Tomcat 대신 외부 Tomcat에 WAR를 배포합니다.
- `AppInitializer`가 `web.xml`과 DispatcherServlet 등록을 대신합니다.
- `SecurityWebApplicationInitializer`가 `springSecurityFilterChain`을 등록합니다.
- `WebMvcConfig`에서 컴포넌트 스캔, 정적 자원, Thymeleaf를 직접 설정합니다.
- 사용자와 데이터소스도 Java Config로 명시합니다.

## 주요 파일 읽는 순서

1. `build.gradle`
2. `config/AppInitializer.java`
3. `config/SecurityWebApplicationInitializer.java`
4. `config/WebMvcConfig.java`
5. `config/SecurityConfig.java`
6. Controller / Service / HTML

## 주의

- 교육용 계정과 비밀번호를 운영 환경에서 사용하면 안 됩니다.
- CSRF는 기본 활성화 상태입니다. 로그아웃은 POST 요청을 사용합니다.
- 비밀번호는 평문이 아닌 BCrypt 해시로 저장합니다.
- 이 교안은 Spring Security 5.x 학습을 위해 `authorizeRequests()`와
  `antMatchers()`를 사용합니다. 5.8에서는 6.x 전환 준비로 deprecated 경고가
  표시되지만 5.8.16에서 정상 동작하며, 빌드 실패가 아닙니다.
