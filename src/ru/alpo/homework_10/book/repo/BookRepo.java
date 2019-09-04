package ru.alpo.homework_10.book.repo;

import ru.alpo.homework_10.book.domain.*;

import java.util.*;

public interface BookRepo {

    int count();

    void print();

    void delete(Book book);

    Long add(Book book);

    Book[] findBooksByAuthorAsArray(long id);

    List<Book> findBooksByAuthorAsList(long id);
}
