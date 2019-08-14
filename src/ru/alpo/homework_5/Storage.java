package ru.alpo.homework_5;

import ru.alpo.homework_5.author.Author;
import ru.alpo.homework_5.book.Book;

public final class Storage {
    public static final int CAPACITY = 10;
    public static Book[] books = new Book[CAPACITY];
    private static int bookIndex = 0;

    public static void increaseBookIndex() {
        bookIndex++;
    }

    public static Author[] authors = new Author[CAPACITY];
    private static int authorIndex = 0;

    public static void increaseAuthorIndex() {
        authorIndex++;
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
        author.setId(authorIndex + 1);

        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        } else {
            authors[authorIndex] = author;
        }
        increaseAuthorIndex();
    }

    public static void addBook(Book book) {
        book.setId(bookIndex + 1);

        if (bookIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseBooksStorage();
        } else {
            books[bookIndex] = book;
        }
        Storage.increaseBookIndex();
    }

    public static void printAuthorsQuantity() {
        System.out.println(getAuthorIndex());
    }

    public static void printBooksQuantity() {
        System.out.println(getBookIndex());
    }

    public class Searcher {
        Author author = new Author();
        Book book = new Book();

        private Author searcher(String lastName, String name) {
            author.setName(name);
            author.setLastName(lastName);
            for (int i = 0; i < authors.length; i++) {
                if (author.getName().equals(authors[i].getName()) && author.getLastName().equals(authors[i].getLastName())) {
                    author = authors[i];
                }
            }
            return author;
        }

        private boolean foundAuthor() {
            return author != null;
        }

        public void searchAuthor(String lastName, String name) {
            Author authorFound = searcher(author.getLastName(), author.getName());
            if (foundAuthor()) {
                System.out.println(authorFound.toString());
            } else {
                System.out.println("Author " + author.getLastName() + " " + author.getName() + " not found");
            }
        }

        private Book searcher(String name) {
            book.setName(name);

            for (int i = 0; i < books.length; i++) {
                if (book.getName().equals(books[i].getName())) {
                    book = books[i];
                }
            }
            return book;
        }

        private boolean foundBook() {
            return book != null;
        }

        public void searchBook(String name) {
            Book bookFound = searcher(book.getName());
            if (foundBook()) {
                System.out.println(bookFound.toString());
            } else {
                System.out.println("Book " + book.getName() + " not found");
            }
        }
    }

    public void deleteAuthor(String lastName, String name) {
        Searcher searcher = new Searcher();
        searcher.searchAuthor(lastName, name);
    }

    public static void deleteBook(String name) {
//        Book book = searchBook(name);
    }

}