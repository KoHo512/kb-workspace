package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * RootConfig
 * -----------------------------------------------------------------------------
 * application-context.xml에 해당하는 Root ApplicationContext 설정입니다.
 *
 * 담당 영역
 * 1. Service Bean 스캔
 * 2. DataSource 생성
 * 3. MyBatis SqlSessionFactory 생성
 * 4. Mapper 인터페이스 스캔
 * 5. 트랜잭션 매니저 등록
 *
 * PDF의 파일 업로드 예제에서는 게시글 insert와 첨부파일 insert가 함께 실행됩니다.
 * 이때 하나라도 실패하면 데이터 정합성이 깨질 수 있으므로 @EnableTransactionManagement와
 * PlatformTransactionManager가 반드시 필요합니다.
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.scoula.board.service")
@MapperScan(basePackages = "org.scoula.board.mapper")
@EnableTransactionManagement
public class RootConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(5);
        return new HikariDataSource(config);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*Mapper.xml"));
        factoryBean.setTypeAliasesPackage("org.scoula.board.domain");
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
