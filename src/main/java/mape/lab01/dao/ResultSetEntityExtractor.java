package mape.lab01.dao;

import java.sql.ResultSet;

@FunctionalInterface
public interface ResultSetEntityExtractor<T> {
    T map(ResultSet rs) throws Exception;
}
