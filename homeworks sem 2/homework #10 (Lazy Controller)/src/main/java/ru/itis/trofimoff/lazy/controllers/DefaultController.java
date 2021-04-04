package ru.itis.trofimoff.lazy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.trofimoff.lazy.converter.CategoryConverter;
import ru.itis.trofimoff.lazy.dto.BookDto;
import ru.itis.trofimoff.lazy.models.Book;
import ru.itis.trofimoff.lazy.models.Category;
import ru.itis.trofimoff.lazy.services.BookService;
import ru.itis.trofimoff.lazy.services.CategoryService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @Autowired
    public BookService bookService;

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public CategoryConverter categoryConverter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooksPage() {
        return "redirect:/books";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooksPage(HttpServletRequest request) {
        request.getSession().setAttribute("books", bookService.getAllBooks());
        System.out.println(bookService.getAllBooks().get(0));
        return "books";
    }

    @RequestMapping(value = "/books-add", method = RequestMethod.GET)
    public String getBooksAddPage(HttpServletRequest request) {
        request.getSession().setAttribute("categories", categoryService.findAllCategories());
        return "book-add";
    }

    @RequestMapping(value = "/books-add", method = RequestMethod.POST)
    public String postBooksAddPage(@ModelAttribute Book currentBook) {

//        // spring сделает это под капотом
//        Category currentCategory = categoryConverter.convert(bookDto.getCategory());
//        Book currentBook = new Book(bookDto.getName(), currentCategory);

        bookService.saveBook(currentBook);
        return "book-add";
    }
}
