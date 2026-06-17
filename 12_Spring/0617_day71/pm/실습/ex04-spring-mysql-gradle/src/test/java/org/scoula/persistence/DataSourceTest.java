package org.scoula.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Spring Container가 RootConfig를 읽고 DataSource Bean을 정상 생성하는지 검증합니다.
 *
 * <p>PDF 7페이지의 "DataSourceTest.java를 테스트에 추가하고,
 * RootConfig의 DataSource 빈 생성을 테스트" 요구사항을 반영합니다.</p>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
class DataSourceTest {

    /** RootConfig의 @Bean 메서드가 생성한 DataSource가 주입됩니다. */
    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("RootConfig의 DataSource Bean 생성 및 커넥션 획득 테스트")
    void testDataSourceConnection() throws Exception {
        assertNotNull(dataSource);

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("dataSource = " + dataSource);
            System.out.println("connection = " + connection);
            assertNotNull(connection);
        }
    }
}
