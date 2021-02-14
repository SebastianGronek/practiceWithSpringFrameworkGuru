package com.example.ProjectWithSpringGuru.services;

import java.util.List;

public interface CRUDService<T> {
    T getById(Integer id);

    List<?> listAll();

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
