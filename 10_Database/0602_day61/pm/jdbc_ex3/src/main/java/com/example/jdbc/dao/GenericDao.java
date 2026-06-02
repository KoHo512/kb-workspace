package com.example.jdbc.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 * GenericDao
 * ------------------------------------------------------------
 * DAO의 공통 CRUD 규격입니다.
 *
 * 구조:
 * - DAO가 Connection을 만들지 않습니다.
 * - Service/TransactionManager에서 받은 Connection을 사용합니다.
 */
public interface GenericDao<T, ID> {

    ID insert(Connection con, T entity) throws Exception;

    Optional<T> findById(Connection con, ID id) throws Exception;

    List<T> findAll(Connection con) throws Exception;

    int update(Connection con, T entity) throws Exception;

    int delete(Connection con, ID id) throws Exception;
}
