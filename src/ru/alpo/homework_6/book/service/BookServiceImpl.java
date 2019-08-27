package ru.alpo.homework_6.book.service;

import ru.alpo.homework_6.Storage;
import ru.alpo.homework_6.author.domain.*;
import ru.alpo.homework_6.author.repo.*;
import ru.alpo.homework_6.book.domain.Book;
import ru.alpo.homework_6.book.repo.*;

public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    public BookServiceImpl(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public int count() {
        return bookRepo.count();
    }

    @Override
    public void print() {
        bookRepo.print();
    }

    @Override
    public void delete(Book book) {
        Author[] authorWithoutBooks = authorRepo.findAuthorsByBook(book.getId());

        if (authorWithoutBooks != null) {
            for (Author author : authorWithoutBooks) {
                author.deleteBook(book);

                if (author.withoutBooks()) {
                    authorRepo.delete(author);
                }
            }
        }
    }

    @Override
    public Long add(Book book) {
        Storage.addBook(book);
        return book.getId();
    }
}
