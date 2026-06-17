## 1. 프로젝트 개요

핵심 요구사항

1. MySQL에 `scoula_db` 데이터베이스를 생성한다.
2. `scoula` 사용자를 생성하고 `scoula_db`에 권한을 부여한다.
3. JDBC DriverManager를 사용하여 DB 연결 테스트를 작성한다.
4. HikariCP DataSource 의존성을 추가한다.
5. `application.properties`에 데이터소스 연결 설정을 작성한다.
6. `RootConfig.java`에서 `application.properties` 값을 읽어 `DataSource` Bean을 등록한다.
7. `DataSourceTest.java`에서 Spring이 생성한 `DataSource` Bean과 DB 연결을 테스트한다.

---

## 2. 개발 환경

| 구분            | 내용                    |
| --------------- | ----------------------- |
| Java            | 17                      |
| Build Tool      | Gradle                  |
| Spring          | Spring Framework 5.3.37 |
| Database        | MySQL                   |
| Connection Pool | HikariCP 5.1.0          |
| Test            | JUnit Jupiter 5.10.2    |
| Package Root    | `org.scoula`            |

---

## 3. 프로젝트 구조

```text
ex04-spring-mysql-gradle
├── build.gradle
├── settings.gradle
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── scoula
    │   │           └── config
    │   │               └── RootConfig.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── org
                └── scoula
                    └── persistence
                        ├── JDBCTests.java
                        └── DataSourceTest.java
```

---

## 4. MySQL 사전 준비

PDF 2페이지 요구사항에 따라 MySQL에서 다음 SQL을 실행합니다.

```sql
create database scoula_db;

create user 'scoula'@'%' identified by '1234';

grant all privileges on scoula_db.* to 'scoula'@'%';

flush privileges;
```

로컬 접속만 허용하고 싶다면 다음 계정도 추가

```sql
create user 'scoula'@'localhost' identified by '1234';
grant all privileges on scoula_db.* to 'scoula'@'localhost';
flush privileges;
```

---

## 5. DB 연결 설정

`src/main/resources/application.properties`

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/scoula_db?serverTimezone=Asia/Seoul&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true
jdbc.username=scoula
jdbc.password=1234

jdbc.hikari.maximum-pool-size=10
jdbc.hikari.minimum-idle=2
jdbc.hikari.connection-timeout=30000
jdbc.hikari.idle-timeout=600000
jdbc.hikari.pool-name=ScoulaHikariPool
```

### 주요 설정

| 설정                 | 설명                              |
| -------------------- | --------------------------------- |
| `jdbc.driver`        | MySQL JDBC 드라이버 클래스명      |
| `jdbc.url`           | MySQL 접속 URL                    |
| `jdbc.username`      | DB 사용자명                       |
| `jdbc.password`      | DB 비밀번호                       |
| `maximum-pool-size`  | 커넥션 풀의 최대 커넥션 수        |
| `minimum-idle`       | 유휴 상태로 유지할 최소 커넥션 수 |
| `connection-timeout` | 커넥션 획득 대기 시간             |
| `pool-name`          | HikariCP 커넥션 풀 이름           |

---

## 6. 주요 파일

### 6.1 `RootConfig.java`

`RootConfig`는 Spring 설정 클래스입니다.

```java
@Configuration
@PropertySource("classpath:application.properties")
public class RootConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        ...
    }
}
```

핵심 역할

1. `@Configuration`으로 Spring 설정 클래스임을 선언합니다.
2. `@PropertySource`로 `application.properties`를 읽습니다.
3. `@Value`로 DB 접속 정보를 주입받습니다.
4. `HikariConfig`에 DB 연결 정보를 설정합니다.
5. `HikariDataSource`를 Spring Bean으로 등록합니다.
6. `destroyMethod = "close"`를 지정해 Spring Context 종료 시 커넥션 풀을 안전하게 닫습니다.

---

### 6.2 `JDBCTests.java`

`JDBCTests`는 Spring을 사용하지 않고 JDBC 드라이버만으로 DB 연결을 확인합니다.

```java
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
```

테스트의 목적

1. MySQL JDBC 드라이버가 정상 로딩되는지 확인합니다.
2. DB 주소, 사용자명, 비밀번호가 올바른지 확인합니다.
3. Spring 설정 이전에 순수 JDBC 연결 문제를 먼저 분리해서 확인합니다.

---

### 6.3 `DataSourceTest.java`

`DataSourceTest`는 Spring TestContext를 사용해 `RootConfig`가 생성한 `DataSource` Bean을 테스트합니다.

```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
class DataSourceTest {
    @Autowired
    private DataSource dataSource;
}
```

테스트의 목적

1. `RootConfig`가 Spring Context에 정상 등록되는지 확인합니다.
2. `application.properties` 값이 정상 주입되는지 확인합니다.
3. `DataSource` Bean이 정상 생성되는지 확인합니다.
4. HikariCP를 통해 실제 DB Connection을 얻을 수 있는지 확인합니다.

---

## 7. 실행 방법

### 7.1 전체 테스트 실행

```bash
./gradlew test
```

Windows에서는 다음 명령어를 사용할 수 있습니다.

```bash
gradlew.bat test
```

### 7.2 특정 테스트만 실행

```bash
./gradlew test --tests org.scoula.persistence.JDBCTests
```

```bash
./gradlew test --tests org.scoula.persistence.DataSourceTest
```

---

## 8. 테스트 실패 시 점검 사항

### 8.1 `Communications link failure`

MySQL 서버가 실행 중인지 확인합니다.

```bash
mysql --version
mysql -u scoula -p
```

### 8.2 `Access denied for user 'scoula'`

사용자 권한 또는 비밀번호가 다를 가능성이 큽니다.

```sql
select user, host from mysql.user where user = 'scoula';
show grants for 'scoula'@'%';
```

### 8.3 `Unknown database 'scoula_db'`

데이터베이스가 생성되지 않은 상태입니다.

```sql
show databases;
create database scoula_db;
```

### 8.4 `ClassNotFoundException: com.mysql.cj.jdbc.Driver`

MySQL Connector 의존성이 누락된 경우입니다. 이 프로젝트의 `build.gradle`에는 다음 의존성이 포함되어 있습니다.

```gradle
implementation "mysql:mysql-connector-java:8.0.33"
```

---

## 9. 핵심 정리

JDBC 연결 테스트와 DataSource 테스트는 목적이 다릅니다.

| 테스트           | 목적                                       |
| ---------------- | ------------------------------------------ |
| `JDBCTests`      | 순수 JDBC 드라이버와 DB 계정 정보 검증     |
| `DataSourceTest` | Spring Bean 설정과 HikariCP 커넥션 풀 검증 |

실무에서는 단순 `DriverManager` 방식보다 `DataSource`를 사용합니다. 이유는 매 요청마다 DB Connection을 새로 만들면 비용이 크기 때문입니다. HikariCP 같은 커넥션 풀을 사용하면 미리 만들어 둔 Connection을 재사용할 수 있어 성능과 안정성이 좋아집니다.

---
