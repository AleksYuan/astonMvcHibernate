package com.yanaev.aston.dao;

import com.yanaev.aston.model.User;

import java.util.List;
import java.util.Optional;

public interface AstonMvcDAO<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void delete(T entity);

    void save(T entity);

    void update(T entity);

}
