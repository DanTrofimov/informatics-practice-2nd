package ru.itis.trofimoff.lazy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.lazy.models.Category;
import ru.itis.trofimoff.lazy.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}
