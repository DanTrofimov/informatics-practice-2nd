package ru.itis.trofimoff.form.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itis.trofimoff.form.components.UserRegistration;
import ru.itis.trofimoff.form.components.UserValidator;
import ru.itis.trofimoff.form.dto.UserForm;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    public UserValidator validator;

    @Autowired
    public UserRegistration registrator;

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
        UserForm userForm = new UserForm(name.substring(1), Integer.parseInt(age.substring(1)));
        if (validator.isValid(userForm)) {
            map.put("success", "logged");
            registrator.saveUser(userForm);
        } else {
            map.put("error", "invalid input");
        }
        map.put("user", userForm);
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


/*
    TODO:
        1) разобраться с примером с формами
        2) NPE где-то
        3) пример с формой для автора, не всегда выдает ошибку, при частичной верности данных, с именен дропается исключение, с аватаркой - ничего
 */