package ru.alpo.homework_11.book.repo;

import ru.alpo.homework_11.book.domain.*;
import ru.alpo.homework_11.common.repo.*;

import java.util.*;

public interface BookRepo extends BaseRepo<Book> {

    Book[] findBooksByAuthorAsArray(long id);

    List<Book> findBooksByAuthorAsList(long id);
}
