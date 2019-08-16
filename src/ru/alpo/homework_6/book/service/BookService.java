package ru.alpo.homework_6.book.service;

import ru.alpo.homework_6.book.domain.Book;

public interface BookService {
    int count();

    void print();

    void delete(Book book);

    Long add(Book book);

}
