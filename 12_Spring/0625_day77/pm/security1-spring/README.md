# security1-spring: Spring Framework + Spring Security

## 학습 목표

- Spring Boot 없이 MVC와 Security 필터 체인을 기동한다.
- 기본 로그인 페이지와 메모리 인증을 확인한다.

## 기술 기준

- Java 17
- Spring Framework 5.3.39
- Spring Security 5.8.16
- Thymeleaf 3.1.3.RELEASE
- Gradle WAR 프로젝트
- Javax Servlet 4 / Tomcat 9 계열

## 실행

1. `gradlew clean war`를 실행합니다.
2. `build/libs/security1-spring.war`를 Tomcat 9의 `webapps` 폴더에 배포합니다.
3. Tomcat을 시작합니다.
4. `http://localhost:8080/security1-spring/`에 접속합니다.

> WAR 파일명을 `ROOT.war`로 바꾸어 배포하면 컨텍스트 경로 없이 `/`로 접속합니다.

## 실습 계정

- `duke / 1111` (ROLE_USER)

## 주요 파일 읽는 순서

1. `build.gradle`
2. `config/AppInitializer.java`
3. `config/SecurityWebApplicationInitializer.java`
4. `config/WebMvcConfig.java`
5. `config/SecurityConfig.java`
6. Controller / Service / HTML

## 주의

- CSRF는 기본 활성화 상태입니다. 로그아웃은 POST 요청을 사용합니다.
- 비밀번호는 평문이 아닌 BCrypt 해시로 저장합니다.
- Spring Security 5.x 학습을 위해 `authorizeRequests()`와
  `antMatchers()`를 사용합니다. 5.8에서는 6.x 전환 준비로 deprecated 경고가
  표시되지만 5.8.16에서 정상 동작하며, 빌드 실패가 아닙니다.
