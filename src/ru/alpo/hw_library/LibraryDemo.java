package ru.alpo.hw_library;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.author.repo.*;
import ru.alpo.hw_library.author.service.*;
import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.book.repo.*;
import ru.alpo.hw_library.book.service.*;
import ru.alpo.hw_library.initializer.author.*;
import ru.alpo.hw_library.initializer.book.*;
import ru.alpo.hw_library.initializer.datainitializer.*;
import ru.alpo.hw_library.initializer.serviceinitializer.*;
import ru.alpo.hw_library.storage.*;

import static ru.alpo.hw_library.initializer.datainitializer.DataInitializerType.IN_MEMORY;
import static ru.alpo.hw_library.storage.StorageType.ARRAY;
import static ru.alpo.hw_library.storage.StorageType.COLLECTION;


public class LibraryDemo {
    public static void main(String[] args) {

        StorageType storageType = COLLECTION;
        DataInitializerType dataInitializerType = IN_MEMORY;

        ServiceHolder serviceHolder = new ServiceInitializer().initServices(storageType);

        BasicDataInitalizer dataInitalizer = DataInitializerFactory.getDataInitializer(dataInitializerType, serviceHolder);

        BookService bookService = serviceHolder.getBookService();
        AuthorService authorService = serviceHolder.getAuthorService();

        dataInitalizer.initData();

        authorService.print();
        bookService.print();
        System.out.println(authorService.count());
        System.out.println(bookService.count());

    }
}


