package com.example.jdbc.common;

import java.sql.Connection;

/**
 * TransactionCallback
 * ------------------------------------------------------------
 * 역할:
 * - TransactionManager 안에서 실행할 비즈니스 로직을 람다식으로 전달하기 위한 함수형 인터페이스입니다.
 */
@FunctionalInterface
public interface TransactionCallback<T> {

    T doInTransaction(Connection con) throws Exception;
}
