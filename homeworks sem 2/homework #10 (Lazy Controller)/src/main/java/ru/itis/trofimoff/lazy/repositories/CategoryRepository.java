package ru.itis.trofimoff.lazy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.trofimoff.lazy.models.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findById(int id);

    List<Category> findAll();
}
