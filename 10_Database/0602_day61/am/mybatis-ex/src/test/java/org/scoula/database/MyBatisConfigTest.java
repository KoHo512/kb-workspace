package org.scoula.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyBatisConfigTest {
    @Test
    void testConnection() {
        assertNotNull(MyBatisConfig.getSqlSession(), "MyBatis SqlSession should not be null");
    }
}
