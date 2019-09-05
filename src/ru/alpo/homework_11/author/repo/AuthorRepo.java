package ru.alpo.homework_11.author.repo;

import ru.alpo.homework_11.author.domain.*;
import ru.alpo.homework_11.common.repo.*;

import java.util.*;

public interface AuthorRepo extends BaseRepo<Author, Long> {

    Author[] findAuthorsByBookAsArray(Long id);

    List<Author> findAuthorsByBookAsList(Long id);

}
