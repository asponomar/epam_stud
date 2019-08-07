package ru.alpo.homework_3;

public class Book {
    private String name;
    private Author author;
    private String iSBN;

    public Book(String name, Author author, String iSBN) {
        this.name = name;
        this.author = author;
        this.iSBN = iSBN;
    }

    public String getName() {
        return name;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    @Override
    public String toString() {
        return author + " - "
                + name
                + ", ISBN: " + iSBN;
    }
}
