package ru.alpo.homework_11.author.service;

import ru.alpo.homework_11.author.domain.*;
import ru.alpo.homework_11.common.service.*;

import java.util.*;

public interface AuthorService extends BaseService<Author> {

    Author[] findAuthorByBookAsArray(long bookId);

    List<Author> findAuthorByBookAsAsList(long bookId);

}
