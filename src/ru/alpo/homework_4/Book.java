package ru.alpo.homework_4;

import static ru.alpo.homework_4.BookGenre.NOVEL;

public class Book {
    private long id;
    private String name;
    private Author[] authors;
    private int publishYear;
    private int totalPages;
    private BookGenre bookGenre;

    public long getId() {
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




