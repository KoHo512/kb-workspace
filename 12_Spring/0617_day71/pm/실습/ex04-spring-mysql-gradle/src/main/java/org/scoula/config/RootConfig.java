package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 애플리케이션의 루트 설정 클래스입니다.
 *
 * <p>PDF 요구사항의 핵심은 resources/application.properties에 작성한 DB 접속 정보를 읽어서
 * Spring Container에 DataSource Bean으로 등록하는 것입니다.</p>
 *
 * <p>@Configuration은 이 클래스가 Spring Bean 설정 클래스임을 의미합니다.
 * @PropertySource는 classpath의 application.properties 파일을 읽어 @Value 주입에 사용합니다.</p>
 */
@Configuration
@PropertySource("classpath:application.properties")
public class RootConfig {

    /** MySQL JDBC 드라이버 클래스명입니다. 예: com.mysql.cj.jdbc.Driver */
    @Value("${jdbc.driver}")
    private String driverClassName;

    /** MySQL 접속 URL입니다. 예: jdbc:mysql://localhost:3306/scoula_db */
    @Value("${jdbc.url}")
    private String jdbcUrl;

    /** DB 사용자명입니다. PDF 기준 사용자명은 scoula입니다. */
    @Value("${jdbc.username}")
    private String username;

    /** DB 비밀번호입니다. PDF 기준 비밀번호는 1234입니다. */
    @Value("${jdbc.password}")
    private String password;

    /** HikariCP 최대 커넥션 개수입니다. */
    @Value("${jdbc.hikari.maximum-pool-size:10}")
    private int maximumPoolSize;

    /** HikariCP 최소 유휴 커넥션 개수입니다. */
    @Value("${jdbc.hikari.minimum-idle:2}")
    private int minimumIdle;

    /** 커넥션 획득 대기 시간(ms)입니다. */
    @Value("${jdbc.hikari.connection-timeout:30000}")
    private long connectionTimeout;

    /** 커넥션 풀 이름입니다. 로그에서 풀을 식별할 때 사용합니다. */
    @Value("${jdbc.hikari.pool-name:ScoulaHikariPool}")
    private String poolName;

    /**
     * HikariCP 기반 DataSource Bean을 생성합니다.
     *
     * <p>DataSource는 애플리케이션이 DB 커넥션을 직접 매번 생성하지 않고,
     * 커넥션 풀에서 빌려 쓰게 해주는 핵심 객체입니다.</p>
     *
     * @return Spring Container에 등록될 HikariDataSource 객체
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setMinimumIdle(minimumIdle);
        config.setConnectionTimeout(connectionTimeout);
        config.setPoolName(poolName);

        return new HikariDataSource(config);
    }
}
