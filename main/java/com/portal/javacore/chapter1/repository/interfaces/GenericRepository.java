package com.portal.javacore.chapter1.repository.interfaces;

import com.portal.javacore.chapter1.model.Skill;

import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> findAll();

    T getOne(ID id);

    void delete(ID id);

    void create(T obj);

    void update(T obj);
}
