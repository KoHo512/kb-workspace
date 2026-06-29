package org.scoula.security;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        RootConfig.class,
        SecurityConfig.class
})
@Log4j2
public class PasswordEncoderTests {
    @Autowired
    private PasswordEncoder pwEncoder;

    @Test
    public void testEncode() {
        String str = "1234";

        // enStr, enStr2 다름 => 같은 문자열이어도 매번 다르게 암호화됨
        String enStr = pwEncoder.encode(str);
        log.info("passowrd : " + enStr);

        String enStr2 = pwEncoder.encode(str);
        log.info("passowrd : " + enStr2);

        // => 일치 여부 검사 matches()로 진행
        log.info("match : " + pwEncoder.matches(str, enStr));
        log.info("match : " + pwEncoder.matches(str, enStr2));
    }
}
