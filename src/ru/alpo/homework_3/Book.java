package ru.alpo.homework_3;

public class Book {
    private long id;
    private String name;
    private Author[] authors;
    private int publishYear;
    private int totalPages;
    private BookOrigin bookOrigin;

    enum BookOrigin {
        PRINTED("This book was printed in typography"),
        HANDWRITTEN("This book was handwritten");

        private String description;

        BookOrigin(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

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

    public BookOrigin getBookOrigin() {
        return bookOrigin;
    }

    public void setBookOrigin(BookOrigin bookOrigin) {
        this.bookOrigin = bookOrigin;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", publishYear = " + publishYear +
                ", totalPages = " + totalPages +
                ", " + bookOriginOut() +
                '}';
    }

    public String bookOriginOut() {
/*        switch (bookOrigin) {
            case PRINTED:
            case HANDWRITTEN: {
                return bookOrigin.getDescription();
            }
            default:*/
                return "Origin is unknown";
        }

    }


