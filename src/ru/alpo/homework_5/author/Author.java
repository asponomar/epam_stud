package ru.alpo.homework_5.author;

import ru.alpo.homework_5.book.Book;

public class Author {
    private Long id;
    private String name;
    private String lastName;
    private int birthYear;
    private Integer deathYear;
    private Book[] books;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id =" + id +
                ", name = '" + lastName + " "+ name +'\'' +
                ", birthYear = " + birthYear +
                ", deathYear = " + deathYear +
                '}';
    }

    public boolean isLiving() {
        return deathYear == null;
    }

    public String lifeTime() {
        if (isLiving()) {
            return birthYear + " - now";
        } else return birthYear + " - " + deathYear;
    }
}
