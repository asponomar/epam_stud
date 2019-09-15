package ru.alpo.hw_library.author.service;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.common.service.*;

import java.util.*;

public interface AuthorService extends BaseService<Author, Long> {

    Author[] findAuthorByBookAsArray(Long bookId);

    List<Author> findAuthorByBookAsAsList(Long bookId);

}
