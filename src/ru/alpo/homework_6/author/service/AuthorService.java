package ru.alpo.homework_6.author.service;

import ru.alpo.homework_6.author.domain.Author;

public interface AuthorService {
    int count();

    void print();

    void delete(Author author);

    Long add(Author author);

}
