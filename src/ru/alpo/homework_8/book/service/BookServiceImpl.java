package ru.alpo.homework_8.book.service;

import ru.alpo.homework_8.author.domain.*;
import ru.alpo.homework_8.author.repo.*;
import ru.alpo.homework_8.book.domain.*;
import ru.alpo.homework_8.book.repo.*;
import ru.alpo.homework_8.storage.*;

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
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return bookRepo.findBooksByAuthorAsArray(authorId);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
        return bookRepo.findBooksByAuthorAsList(authorId);
    }
}
