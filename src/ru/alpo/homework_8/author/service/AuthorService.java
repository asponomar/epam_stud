package ru.alpo.homework_8.author.service;

import ru.alpo.homework_8.author.domain.*;

public interface AuthorService {
    int count();

    void print();

    void delete(Author author);

    Long add(Author author);

}
