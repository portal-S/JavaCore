package com.portal.javacore.chapter1.controller.interfaces;

import java.util.List;

public interface GenericController<T> {

    public void create(T t);

    public void delete(int i);

    public void update(T t);

    public T read(int i);

    public List<T> readAll();

}
