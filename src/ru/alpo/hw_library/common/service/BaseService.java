package ru.alpo.hw_library.common.service;

public interface BaseService<T, ID> {

    int count();

    void print();

    void delete(T t);

    Long add(T t);

    T getById(ID id);

}
