package ru.alpo.hw_library.storage;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.book.domain.*;

import java.util.*;

public final class CollectionStorage {

    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    private CollectionStorage() {
    }

    //-----------Books---------------------------------------------------------
    public static List<Book> getAllBooks() {
        return books;
    }

    public static int getTotalBooksQuantity() {
        return books.size();
    }

    public static void addBook(Book book) {
        book.setId(IdGenerator.generateId());
        books.add(book);
    }

    public static void removeBook(Book book) {
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            boolean idsMatches = bookIterator.next().getId().equals(book.getId());
            if (idsMatches) {
                bookIterator.remove();
                break;
            }
        }
    }

    //-----------Authors---------------------------------------------------------
    public static List<Author> getAllAuthors() {
        return authors;
    }

    public static int getTotalAuthorsQuantity() {
        return authors.size();
    }

    public static void addAuthor(Author author) {
        author.setId(IdGenerator.generateId());
        authors.add(author);
    }

    public static void removeAuthor(Author author) {
        Iterator<Author> authorIterator = authors.iterator();
        while (authorIterator.hasNext()) {
            boolean idsMatches = authorIterator.next().getId().equals(author.getId());
            if (idsMatches) {
                authorIterator.remove();
                break;
            }
        }
    }

}