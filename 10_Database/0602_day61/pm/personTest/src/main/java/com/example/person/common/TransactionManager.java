package com.example.person.common;

import java.sql.Connection;

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
