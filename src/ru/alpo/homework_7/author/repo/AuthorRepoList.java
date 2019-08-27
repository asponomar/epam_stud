package ru.alpo.homework_7.author.repo;

import ru.alpo.homework_7.*;
import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.book.domain.*;

import java.util.*;

public class AuthorRepoList implements AuthorRepo {

    @Override
    public int count() {
        return Storage.getTotalAuthorsFromList();
    }

    @Override
    public void print() {
        for (Author a : Storage.authorsList) {
            System.out.println(a);
        }
    }

    @Override
    public void delete(Author author) {
        Storage.removeAuthorFromList(author);
    }

    @Override
    public Long add(Author author) {
        Storage.addAuthorToList(author);
        return author.getId();
    }

    @Override
    public Author[] findAuthorsByBookAsArray(long id) {
        return new Author[0];
    }

    @Override
    public List<Author> findAuthorsByBookAsList(long id) {
        List<Author> found = new ArrayList<>();

        for (Author a : Storage.authorsList) {
            Book[] books = a.getBooks();
            for (Book b : books) {
                if (a != null && id == b.getId()) {
                    found.add(a);
                    break;
                }
            }
        }
        return found;
    }

}
