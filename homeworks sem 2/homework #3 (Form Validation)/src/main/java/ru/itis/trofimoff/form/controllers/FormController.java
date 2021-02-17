package ru.itis.trofimoff.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/form")
public class FormController {
    @GetMapping
    public String formGetRequest(ModelMap map){
        return "form";
    }

    @PostMapping
    public String formPostRequest(@PathVariable Map params, ModelMap map){
        map.put("formData", params );
        return "form";
    }
}

/*
  TODO:
    1) статическая форма
    2) валидация в котроллере, берет из запроса параметры
    3) запись в БД или куда-то еще
    -- 3 бина, validator, dao, repo --
 */
