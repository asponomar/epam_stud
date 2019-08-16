package ru.alpo.homework_6.author.repo;

import ru.alpo.homework_6.Storage;
import ru.alpo.homework_6.author.domain.Author;

public class AuthorRepoArray implements AuthorRepo {
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
