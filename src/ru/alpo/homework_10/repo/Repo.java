package ru.alpo.homework_10.repo;

import java.util.*;

public interface Repo<T> {
    int count();

    void print();

    void delete(T t);

    Long add(T t);

    T getById (long id);

    T[] findAsArray(long id);

    List<T> findAsList(long id);

}
