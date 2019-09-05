package ru.alpo.homework_11.book.service;

import ru.alpo.homework_11.book.domain.*;
import ru.alpo.homework_11.common.service.*;

import java.util.*;

public interface BookService extends BaseService<Book, Long> {

    Book[] findBooksByAuthorAsArray(Long authorId);

    List<Book> findBooksByAuthorAsList(Long authorId);
}
