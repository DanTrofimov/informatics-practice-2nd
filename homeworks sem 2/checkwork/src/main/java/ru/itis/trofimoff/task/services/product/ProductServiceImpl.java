package ru.itis.trofimoff.task.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.task.models.Category;
import ru.itis.trofimoff.task.models.Product;
import ru.itis.trofimoff.task.repositories.CategoryRepository;
import ru.itis.trofimoff.task.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void removeProduct(Long id) {
    }

    @Override
    public void addProduct(String name, int price, int categoryId) {
        Category category = categoryRepository.getCategoryById((long)categoryId);
        Product product = new Product(name, price, category);
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.getCategoryById(categoryId);
        return productRepository.findAllByCategory(category);
    }
}
