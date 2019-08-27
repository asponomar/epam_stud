package ru.alpo.homework_6.author.service;

import ru.alpo.homework_6.Storage;
import ru.alpo.homework_6.author.domain.Author;
import ru.alpo.homework_6.author.repo.AuthorRepo;
import ru.alpo.homework_6.book.domain.Book;
import ru.alpo.homework_6.book.repo.BookRepo;

public class AuthroServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public AuthroServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo) {
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
        Storage.addAuthor(author);
        return author.getId();
    }
}
