package com.kb.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {
    // 스프링 의존성 주입 어노테이션
    // 만일 해당 타입의 존재한다면 여기에 주입
    @Autowired
    private SampleService sampleService;

    @Test
    public void testService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }
}
