package ru.alpo.hw_library.initializer.datainitializer;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.author.service.*;
import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.book.service.*;
import ru.alpo.hw_library.initializer.author.*;
import ru.alpo.hw_library.initializer.book.*;
import ru.alpo.hw_library.initializer.serviceinitializer.*;

public class InMemoryInitializer extends BasicDataInitalizer {
    private final AuthorService authorService;
    private final BookService bookService;

    public InMemoryInitializer(ServiceHolder serviceHolder) {
        super(serviceHolder);
        this.authorService = serviceHolder.getAuthorService();
        this.bookService = serviceHolder.getBookService();
    }

    @Override
    public void initData() {
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
}
