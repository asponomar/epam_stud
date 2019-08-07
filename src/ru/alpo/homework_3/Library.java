package ru.alpo.homework_3;

public class Library {

    public static Author addAuthor(String name, String lastName) {
        return new Author(name, lastName);
    }

    public static Book addBook(String name, Author author, String iSBN) {
        return new Book(name, author, iSBN);
    }

    public static void printAuthors(Author author) {
        System.out.println("Author: " + author.toString() + ", " + author.lifeTime());
    }

    public static void printBooks(Book book) {
        System.out.println("Book: " + book.getName());
    }

    public static void printBooksInfo(Book book) {
        System.out.println(book.toString());
    }

    public static void main(String[] args) {
        Author author_1 = addAuthor("Alexander", "Pushkin");
        author_1.setBirthYear(1799);
        author_1.setDeathYear(1837);
        Book book_1 = addBook("Eugeniy Onegin", author_1, "0123456789");
        book_1.setiSBN("123456789");

        Book book_2 = addBook("Ruslan i Lyudmila",author_1, "0123456788");

        Author author_2 = addAuthor("Victor", "Pelevin");
        Book book_3 = addBook("Generation P", author_2, "321654987");
        author_2.setBirthYear(1962);
        book_3.setiSBN("321654987");

        printAuthors(author_1);
        printBooksInfo(book_1);
        printBooksInfo(book_2);
        printAuthors(author_2);
        printBooksInfo(book_3);
        printBooks(book_3);
    }
}
