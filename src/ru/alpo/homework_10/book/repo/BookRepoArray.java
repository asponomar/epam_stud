package ru.alpo.homework_10.book.repo;

import ru.alpo.homework_10.author.domain.*;
import ru.alpo.homework_10.book.domain.*;
import ru.alpo.homework_10.repo.*;
import ru.alpo.homework_10.storage.*;

import java.util.*;

public class BookRepoArray implements Repo<Book> {

    @Override
    public int count() {
        return ArrayStorage.getTotalBooksQuantity();
    }

    @Override
    public void print() {
        for (Book book : ArrayStorage.getBooks()) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        ArrayStorage.removeBook(book);
    }

    @Override
    public Long add(Book book) {
        ArrayStorage.addBook(book);
        return book.getId();
    }

    @Override
    public Book getById(long bookId) {
        List<Book> books = CollectionStorage.books;
        Book book = new Book();
        for (Book b : books) {
            book = b.getId() == bookId ? book : null;
        }
        return book;
    }

    @Override
    public Book[] findAsArray(long authorId) {
        return findAsList(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findAsList(long authorId) {
        List<Book> found = new ArrayList<>();

        for (Book book : ArrayStorage.getBooks()) {
            for (Author a : book.getAuthors()) {
                if (Long.valueOf(authorId).equals(a.getId())) {
                    found.add(book);
                    break;
                }
            }
        }
        return found;
    }

}
