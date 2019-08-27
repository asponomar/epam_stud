package ru.alpo.homework_7.book.service;

import ru.alpo.homework_7.book.domain.*;

public interface BookService {
    int count();

    void print();

    void delete(Book book);

    Long add(Book book);

}
