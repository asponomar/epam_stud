package ru.alpo.homework_10.storage;

import ru.alpo.homework_10.author.domain.*;
import ru.alpo.homework_10.book.domain.*;

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

    public static int getTotalBooks() {
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

    public static int getTotalAuthors() {
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



/*    public static Author searchAuthorById(Long searchAuthorId) {
        Author author = new Author();
        for (int i = 0; i < authors.length; i++) {
            if (searchAuthorId.equals(author.getId())) {
                author = authors[i];
            }
        }
        return author;
    }

    public static void searchAuthorByLastName(String searchLastName) {
        for (Author author : authors) {
            if (searchLastName.equals(author.getLastName())) {
                System.out.println(author.toString());
            } else System.out.println("The author " + searchLastName + " not found.");
        }
    }

    public static void sortAuthorsByLastName() {
        for (int i = authors.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                String[] lastNamesForSort = {authors[i].getLastName(),
                        authors[i + 1].getLastName()};
                Arrays.sort(lastNamesForSort);
            }
    }*/

}