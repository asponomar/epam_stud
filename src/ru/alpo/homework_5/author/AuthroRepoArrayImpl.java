package ru.alpo.homework_5.author;

import ru.alpo.homework_5.Storage;

public class AuthroRepoArrayImpl implements AuthorRepo {
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
