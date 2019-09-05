package ru.alpo.homework_11.author.repo;

import ru.alpo.homework_11.author.domain.*;
import ru.alpo.homework_11.common.repo.*;

import java.util.*;

public interface AuthorRepo extends BaseRepo<Author> {

    Author[] findAuthorsByBookAsArray(long id);

    List<Author> findAuthorsByBookAsList(long id);

}
