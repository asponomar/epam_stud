package ru.alpo.homework_7.author.repo;

import ru.alpo.homework_7.*;
import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.book.domain.*;

import java.util.*;

public class AuthorRepoArray implements AuthorRepo {

    private static final int AUTHOR_REPOARRAY_CAPACITY = 10;
    private static Author[] authors = new Author[AUTHOR_REPOARRAY_CAPACITY];
    private static int authorIndex = 0;

    @Override
    public int count() {
        return Storage.getTotalAuthorsFromArray();
    }

    @Override
    public void print() {
        for (Author author : Storage.authorsArray) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        Storage.removeAuthorFromArray(author);
    }

    @Override
    public Long add(Author author) {
        Storage.addAuthorToArray(author);
        return author.getId();
    }

    @Override
    public Author[] findAuthorsByBookAsArray(long id) {
        int index = 0;

        for (Author author : Storage.authorsArray) {
            for (Book b : author.getBooks()) {
                if (b.getId().equals(id)) {
                    if (authorIndex % AUTHOR_REPOARRAY_CAPACITY == 0 && authorIndex != 0) {
                        increaseAuthorRepoArray();
                    }
                    authors[index] = author;
                    index++;
                }
                break;
            }
        }
        return authors;
    }

    public static void increaseAuthorRepoArray() {
        Author[] authors = new Author[authorIndex + AUTHOR_REPOARRAY_CAPACITY];
        System.arraycopy(authors, 0, authors, 0, authors.length);
        AuthorRepoArray.authors = authors;
    }

    @Override
    public List<Author> findAuthorsByBookAsList(long id) {
        return null;
    }
}
