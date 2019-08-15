package ru.alpo.homework_5.book;

import ru.alpo.homework_5.Storage;

public class BookRepoArrayRepo implements BookRepo {
    @Override
    public int count() {
        int counter = 0;
        for (Book book : Storage.books) {
            if (book != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void print() {
        for (Book book : Storage.books) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        Storage.removeBook(book);

    }

    @Override
    public Long add(Book book) {
        Storage.addBook(book);
        return book.getId();
    }
}
