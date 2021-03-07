package ru.itis.trofimoff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.trofimoff.dto.ContentDto;
import ru.itis.trofimoff.models.Page;
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
        Page parent = null;
        try {
            parent = this.pageService.findPageByName(contentDto.getParent());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Long parentId = parent == null ? 0 : parent.getId();
        this.pageService.createFile(contentDto.getName(), contentDto.getContent());
        this.pageService.saveFile(contentDto.getName(), contentDto.getContent(), parentId);
        return "redirect:/admin";
    }
}