package ru.itis.trofimoff.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    @RequestMapping(value = "/rest-test", method = RequestMethod.POST)
    public String getUserPage(Model model) {
        System.out.println(model);
        return "user";
    }
}
