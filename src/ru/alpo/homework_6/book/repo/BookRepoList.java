package ru.alpo.homework_6.book.repo;

import ru.alpo.homework_6.book.domain.Book;

public class BookRepoList implements BookRepo {
    @Override
    public int count() {
        return 0;
    }

    @Override
    public void print() {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Long add(Book book) {
        return null;
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long id) {
        return new Book[0];
    }
}
