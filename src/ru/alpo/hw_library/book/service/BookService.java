package ru.alpo.hw_library.book.service;

import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.common.service.*;

import java.util.*;

public interface BookService extends BaseService<Book, Long> {

    Book[] findBooksByAuthorAsArray(Long authorId);

    List<Book> findBooksByAuthorAsList(Long authorId);
}
