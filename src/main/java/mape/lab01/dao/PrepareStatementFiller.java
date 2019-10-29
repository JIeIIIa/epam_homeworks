package mape.lab01.dao;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface PrepareStatementFiller<T> {
    void fill(PreparedStatement ps, T t) throws Exception;
}
