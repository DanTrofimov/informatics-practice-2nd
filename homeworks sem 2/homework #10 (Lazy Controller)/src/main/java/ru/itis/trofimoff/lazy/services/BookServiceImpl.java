package ru.itis.trofimoff.lazy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.lazy.models.Book;
import ru.itis.trofimoff.lazy.repositories.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
