package ru.alpo.hw_library.book.domain;

import ru.alpo.hw_library.author.domain.*;
import ru.alpo.hw_library.common.domain.*;
import ru.alpo.hw_library.storage.*;

import java.util.*;

public class Book extends BaseDomain<Long> {

    private String name;
    private List<Author> authors = new ArrayList<>();
    private int publishYear;
    private int totalPages;
    private BookGenre bookGenre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
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
        return authorsCount == 0;
    }

    public void deleteAuthor(Author author) {
        for (Author a : authors) {
            if (a != null) {
                CollectionStorage.removeAuthor(a);
            }
        }
    }
}




