package ru.alpo.homework_7;

import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.book.domain.*;

import java.util.*;

public final class Storage {
    private static final int CAPACITY = 10;

    public static Book[] booksArray = new Book[CAPACITY];
    public static List<Book> booksList = new ArrayList<>();
    private static int bookIndex = 0;
    private static Long bookId = 1L;

    public static Author[] authorsArray = new Author[CAPACITY];
    public static List<Author> authorsList = new ArrayList<>();
    private static int authorIndex = 0;
    private static Long authorId = 1L;


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

    public static void increaseBookIndex() {
        bookIndex++;
    }

    public static void increaseAuthorIndex() {
        authorIndex++;
    }

    public static int getTotalBooksFromArray() {
        return bookIndex;
    }

    public static int getTotalBooksFromList() {
        return booksList.size();
    }

    public static int getTotalAuthorsFromArray() {
        return authorIndex;
    }

    public static int getTotalAuthorsFromList() {
        return authorsList.size();
    }


    public static void increaseBooksArrayStorage() {
        Book[] books = new Book[bookIndex + CAPACITY];
        System.arraycopy(Storage.booksArray, 0, books, 0, Storage.booksArray.length);
        Storage.booksArray = books;
    }

    public static void increaseAuthorsArrayStorage() {
        Author[] authors = new Author[authorIndex + CAPACITY];
        System.arraycopy(Storage.authorsArray, 0, authors, 0, Storage.authorsArray.length);
        Storage.authorsArray = authors;
    }

    public static void addBookToArray(Book book) {
        book.setId(bookId);

        if (bookIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseBooksArrayStorage();
        }
        booksArray[bookIndex] = book;
        Storage.increaseBookIndex();
        bookId++;
    }

    public static void addBookToList(Book book) {
        book.setId(bookId);
        booksList.add(book);
        bookId++;
    }

    public static void addAuthorToArray(Author author) {
        author.setId(authorId);

        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsArrayStorage();
        }
        authorsArray[authorIndex] = author;
        increaseAuthorIndex();
        authorId++;
    }

    public static void addAuthorToList(Author author) {
        author.setId(authorId);
        authorsList.add(author);
        authorId++;
    }

    public static void removeBookFromArray(Book book) {
        /**
         *  [0] = A
         *  [1] = B
         *  [2] = C
         *  [3] = NULL
         */
        for (int i = 0; i < booksArray.length; i++) {

            if (book.getId().equals(booksArray[i].getId())) {
                booksArray[i] = null;
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

        Book[] newBooks = new Book[booksArray.length];
        int index = 0;
        for (Book b : booksArray) {
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
        booksArray = newBooks;
    }

    public static void removeBookFromList(Book book) {
        for (Book b : booksList) {
            if (b.getId().equals(book.getId())) {
                booksList.remove(b);
                break;
            }
        }
    }

    public static void removeAuthorFromArray(Author author) {
        /**
         *  [0] = A
         *  [1] = B
         *  [2] = C
         *  [3] = NULL
         */
        for (int i = 0; i < authorsArray.length; i++) {

            if (author.getId().equals(authorsArray[i].getId())) {
                authorsArray[i] = null;
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

        Author[] newAuthors = new Author[Storage.authorsArray.length];
        int index = 0;
        for (Author a : authorsArray) {
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
        authorsArray = newAuthors;
    }

    public static void removeAuthorFromList(Author author) {
        for (Author a : authorsList) {
            if (a.getId().equals(author.getId())) {
                authorsList.remove(a);
            }
        }
    }

    public static Author searchAuthorById(Long searchAuthorId) {
        Author author = new Author();
        for (int i = 0; i < authorsArray.length; i++) {
            if (searchAuthorId.equals(author.getId())) {
                author = authorsArray[i];
            }
        }
        return author;
    }

    public static void searchAuthorByLastName(String searchLastName) {
        for (Author author : authorsArray) {
            if (searchLastName.equals(author.getLastName())) {
                System.out.println(author.toString());
            } else System.out.println("The author " + searchLastName + " not found.");
        }
    }

    public static void sortAuthorsByLastName() {
        for (int i = authorsArray.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                String[] lastNamesForSort = {authorsArray[i].getLastName(),
                        authorsArray[i + 1].getLastName()};
                Arrays.sort(lastNamesForSort);
            }
    }

}