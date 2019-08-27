package ru.alpo.homework_8.book.domain;

import ru.alpo.homework_8.author.domain.*;
import ru.alpo.homework_8.storage.*;

public class Book {
    private Long id;
    private String name;
    private Author[] authors;
    private int publishYear;
    private int totalPages;
    private BookGenre bookGenre;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", publishYear = " + publishYear +
                ", totalPages = " + totalPages +
                ", " + bookGenreDescription() +
                '}';
    }

    public String bookGenreDescription() {
        switch (bookGenre) {
            case NOVEL:
            case POEMS:
            case SCIENCE: {
                return bookGenre.getDescription();
            }
            default:
                return "Genre is unknown";
        }
    }

    public boolean withoutAuthors() {
        int authorsCount = 0;
        for (Author a : authors) {
            if (a != null) authorsCount++;
        }
        if (authorsCount == 0) return true;
        else return false;
    }

    public void deleteAuthor(Author author) {
        for (Author a : authors) {
            if (a != null) {
                ArrayStorage.removeAuthor(a);
            }
        }
    }
}




