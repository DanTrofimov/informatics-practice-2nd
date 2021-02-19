package ru.kpfu.formsvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.formsvalidation.model.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/jsr303")
public class Jsr303Controller {

  @RequestMapping(value = "/new_book", method = RequestMethod.GET)
  public String newBook(ModelMap map) {
    map.put("book", new Book());
    return "book_form";
  }

  @RequestMapping(value = "/new_book", method = RequestMethod.POST)
  public String jsr303Handler(
    RedirectAttributes redirectAttributes,
    @Valid @ModelAttribute("book") Book book,
    BindingResult result
  ) {
    if (result.hasErrors()) {
      return "book_form";
    }
    else {
      redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">Book \""+book.getName()+"\" has been added successfully</span>");
      return "redirect:"+MvcUriComponentsBuilder.fromMappingName("JC#newBook").build();
    }
  }
}

/*
   TODO:
    1) разобраться с примером с формами
    2) NPE где-то
    3) пример с формой для автора, не всегда выдает ошибку, при частичной верности данных, с именен дропается исключение, с аватаркой - ничего
 */
