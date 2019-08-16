package ru.alpo.homework_6.author.service;

import ru.alpo.homework_6.Storage;
import ru.alpo.homework_6.author.domain.Author;

public class AuthroServiceImpl implements AuthorService {
    @Override
    public int count() {
        int counter = 0;
        for (Author author : Storage.authors) {
            if (author != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void print() {
        for (Author author : Storage.authors) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }

    }

    @Override
    public void delete(Author author) {
        Storage.removeAuthor(author);
    }

    @Override
    public Long add(Author author) {
        Storage.addAuthor(author);
        return author.getId();
    }
}
