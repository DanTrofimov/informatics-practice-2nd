package ru.itis.trofimoff.lazy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.trofimoff.lazy.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT book FROM Book book JOIN FETCH book.category")
    List<Book> findAllBooks();
}
