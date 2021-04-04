package ru.itis.trofimoff.lazy.services;

import ru.itis.trofimoff.lazy.models.Category;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<Category> findAllCategories();
}
