package com.example.person.common;

import java.sql.Connection;

@FunctionalInterface
public interface TransactionCallback<T> {

    T doInTransaction(Connection con) throws Exception;
}
