package ru.alpo.hw_library.book.service;

import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.book.repo.*;

import java.util.*;

public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
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
    public Book getById(Long id) {
        return bookRepo.getById(id);
    }

    @Override
    public Book[] findBooksByAuthorAsArray(Long authorId) {
        return bookRepo.findAsArray(authorId);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(Long authorId) {
        return bookRepo.findAsList(authorId);
    }

}
