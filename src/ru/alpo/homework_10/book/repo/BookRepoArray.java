package ru.alpo.homework_10.book.repo;

import ru.alpo.homework_10.author.domain.*;
import ru.alpo.homework_10.book.domain.*;
import ru.alpo.homework_10.storage.*;

import java.util.*;

public class BookRepoArray implements BookRepo {

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
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return findBooksByAuthorAsList(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
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
