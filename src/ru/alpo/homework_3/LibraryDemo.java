package ru.alpo.homework_3;

public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();
        initData(library);
        library.printAuthors();
        library.printBooks();
    }

    private static void initData(Library library) {
        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setPublishYear(2005);
        Book book1 = valueOf(inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Ruslan and Ludmila");
        inputBook2.setPublishYear(2006);
        Book book2 = valueOf(inputBook2);

        InputAuthor inputAuthor1 = new InputAuthor();
        inputAuthor1.setLastName("Pushkin");
        inputAuthor1.setBirthYear(1799);
        Author author = valueOf(inputAuthor1);
        author.setBooks(new Book[]{book1, book2});

        book1.setAuthors(new Author[]{author});
        book2.setAuthors(new Author[]{author});

        library.addBook(book1);
        library.addBook(book2);

        library.addAuthor(author);
    }

    private static Book valueOf(InputBook inputBook) {
        Book book = new Book();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        return book;
    }

    private static Author valueOf(InputAuthor inputAuthor) {
        Author author = new Author();
        author.setLastName(inputAuthor.getLastName());
        author.setBirthYear(inputAuthor.getBirthYear());
        return author;
    }
}
