package ru.alpo.homework_8.author.repo;

import ru.alpo.homework_8.author.domain.*;
import ru.alpo.homework_8.book.domain.*;
import ru.alpo.homework_8.storage.*;

import java.util.*;

public class AuthorRepoArray implements AuthorRepo {

    @Override
    public int count() {
        return ArrayStorage.getTotalAuthorsQuantity();
    }

    @Override
    public void print() {
        for (Author author : ArrayStorage.getAuthors()) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        ArrayStorage.removeAuthor(author);
    }

    @Override
    public Long add(Author author) {
        ArrayStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public Author[] findAuthorsByBookAsArray(long bookId) {
        return findAuthorsByBookAsList(bookId).toArray(new Author[0]);
    }


    @Override
    public List<Author> findAuthorsByBookAsList(long bookId) {
        List<Author> found = new ArrayList<>();

        for (Author author : ArrayStorage.getAuthors()) {

            for (Book book : author.getBooks()) {
                if (Long.valueOf(bookId).equals(book.getId())) {
                    found.add(author);
                    break;
                }
            }
        }
        return found;
    }
}
