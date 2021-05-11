package ru.itis.trofimoff.websockets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/")
    public String rootMapping() {
        return "redirect:/game";
    }

    @GetMapping("/game")
    public String getGame(Model model) {
        return "game";
    }
}

