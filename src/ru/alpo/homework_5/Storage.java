package ru.alpo.homework_5;

import ru.alpo.homework_5.author.Author;
import ru.alpo.homework_5.book.Book;

import java.util.Arrays;

public final class Storage {
    public static final int CAPACITY = 10;
    public static Book[] books = new Book[CAPACITY];
    private static int bookIndex = 0;
    public static Long bookId = 1L;

    public static void increaseBookIndex() {
        bookIndex++;
    }

    public static Author[] authors = new Author[CAPACITY];
    private static int authorIndex = 0;
    public static Long authorId = 1L;

    public static void increaseAuthorIndex() {
        authorIndex++;
    }

    public static Long getBookId() {
        return bookId;
    }

    public static Long getAuthorId() {
        return authorId;
    }

    public static int getBookIndex() {
        return bookIndex;
    }

    public static int getAuthorIndex() {
        return authorIndex;
    }

    public static void increaseAuthorsStorage() {
        Author[] authors = new Author[authorIndex + CAPACITY];
        System.arraycopy(Storage.authors, 0, authors, 0, Storage.authors.length);
        Storage.authors = authors;
    }

    public static void increaseBooksStorage() {
        Book[] books = new Book[bookIndex + CAPACITY];
        System.arraycopy(Storage.books, 0, books, 0, Storage.books.length);
        Storage.books = books;
    }

    public static void addAuthor(Author author) {
        author.setId(authorId);

        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        } else {
            authors[authorIndex] = author;
        }
        increaseAuthorIndex();
        authorId++;
    }

    public static void addBook(Book book) {
        book.setId(bookId);

        if (bookIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseBooksStorage();
        } else {
            books[bookIndex] = book;
        }
        Storage.increaseBookIndex();
        bookId++;
    }

    public static void printAuthorsQuantity() {
        System.out.println(getAuthorIndex());
    }

    public static void printBooksQuantity() {
        System.out.println(getBookIndex());
    }

    public static void removeBook(Book book) {
        /**
         *  [0] = A
         *  [1] = B
         *  [2] = C
         *  [3] = NULL
         */
        for (int i = 0; i < books.length; i++) {

            if (book.getId().equals(books[i].getId())) {
                books[i] = null;
                bookIndex--;
                break;
            }
        }

        /**
         *  [0] = A
         *  [1] = NULL
         *  [2] = C
         *  [3] = NULL
         */

        Book[] newBooks = new Book[books.length];
        int index = 0;
        for (Book b : books) {
            if (b != null) {
                newBooks[index] = b;
                index++;
            }
        }

        /**
         *  [0] = A
         *  [1] = C
         *  [2] = NULL
         *  [3] = NULL
         */
        books = newBooks;
    }

    public static void removeAuthor(Author author) {
        /**
         *  [0] = A
         *  [1] = B
         *  [2] = C
         *  [3] = NULL
         */
        for (int i = 0; i < authors.length; i++) {

            if (author.getId().equals(authors[i].getId())) {
                authors[i] = null;
                authorIndex--;
                break;
            }

        }
        /**
         *  [0] = A
         *  [1] = NULL
         *  [2] = C
         *  [3] = NULL
         */

        Author[] newAuthors = new Author[Storage.authors.length];
        int index = 0;
        for (Author a : authors) {
            if (a != null) {
                newAuthors[index] = a;
                index++;
            }
        }

        /**
         *  [0] = A
         *  [1] = C
         *  [2] = NULL
         *  [3] = NULL
         */
        authors = newAuthors;
    }

    public static Author searchAuthorById(Long searchAuthorId) {
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
    }


}