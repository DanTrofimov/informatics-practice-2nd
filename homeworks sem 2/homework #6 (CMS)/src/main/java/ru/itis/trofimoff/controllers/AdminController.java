package ru.itis.trofimoff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.trofimoff.dto.ContentDto;
import ru.itis.trofimoff.services.PageService;

@Controller
public class AdminController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getUserPage(){
        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String postUserPage(ContentDto contentDto){
        System.out.println(contentDto);
        this.pageService.createFile(contentDto.getName(), contentDto.getContent());
        return "redirect:/admin";
    }
}