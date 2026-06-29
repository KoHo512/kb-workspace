package org.scoula.security.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class })
@Log4j2
class JwtProcessorTest {

    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        String username = "user00";
        String token = jwtProcessor.generateToken(username);
        log.info("generateToken()......" + token);
        assertNotNull(token);
    }

    @Test
    void getUsername() {
        // generateToken()으로 생성된 토큰 사용 - 생성 후 5분 지나면 실패
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMDAiLCJpYXQiOjE3ODI2OTk5MjYsImV4cCI6MTc4MjcwMDIyNn0.OGcmrP5gCOXAalvbGTClHaYWwxocjOPY4kuyoBhPOR1idlIVpOmewwXbpLrljAHc";

        String username = jwtProcessor.getUsername(token);
        log.info("getUsername()......" + username);
        assertNotNull(username);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMDAiLCJpYXQiOjE3ODI2OTk5MjYsImV4cCI6MTc4MjcwMDIyNn0.OGcmrP5gCOXAalvbGTClHaYWwxocjOPY4kuyoBhPOR1idlIVpOmewwXbpLrljAHc";

        boolean isValid = jwtProcessor.validateToken(token);
        log.info("validateToken()......" + isValid);
        assertTrue(isValid);
    }
}