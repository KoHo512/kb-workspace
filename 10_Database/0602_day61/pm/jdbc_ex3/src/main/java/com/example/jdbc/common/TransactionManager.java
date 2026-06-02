package com.example.jdbc.common;

import java.sql.Connection;

/**
 * TransactionManager
 * ------------------------------------------------------------
 * 역할:
 * - Connection 생성
 * - autoCommit false 설정
 * - commit / rollback 처리
 * - Connection close 처리
 *
 *  포인트:
 * - DAO가 Connection을 만들지 않고 Service 계층에서 트랜잭션 단위로 Connection을 공유합니다.
 * - 여러 DAO 작업을 하나의 트랜잭션으로 묶을 수 있습니다.
 */
public class TransactionManager {

    public static <T> T execute(TransactionCallback<T> callback) throws Exception {
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);

            T result = callback.doInTransaction(con);

            con.commit();

            return result;

        } catch (Exception e) {
            if (con != null) {
                con.rollback();
            }

            throw e;

        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } finally {
                    con.close();
                }
            }
        }
    }
}
