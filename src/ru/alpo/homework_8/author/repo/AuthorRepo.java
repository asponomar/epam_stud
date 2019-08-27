package ru.alpo.homework_8.author.repo;

import ru.alpo.homework_8.author.domain.*;

import java.util.*;

public interface AuthorRepo {
    int count();

    void print();

    void delete(Author author);

    Long add(Author author);

    Author[] findAuthorsByBookAsArray(long id);

    List<Author> findAuthorsByBookAsList(long id);

}
