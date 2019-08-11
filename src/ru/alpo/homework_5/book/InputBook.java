package ru.alpo.homework_5.book;

public class InputBook {
    private long id;
    private String name;
    private int publishYear;
    private int totalPages;

    private String writingInkType;
    private String fontType;
    private BookGenre bookGenre;

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getWritingInkType() {
        return writingInkType;
    }

    public void setWritingInkType(String writingInkType) {
        this.writingInkType = writingInkType;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
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
}
