package ru.alpo.hw_library.initializer.datainitializer;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.initializer.author.*;
import ru.alpo.hw_library.initializer.book.*;
import ru.alpo.hw_library.initializer.serviceinitializer.*;

public abstract class BasicDataInitalizer {

    protected final ServiceHolder serviceHolder;

    public BasicDataInitalizer(ServiceHolder serviceHolder) {
        this.serviceHolder = serviceHolder;
    }

    public abstract void initData();

    protected static Book valueOfForPrintedBook(InputBook inputBook) {
        PrintedBook book = new PrintedBook();
        book.setId(inputBook.getId());
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setTotalPages(inputBook.getTotalPages());
        book.setBookGenre(inputBook.getBookGenre());
        book.setFontType(inputBook.getFontType());
        return book;
    }

    protected static Book valueOfForHandWrittenBook(InputBook inputBook) {
        HandWrittenBook book = new HandWrittenBook();
        book.setId(inputBook.getId());
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setTotalPages(inputBook.getTotalPages());
        book.setBookGenre(inputBook.getBookGenre());
        book.setWritingInkType(inputBook.getWritingInkType());
        return book;
    }

    protected static Author valueOfAuthor(InputAuthor inputAuthor) {
        Author author = new Author();
        author.setId(inputAuthor.getId());
        author.setName(inputAuthor.getName());
        author.setLastName(inputAuthor.getLastName());
        author.setBirthYear(inputAuthor.getBirthYear());
        author.setDeathYear(inputAuthor.getDeathYear());
        return author;
    }
}

