package ru.alpo.homework_11.common.service;

public interface BaseService<T> {

    int count();

    void print();

    void delete(T t);

    Long add(T t);

    T getById(long id);

}
