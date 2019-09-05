package ru.alpo.homework_11.storage;

import ru.alpo.homework_11.author.domain.*;
import ru.alpo.homework_11.book.domain.*;

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
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                books.remove(b);
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
        Iterator<Author> authors = CollectionStorage.authors.iterator();
        while (authors.hasNext()) {
            boolean idsMatches = authors.next().getId().equals(author.getId());
            if (idsMatches) {
                authors.remove();
                break;
            }
        }
    }

}