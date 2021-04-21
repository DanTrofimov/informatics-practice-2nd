package ru.itis.trofimoff.task.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.task.models.Category;
import ru.itis.trofimoff.task.models.Product;
import ru.itis.trofimoff.task.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void removeProduct(Long id) {
    }

    @Override
    public void addProduct(String name, int price, int categoryId) {
        Product product;

        // need to replace by converter
        switch (categoryId) {
            case 1:
                product = new Product(name, price, new Category((long) categoryId, "fruits"));
                break;
            case 2:
                product = new Product(name, price, new Category((long) categoryId, "vegetables"));
                break;
            default:
                product = new Product(name, price, new Category((long) categoryId, "fruits"));
        }
        productRepository.save(product);
    }
}
