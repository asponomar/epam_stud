package ru.alpo.homework_5.author;

public interface AuthorRepo {
    int count();

    void print();

    void delete(Author author);

    Long add(Author author);

}
