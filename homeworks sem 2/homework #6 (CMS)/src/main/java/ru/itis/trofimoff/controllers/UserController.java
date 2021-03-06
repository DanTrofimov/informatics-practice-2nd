package ru.itis.trofimoff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.trofimoff.dto.ContentDto;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserPageRoot() {
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserPage(){
        return "user";
    }

    @RequestMapping("/generated/{pageName}")
    public String getCustomPage(@PathVariable String pageName) {
        return pageName;
    }
}