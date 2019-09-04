package ru.alpo.homework_10.book.service;

import ru.alpo.homework_10.book.domain.*;
import ru.alpo.homework_10.book.repo.*;
import ru.alpo.homework_10.repo.*;
import ru.alpo.homework_10.service.*;

import java.util.*;

public class BookService implements Service<Book> {

    private Repo<Book> bookRepo;

    public BookService(Repo<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public int count() {
        return bookRepo.count();
    }

    @Override
    public void print() {
        bookRepo.print();
    }

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    @Override
    public Long add(Book book) {
        return bookRepo.add(book);
    }

    @Override
    public Book getById(long id) {
        return bookRepo.getById(id);
    }

    @Override
    public Book[] findAsArray(long authorId) {
        return bookRepo.findAsArray(authorId);
    }

    @Override
    public List<Book> findAsList(long authorId) {
        return bookRepo.findAsList(authorId);
    }
}
