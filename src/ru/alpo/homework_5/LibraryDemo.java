package ru.alpo.homework_5;

import ru.alpo.homework_5.author.Author;
import ru.alpo.homework_5.author.InputAuthor;
import ru.alpo.homework_5.book.*;
import static ru.alpo.homework_5.Library.*;

public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();
        initData(library);
        printAuthors();
        printBooks();
        Storage.Searcher searcher = new Storage().new Searcher();
//        searcher.searchAuthor("Pushkin","Alexander");
//        searcher.searchBook("Zolotaya rybka");
        Storage.printAuthorsQuantity();
        Storage.printBooksQuantity();

    }

    private static void initData(Library library) {
        for (int i = 0; i < 1; i++) {
            InputAuthor inputAuthor = new InputAuthor();
            inputAuthor.setName("Alexander");
            inputAuthor.setLastName("One more Pushkin");
            inputAuthor.setBirthYear(1799);
            inputAuthor.setDeathYear(1837);
            Author author = valueOfAuthor(inputAuthor);
            addAuthor(author);
        }
/*        System.out.println(Storage.authorIndex);
        System.out.println(Storage.authors.length);*/


        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setPublishYear(2005);
        inputBook1.setBookGenre(BookGenre.NOVEL);
        Book book1 = valueOfForHandWrittenBook(inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Ruslan and Ludmila");
        inputBook2.setPublishYear(2006);
        inputBook2.setBookGenre(BookGenre.POEMS);
        Book book2 = valueOfForPrintedBook(inputBook2);

        InputAuthor inputAuthor1 = new InputAuthor();
        inputAuthor1.setLastName("Pushkin");
        inputAuthor1.setName("Alexander");
        inputAuthor1.setBirthYear(1799);
        Author author = valueOfAuthor(inputAuthor1);
        author.setBooks(new Book[]{book1, book2});

        book1.setAuthors(new Author[]{author});
        book2.setAuthors(new Author[]{author});

        addBook(book1);
        addBook(book2);
        addAuthor(author);
    }

    private static Book valueOfForPrintedBook(InputBook inputBook) {
        PrintedBook book = new PrintedBook();
        book.setId(inputBook.getId());
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setTotalPages(inputBook.getTotalPages());
        book.setBookGenre(inputBook.getBookGenre());
        book.setFontType(inputBook.getFontType());
        return book;
    }

    private static Book valueOfForHandWrittenBook(InputBook inputBook) {
        HandWrittenBook book = new HandWrittenBook();
        book.setId(inputBook.getId());
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setTotalPages(inputBook.getTotalPages());
        book.setBookGenre(inputBook.getBookGenre());
        book.setWritingInkType(inputBook.getWritingInkType());
        return book;
    }

    private static Author valueOfAuthor(InputAuthor inputAuthor) {
        Author author = new Author();
        author.setId(inputAuthor.getId());
        author.setName(inputAuthor.getName());
        author.setLastName(inputAuthor.getLastName());
        author.setBirthYear(inputAuthor.getBirthYear());
        author.setDeathYear(inputAuthor.getDeathYear());
        return author;
    }
}
