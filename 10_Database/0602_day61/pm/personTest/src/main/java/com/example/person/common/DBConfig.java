package com.example.person.common;

import java.io.InputStream;
import java.util.Properties;

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
            throw new RuntimeException("DB 설정 파일 로드에 실패했습니다.", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("필수 DB 설정 값이 없습니다.");
        }

        return value.trim();
    }
}
