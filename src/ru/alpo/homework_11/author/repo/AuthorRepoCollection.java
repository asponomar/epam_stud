package ru.alpo.homework_11.author.repo;

import ru.alpo.homework_11.author.domain.*;
import ru.alpo.homework_11.book.domain.*;
import ru.alpo.homework_11.storage.*;

import java.util.*;

public class AuthorRepoCollection implements AuthorRepo {

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
        Iterator<Author> authors = CollectionStorage.authors.iterator();
        Author author = new Author();
        while (authors.hasNext()) {
            boolean idsMatches = authors.next().getId().equals(AuthorId);
            author = idsMatches ? author : null;
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

        for (Author a : CollectionStorage.getAllAuthors()) {

            List<Book> books = a.getBooks();
            for (Book b : books) {
                if (b != null && bookId == b.getId()) {
                    found.add(a);
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
