package ru.alpo.homework_10.author.service;

import ru.alpo.homework_10.author.domain.*;
import ru.alpo.homework_10.author.repo.*;
import ru.alpo.homework_10.book.domain.*;
import ru.alpo.homework_10.book.repo.*;
import ru.alpo.homework_10.repo.*;
import ru.alpo.homework_10.service.*;
import ru.alpo.homework_10.storage.*;

import java.util.*;

public class AuthorService implements Service<Author> {

    private Repo<Author> authorRepo;
    private Repo<Book> bookRepo;

    public AuthorService(Repo<Author> authorRepo, Repo<Book> bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public int count() {
        return authorRepo.count();
    }

    @Override
    public void print() {
        authorRepo.print();
    }

    @Override
    public void delete(Author author) {
        Book[] booksWithAuthor = bookRepo.findAsArray(author.getId());

        if (booksWithAuthor != null) {
            for (Book book : booksWithAuthor) {
                book.deleteAuthor(author);

                if (book.withoutAuthors()) {
                    bookRepo.delete(book);
                }
            }
        }
    }

    @Override
    public Long add(Author author) {
        ArrayStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public Author getById(long id) {
        return authorRepo.getById(id);
    }

    @Override
    public Author[] findAsArray(long bookId) {
        return authorRepo.findAsArray(bookId);
    }

    @Override
    public List findAsList(long bookId) {
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
}
