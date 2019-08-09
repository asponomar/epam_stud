package ru.alpo.homework_3;

public class Storage {
    public static final int CAPACITY = 10;
    public static Book[] books = new Book[CAPACITY];
    public static int bookIndex = 0;

    public static void increaseBookIndex() {
        bookIndex++;
    }

    public static Author[] authors = new Author[CAPACITY];
    public static int authorIndex = 0;

    public static void increaseAuthorIndex() {
        authorIndex++;
    }

    public static void increaseAuthorsStorage() {

        Author[] authors = new Author[authorIndex + CAPACITY];
        //System.arraycopy();
        for (int i = 0; i < Storage.authors.length; i++) {
            authors[i] = Storage.authors[i];
            System.out.println();
        }
        Storage.authors = authors;
    }

    public static void addAuthor(Author author) {
        author.setId(authorIndex + 1);

        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        } else {
            authors[authorIndex] = author;
        }
        Storage.increaseAuthorIndex();
    }

    public static void increaseBooksStorage() {
        Book[] books = new Book[bookIndex + CAPACITY];
        //System.arraycopy();
        for (int i = 0; i < Storage.books.length; i++) {
            books[i] = Storage.books[i];
            System.out.println();
        }
        Storage.books = books;
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
}
