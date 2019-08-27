package ru.alpo.homework_8.author.repo;

import ru.alpo.homework_8.author.domain.*;
import ru.alpo.homework_8.book.domain.*;
import ru.alpo.homework_8.storage.*;

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
    public Author[] findAuthorsByBookAsArray(long bookId) {
        return findAuthorsByBookAsList(bookId).toArray(new Author[0]);
    }

    @Override
    public List<Author> findAuthorsByBookAsList(long bookId) {
        List<Author> found = new ArrayList<>();

        for (Author a : CollectionStorage.getAllAuthors()) {

            Book books[] = a.getBooks();
            for (Book b : books) {
                if (b != null && bookId == b.getId()) {
                    found.add(a);
                    break;
                }
            }
        }
        return found;
    }

}
