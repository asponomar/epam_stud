package ru.alpo.homework_5.book;

public interface BookRepo {
    int count();

    void print();

    void delete(Book book);

    Long add(Book book);

}
