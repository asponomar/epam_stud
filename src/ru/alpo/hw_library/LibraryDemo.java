package ru.alpo.hw_library;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.author.repo.*;
import ru.alpo.hw_library.author.service.*;
import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.book.repo.*;
import ru.alpo.hw_library.book.service.*;
import ru.alpo.hw_library.initializer.author.*;
import ru.alpo.hw_library.initializer.book.*;
import ru.alpo.hw_library.initializer.serviceinitializer.*;
import ru.alpo.hw_library.storage.*;

import static ru.alpo.hw_library.storage.StorageType.ARRAY;
import static ru.alpo.hw_library.storage.StorageType.COLLECTION;


public class LibraryDemo {
    public static void main(String[] args) {

        StorageType storageType = COLLECTION;
        ServiceInitializer serviceInitializer = new ServiceInitializer();
        serviceInitializer.initServices(storageType);

        ServiceHolder serviceHolder = new ServiceInitializer().initServices(storageType);

        BookService bookService = serviceHolder.getBookService();
        AuthorService authorService = serviceHolder.getAuthorService();

        initData(bookService, authorService);

        authorService.print();
        bookService.print();
        System.out.println(authorService.count());
        System.out.println(bookService.count());

    }

    private static void initData(BookService bookService, AuthorService authorService) {
        for (int i = 0; i < 21; i++) {
            InputAuthor inputAuthor = new InputAuthor();
            inputAuthor.setName("Alexander");
            inputAuthor.setLastName("One more Pushkin");
            inputAuthor.setBirthYear(1799);
            inputAuthor.setDeathYear(1837);
            Author author = valueOfAuthor(inputAuthor);
            authorService.add(author);
        }
/*        System.out.println(ArrayStorage.authorIndex);
        System.out.println(ArrayStorage.authors.length);*/


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

        bookService.add(book1);
        bookService.add(book2);
        authorService.add(author);
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
