package ru.alpo.homework_7.author.service;

import ru.alpo.homework_7.author.domain.*;

public interface AuthorService {
    int count();

    void print();

    void delete(Author author);

    Long add(Author author);

}
