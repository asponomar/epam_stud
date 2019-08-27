package ru.alpo.homework_7.author.service;

import ru.alpo.homework_7.*;
import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.author.repo.*;
import ru.alpo.homework_7.book.domain.*;
import ru.alpo.homework_7.book.repo.*;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo) {
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
        Book[] booksWithAuthor = bookRepo.findBooksByAuthorAsArray(author.getId());

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
        Storage.addAuthorToArray(author);
        return author.getId();
    }
}
