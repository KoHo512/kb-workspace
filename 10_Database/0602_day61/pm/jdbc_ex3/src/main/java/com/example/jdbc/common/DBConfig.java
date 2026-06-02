package com.example.jdbc.common;

import java.io.InputStream;
import java.util.Properties;

/**
 * DBConfig
 * ------------------------------------------------------------
 * 역할:
 * - src/main/resources/db.properties 파일을 읽어 DB 접속 정보를 관리합니다.
 *
 * 실무 포인트:
 * - DB URL, 계정, 비밀번호를 Java 코드에 직접 적으면 보안과 유지보수에 불리합니다.
 * - 운영/개발/테스트 환경별로 설정 파일을 분리
 */
public class DBConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = DBConfig.class.getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException("db.properties 파일을 찾을 수 없습니다.");
            }

            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("DB 설정 파일 로딩 실패", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("필수 DB 설정값이 없습니다: " + key);
        }

        return value.trim();
    }
}
