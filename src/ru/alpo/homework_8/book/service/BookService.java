package ru.alpo.homework_8.book.service;

import ru.alpo.homework_8.book.domain.*;

import java.util.*;

public interface BookService {

    int count();

    void print();

    void delete(Book book);

    Long add(Book book);

    Book[] findBooksByAuthorAsArray(long authorId);

    List<Book> findBooksByAuthorAsList(long authorId);
}
