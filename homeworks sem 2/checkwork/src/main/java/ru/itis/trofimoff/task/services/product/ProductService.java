package ru.itis.trofimoff.task.services.product;

import ru.itis.trofimoff.task.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void removeProduct(Long id);
    void addProduct(String name, int price, int categoryId);
}
