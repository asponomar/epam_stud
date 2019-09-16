package ru.alpo.hw_library.initializer.serviceinitializer;

import ru.alpo.hw_library.author.repo.*;
import ru.alpo.hw_library.author.service.*;
import ru.alpo.hw_library.book.repo.*;
import ru.alpo.hw_library.book.service.*;
import ru.alpo.hw_library.storage.*;

public class ServiceInitializer {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    public ServiceHolder initServices(StorageType storageType) {
        initRepos(storageType);
        return new ServiceHolder(new BookServiceImpl(bookRepo),
                new AuthorServiceImpl(authorRepo, bookRepo));
    }

    private void initRepos(StorageType storageType) {
        switch (storageType) {
            case ARRAY:
                bookRepo = new BookRepoArray();
                authorRepo = new AuthorRepoArray();
                break;
            case COLLECTION:
                bookRepo = new BookRepoCollection();
                authorRepo = new AuthorRepoCollection();
                break;
        }
    }
}
