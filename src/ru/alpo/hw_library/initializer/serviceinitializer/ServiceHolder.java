package ru.alpo.hw_library.initializer.serviceinitializer;

import ru.alpo.hw_library.author.service.*;
import ru.alpo.hw_library.book.service.*;

public class ServiceHolder {
    private final BookService bookService;
    private final AuthorService authorService;

    public ServiceHolder(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public AuthorService getAuthorService() {
        return authorService;
    }
}
