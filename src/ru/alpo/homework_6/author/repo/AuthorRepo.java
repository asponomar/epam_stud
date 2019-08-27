package ru.alpo.homework_6.author.repo;

import ru.alpo.homework_6.author.domain.Author;

public interface AuthorRepo {
    int count();

    void print();

    void delete(Author author);

    Long add(Author author);

    Author[] findAuthorsByBook(long id);

}
