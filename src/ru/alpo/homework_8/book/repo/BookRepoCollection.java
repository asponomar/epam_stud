package ru.alpo.homework_8.book.repo;

import ru.alpo.homework_8.author.domain.*;
import ru.alpo.homework_8.book.domain.*;
import ru.alpo.homework_8.storage.*;

import java.util.*;

public class BookRepoCollection implements BookRepo {
    @Override
    public int count() {
        return CollectionStorage.getTotalBooks();
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
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return findBooksByAuthorAsList(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
        List<Book> found = new ArrayList<>();

        for (Book b : CollectionStorage.getAllBooks()) {
            Author authors[] = b.getAuthors();
            for (Author a : authors) {
                if (a != null && authorId == a.getId()) {
                    found.add(b);
                    break;
                }
            }
        }
        return found;
    }
}
