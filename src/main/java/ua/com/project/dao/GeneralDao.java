package ua.com.project.dao;

import java.util.List;

public interface GeneralDao<T> {

    void save(T obj);

    void update(T obj);

    void delete(T obj);

    void deleteAll();

    List<T> findAll();

    T findById(Long id);

    T findByName(String name);

}
