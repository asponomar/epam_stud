package ru.alpo.homework_7.book.service;

import ru.alpo.homework_7.*;
import ru.alpo.homework_7.author.domain.*;
import ru.alpo.homework_7.author.repo.*;
import ru.alpo.homework_7.book.domain.*;
import ru.alpo.homework_7.book.repo.*;

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
        Author[] authorWithoutBooks = authorRepo.findAuthorsByBookAsArray(book.getId());

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
        Storage.addBookToArray(book);
        return book.getId();
    }
}
