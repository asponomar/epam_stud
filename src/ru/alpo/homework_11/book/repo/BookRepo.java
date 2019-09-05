package ru.alpo.homework_11.book.repo;

import ru.alpo.homework_11.book.domain.*;
import ru.alpo.homework_11.common.repo.*;

import java.util.*;

public interface BookRepo extends BaseRepo<Book, Long> {

    Book[] findBooksByAuthorAsArray(Long id);

    List<Book> findBooksByAuthorAsList(Long id);
}
