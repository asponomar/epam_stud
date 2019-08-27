package ru.alpo.homework_7.book.repo;

import ru.alpo.homework_7.*;
import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.book.domain.*;

import java.util.*;

public class BookRepoArray implements BookRepo {

    private static final int BOOK_REPOARRAY_CAPACITY = 10;
    private static Book[] books = new Book[BOOK_REPOARRAY_CAPACITY];
    private static int bookIndex = 0;

    @Override
    public int count() {
        return Storage.getTotalBooksFromArray();
    }

    @Override
    public void print() {
        for (Book book : Storage.booksArray) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        Storage.removeBookFromArray(book);

    }

    @Override
    public Long add(Book book) {
        Storage.addBookToArray(book);
        return book.getId();
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long id) {
        int index = 0;

        for (Book book : Storage.booksArray) {
            for (Author a : book.getAuthors()) {
                if (a.getId().equals(id)) {
                    if (bookIndex % BOOK_REPOARRAY_CAPACITY == 0 && bookIndex != 0) {
                        increaseBookRepoArray();
                    }
                    books[index] = book;
                    index++;
                }
                break;
            }
        }
        return books;
    }

    public static void increaseBookRepoArray() {
        Book[] books = new Book[bookIndex + BOOK_REPOARRAY_CAPACITY];
        System.arraycopy(books, 0, books, 0, books.length);
        BookRepoArray.books = books;
    }

    @Override
    public List<Book> findBooksByAuthorsAsList(long id) {
        return null;
    }

}
