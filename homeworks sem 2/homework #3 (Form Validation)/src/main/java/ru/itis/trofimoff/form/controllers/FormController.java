package ru.itis.trofimoff.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @RequestMapping(
            value = "/form",
            method = RequestMethod.GET
    )
    public String formGetRequest(ModelMap map){
        return "form";
    }

    @RequestMapping(
            value = "/form",
            method = RequestMethod.POST
    )
    public String formPostRequest(@RequestParam("name") String name,
                                  @RequestParam("age") String age,
                                  ModelMap map){

        map.put("userName", name );
        map.put("userAge", age);
        System.out.println(name);
        System.out.println(age);
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
