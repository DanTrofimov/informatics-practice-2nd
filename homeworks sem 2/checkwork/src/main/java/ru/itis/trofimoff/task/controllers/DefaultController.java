package ru.itis.trofimoff.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.trofimoff.task.dto.ProductDto;
import ru.itis.trofimoff.task.services.category.CategoryService;
import ru.itis.trofimoff.task.services.product.ProductService;

@Controller
public class DefaultController {

    @Autowired
    public ProductService productService;

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/")
    public String redirectProducts() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add";
    }

    @PostMapping("/add")
    public String postAdd(ProductDto productDto) {
        productService.addProduct(productDto.getName(), productDto.getPrice(), productDto.getCategoryId());
        return "redirect:/products";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }
}
