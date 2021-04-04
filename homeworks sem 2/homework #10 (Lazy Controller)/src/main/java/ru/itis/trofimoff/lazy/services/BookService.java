package ru.itis.trofimoff.lazy.services;

import ru.itis.trofimoff.lazy.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
}
