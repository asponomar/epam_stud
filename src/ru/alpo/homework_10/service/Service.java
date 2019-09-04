package ru.alpo.homework_10.service;

import java.util.*;

public interface Service<T> {

    int count();

    void print();

    void delete(T t);

    Long add(T t);

    T getById (long id);

    T[] findAsArray(long Id);

    List<T> findAsList(long Id);
}
