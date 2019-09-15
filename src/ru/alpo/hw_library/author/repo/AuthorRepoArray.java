package ru.alpo.hw_library.author.repo;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.book.domain.*;
import ru.alpo.hw_library.storage.*;

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
    public Author getById(Long AuthorId) {
        List<Author> authors = CollectionStorage.authors;
        Author author = new Author();
        for (Author a : authors) {
            author = a.getId() == AuthorId ? author : null;
        }
        return author;
    }

    @Override
    public Author[] findAsArray(Long bookId) {
        return findAsList(bookId).toArray(new Author[0]);
    }

    @Override
    public List<Author> findAsList(Long bookId) {
        List<Author> found = new ArrayList<>();

        for (Author author : ArrayStorage.getAuthors()) {

            for (Book book : author.getBooks()) {
                if (bookId.equals(book.getId())) {
                    found.add(author);
                    break;
                }
            }
        }
        return found;
    }

    @Override
    public Author[] findAuthorsByBookAsArray(Long id) {
        return new Author[0];
    }

    @Override
    public List<Author> findAuthorsByBookAsList(Long id) {
        return null;
    }
}
