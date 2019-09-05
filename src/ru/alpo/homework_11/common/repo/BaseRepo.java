package ru.alpo.homework_11.common.repo;

import java.util.*;

public interface BaseRepo<T, ID> {
    int count();

    void print();

    void delete(T t);

    Long add(T t);

    T getById(ID id);

    T[] findAsArray(ID id);

    List<T> findAsList(ID id);

}
