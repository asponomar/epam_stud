package ru.alpo.homework_11.book.repo;

import ru.alpo.homework_11.author.domain.*;
import ru.alpo.homework_11.book.domain.*;
import ru.alpo.homework_11.storage.*;

import java.util.*;

public class BookRepoCollection implements BookRepo {

    @Override
    public int count() {
        return CollectionStorage.getTotalBooksQuantity();
    }

    @Override
    public void print() {
        for (Book book : CollectionStorage.getAllBooks()) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    @Override
    public void delete(Book book) {
        CollectionStorage.removeBook(book);
    }

    @Override
    public Long add(Book book) {
        CollectionStorage.addBook(book);
        return book.getId();
    }

    @Override
    public Book getById(Long bookId) {
        Iterator<Book> books = CollectionStorage.books.iterator();
        Book book = new Book();
        while (books.hasNext()) {
            boolean idsMatches = books.next().getId().equals(bookId);
            book = idsMatches ? book : null;
        }
        return book;
    }

    @Override
    public Book[] findAsArray(Long authorId) {
        return findAsList(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findAsList(Long authorId) {
        List<Book> found = new ArrayList<>();

        for (Book b : CollectionStorage.getAllBooks()) {
            List<Author> authors = b.getAuthors();
            for (Author a : authors) {
                if (a != null && authorId == a.getId()) {
                    found.add(b);
                    break;
                }
            }
        }
        return found;
    }

    @Override
    public Book[] findBooksByAuthorAsArray(Long id) {
        return new Book[0];
    }

    @Override
    public List<Book> findBooksByAuthorAsList(Long id) {
        return null;
    }
}
