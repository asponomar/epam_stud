package ru.alpo.homework_11.book.service;

import ru.alpo.homework_11.book.domain.*;
import ru.alpo.homework_11.common.repo.*;

import java.util.*;

public class BookServiceImpl implements BookService {

    private BaseRepo<Book> bookRepo;

    public BookServiceImpl(BaseRepo<Book> bookRepo) {
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
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return bookRepo.findAsArray(authorId);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
        return bookRepo.findAsList(authorId);
    }

}
