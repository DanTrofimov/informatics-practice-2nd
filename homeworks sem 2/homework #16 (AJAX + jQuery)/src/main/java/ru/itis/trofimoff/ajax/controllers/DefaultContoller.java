package ru.itis.trofimoff.ajax.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultContoller {

    @GetMapping("/table")
    public String getTable(Model model) {
        return "table";
    }
}
