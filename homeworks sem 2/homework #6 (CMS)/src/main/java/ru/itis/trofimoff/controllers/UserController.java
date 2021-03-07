package ru.itis.trofimoff.controllers;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.trofimoff.dto.ContentDto;
import ru.itis.trofimoff.services.PageService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserPageRoot() {
        return "redirect:/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserPage(HttpServletRequest request){
        request.getSession().setAttribute("pages", pageService.getAllPages());
        request.getSession().setAttribute("currentPageContent", null);
        return "user";
    }

    @RequestMapping("/user/{pageName}")
    public String getCustomPage(@PathVariable String pageName, HttpServletRequest request) {
        request.getSession().setAttribute("pages", pageService.getAllPages());
        try {
            request.getSession().setAttribute("currentPageContent", pageService.findPageByName(pageName).getContent());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "user";
    }
}