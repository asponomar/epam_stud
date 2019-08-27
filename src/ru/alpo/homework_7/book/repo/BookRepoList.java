package ru.alpo.homework_7.book.repo;

import ru.alpo.homework_7.*;
import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.book.domain.*;

import java.util.*;

public class BookRepoList implements BookRepo {
    @Override
    public int count() {
        return Storage.getTotalBooksFromList();
    }

    @Override
    public void print() {
        for (Book b : Storage.booksList) {
            System.out.println(b);
        }
    }

    @Override
    public void delete(Book book) {
        Storage.removeBookFromList(book);
    }

    @Override
    public Long add(Book book) {
        Storage.addBookToList(book);
        return book.getId();
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long id) {
        return new Book[0];
    }

    @Override
    public List<Book> findBooksByAuthorsAsList(long id) {
        List<Book> found = new ArrayList<>();

        for (Book b : Storage.booksList) {
            Author authors[] = b.getAuthors();
            for (Author a : authors) {
                if (a != null && id == a.getId()) {
                    found.add(b);
                    break;
                }
            }
        }
        return found;
    }
}
