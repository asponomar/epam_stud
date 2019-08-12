package ru.alpo.homework_5;

import ru.alpo.homework_5.author.Author;
import ru.alpo.homework_5.book.Book;

public class Library {

    public static void addAuthor(Author author) {
        Storage.addAuthor(author);
    }

    public static void addBook(Book book) {
        Storage.addBook(book);
    }

    public static void printAuthors() {
        for (int i = 0; i < Storage.authors.length; i++) {
            Author author = Storage.authors[i];
            if (author != null) {
                System.out.println(getAuthorAsStr(author));
            }
        }
    }

    public static void printBooks() {
        for (int i = 0; i < Storage.books.length; i++) {
            Book book = Storage.books[i];
            if (book != null) {
                System.out.println(getBookAsStr(book));
            }
        }
    }

    private static String getAuthorAsStr(Author author) {
        return author.toString();
    }

    private static String getBookAsStr(Book book) {
        return book.toString();
    }

    public static void printBooksInfo(Book book) {
    }

    public static void printSortedAuthors() {
    }

    public static void printSortedBooks() {
    }

    public static void deleteAuthor(String lastName, String name) {
        Storage.deleteAuthor(lastName, name);
    }

    public static void deleteBook(String name) {
        Storage.deleteBook(name);
    }
}
