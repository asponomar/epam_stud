package ru.alpo.hw_library.author.repo;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.common.repo.*;

import java.util.*;

public interface AuthorRepo extends BaseRepo<Author, Long> {

    Author[] findAuthorsByBookAsArray(Long id);

    List<Author> findAuthorsByBookAsList(Long id);

}
