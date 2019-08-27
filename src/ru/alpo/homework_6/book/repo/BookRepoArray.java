package ru.alpo.homework_6.book.repo;

import ru.alpo.homework_6.*;
import ru.alpo.homework_6.author.domain.*;
import ru.alpo.homework_6.book.domain.*;

public class BookRepoArray implements BookRepo {

    private static final int BOOK_REPOARRAY_CAPACITY = 10;
    private static Book[] books = new Book[BOOK_REPOARRAY_CAPACITY];
    private static int bookIndex = 0;

    @Override
    public int count() {
        int counter = 0;
        for (Book book : Storage.books) {
            if (book != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void print() {
        for (Book book : Storage.books) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        Storage.removeBook(book);

    }

    @Override
    public Long add(Book book) {
        Storage.addBook(book);
        return book.getId();
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long id) {
        int index = 0;

        for (Book book : Storage.books) {
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

}
