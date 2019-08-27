package ru.alpo.homework_6.author.repo;

import ru.alpo.homework_6.Storage;
import ru.alpo.homework_6.author.domain.Author;
import ru.alpo.homework_6.book.domain.*;

public class AuthorRepoArray implements AuthorRepo {

    private static final int AUTHOR_REPOARRAY_CAPACITY = 10;
    private static Author[] authors = new Author[AUTHOR_REPOARRAY_CAPACITY];
    private static int authorIndex = 0;


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

    @Override
    public Author[] findAuthorsByBook(long id) {
        int index = 0;

        for (Author author : Storage.authors) {
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
}
