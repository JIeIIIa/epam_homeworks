package mape.lab01.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    Optional<T> findById(Integer id);

    List<T> findAll();

    boolean insert(T t);

    boolean update(Integer id, T t);

    boolean delete(T t);
}
