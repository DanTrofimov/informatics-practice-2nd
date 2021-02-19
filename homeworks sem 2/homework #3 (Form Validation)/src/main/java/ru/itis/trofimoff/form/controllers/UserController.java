package ru.itis.trofimoff.form.controllers;

import org.postgresql.jdbc.PreferQueryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.trofimoff.form.services.user.UserServiceImpl;
import ru.itis.trofimoff.form.services.validators.UserValidator;
import ru.itis.trofimoff.form.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    public UserValidator validator;

    @Autowired
    public UserServiceImpl registrator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToForm(){
        return "form";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getUserProfilePage(){
        return "profile";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getFormPage(){
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String formPostRequest(HttpServletRequest request, UserDto userDto){
        if (validator.isValid(userDto)) {
            registrator.saveUser(userDto);
            request.getSession().setAttribute("error", null);
            request.getSession().setAttribute("success", "logged");
            request.getSession().setAttribute("user", userDto);
            return "profile";
        } else {
            request.getSession().setAttribute("success", null);
            request.getSession().setAttribute("error", "invalid input");
            return "redirect:/form";
        }
    }

//    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    public ModelAndView formPostRequest(HttpServletRequest request, UserDto userDto){
//        ModelAndView modelAndView = new ModelAndView();
//        if (validator.isValid(userDto)) {
//            registrator.saveUser(userDto);
//            request.getSession().setAttribute("error", null);
//            request.getSession().setAttribute("success", "logged");
//            request.getSession().setAttribute("user", userDto);
//            // будет доступна только для отображения profile
//            modelAndView.addObject("example", "some data for user's profile");
//            modelAndView.setViewName("profile");
//            return modelAndView;
//        } else {
//            request.getSession().setAttribute("success", null);
//            request.getSession().setAttribute("error", "invalid input");
//            modelAndView.setViewName("redirect:/form");
//            return modelAndView;
//        }
//    }
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