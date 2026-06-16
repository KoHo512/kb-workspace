package com.kb.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = "file:/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(locations = "")
public class SampleTests {
    // 스프링 의존성 주입 어노테이션
    // 만일 해당 타입의 존재한다면 여기에 주입
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testConnection() throws Exception {
        Connection conneciton = dataSource.getConnection();
        log.info(conneciton);
        Assertions.assertNotNull(conneciton);
        conneciton.close();
    }
}
