package ru.alpo.homework_5.book;

import ru.alpo.homework_5.author.Author;

public class Book {
    protected Long id;
    protected String name;
    protected Author[] authors;
    protected int publishYear;
    protected int totalPages;
    protected BookGenre bookGenre;

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
}




