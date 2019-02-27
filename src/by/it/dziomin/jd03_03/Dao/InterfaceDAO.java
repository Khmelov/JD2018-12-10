package by.it.dziomin.jd03_03.Dao;

import java.util.List;

interface InterfaceDAO<T> {
    T getById(Long id);
    List<T> getAll();
    T create(T entity);
    void update(T entity);
    void delete(T entity);
}
