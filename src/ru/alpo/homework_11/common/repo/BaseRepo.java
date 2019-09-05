package ru.alpo.homework_11.common.repo;

import java.util.*;

public interface BaseRepo<T> {
    int count();

    void print();

    void delete(T t);

    Long add(T t);

    T getById(long id);

    T[] findAsArray(long id);

    List<T> findAsList(long id);

}
