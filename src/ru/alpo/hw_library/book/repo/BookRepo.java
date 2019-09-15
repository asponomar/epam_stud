package ru.alpo.hw_library.book.repo;

import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.common.repo.*;

import java.util.*;

public interface BookRepo extends BaseRepo<Book, Long> {

    Book[] findBooksByAuthorAsArray(Long id);

    List<Book> findBooksByAuthorAsList(Long id);
}
