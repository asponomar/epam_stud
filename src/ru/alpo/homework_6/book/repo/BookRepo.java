package ru.alpo.homework_6.book.repo;

import ru.alpo.homework_6.book.domain.Book;

public interface BookRepo {
    int count();

    void print();

    void delete(Book book);

    Long add(Book book);

}
