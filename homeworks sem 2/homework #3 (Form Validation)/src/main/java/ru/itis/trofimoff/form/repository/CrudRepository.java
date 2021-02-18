package ru.itis.trofimoff.form.repository;

import java.util.List;
import java.util.Map;

public interface CrudRepository<T> {

    void save(T entity);
    void update(T entity);
    void delete(T entity);

    List<T> findAll();
}