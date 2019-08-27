package ru.alpo.homework_5;

import ru.alpo.homework_5.author.Author;
import ru.alpo.homework_5.author.AuthorRepo;
import ru.alpo.homework_5.author.AuthroRepoArrayImpl;
import ru.alpo.homework_5.author.InputAuthor;
import ru.alpo.homework_5.book.*;


public class LibraryDemo {
    public static void main(String[] args) {
        BookRepo bookRepo = new BookRepoArrayRepo();
        AuthorRepo authorRepo = new AuthroRepoArrayImpl();

        initData(bookRepo, authorRepo);
        authorRepo.print();
        bookRepo.print();
        System.out.println(authorRepo.count());
        System.out.println(bookRepo.count());
//        authorRepo.delete();

    }

    private static void initData(BookRepo bookRepo, AuthorRepo authorRepo) {
        for (int i = 0; i < 1; i++) {
            InputAuthor inputAuthor = new InputAuthor();
            inputAuthor.setName("Alexander");
            inputAuthor.setLastName("One more Pushkin");
            inputAuthor.setBirthYear(1799);
            inputAuthor.setDeathYear(1837);
            Author author = valueOfAuthor(inputAuthor);
            authorRepo.add(author);
        }
/*        System.out.println(ArrayStorage.authorIndex);
        System.out.println(ArrayStorage.authors.length);*/


        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setPublishYear(2005);
        inputBook1.setBookGenre(BookGenre.NOVEL);
        Book book1 = valueOfForHandWrittenBook(inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Ruslan and Ludmila");
        inputBook2.setPublishYear(2006);
        inputBook2.setBookGenre(BookGenre.POEMS);
        Book book2 = valueOfForPrintedBook(inputBook2);

        InputAuthor inputAuthor1 = new InputAuthor();
        inputAuthor1.setLastName("Pushkin");
        inputAuthor1.setName("Alexander");
        inputAuthor1.setBirthYear(1799);
        Author author = valueOfAuthor(inputAuthor1);
        author.setBooks(new Book[]{book1, book2});

        book1.setAuthors(new Author[]{author});
        book2.setAuthors(new Author[]{author});

        bookRepo.add(book1);
        bookRepo.add(book2);
        authorRepo.add(author);
    }

    private static Book valueOfForPrintedBook(InputBook inputBook) {
        PrintedBook book = new PrintedBook();
        book.setId(inputBook.getId());
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setTotalPages(inputBook.getTotalPages());
        book.setBookGenre(inputBook.getBookGenre());
        book.setFontType(inputBook.getFontType());
        return book;
    }

    private static Book valueOfForHandWrittenBook(InputBook inputBook) {
        HandWrittenBook book = new HandWrittenBook();
        book.setId(inputBook.getId());
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setTotalPages(inputBook.getTotalPages());
        book.setBookGenre(inputBook.getBookGenre());
        book.setWritingInkType(inputBook.getWritingInkType());
        return book;
    }

    private static Author valueOfAuthor(InputAuthor inputAuthor) {
        Author author = new Author();
        author.setId(inputAuthor.getId());
        author.setName(inputAuthor.getName());
        author.setLastName(inputAuthor.getLastName());
        author.setBirthYear(inputAuthor.getBirthYear());
        author.setDeathYear(inputAuthor.getDeathYear());
        return author;
    }
}
