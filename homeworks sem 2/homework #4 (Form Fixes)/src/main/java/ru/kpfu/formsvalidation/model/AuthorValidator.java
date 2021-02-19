package ru.kpfu.formsvalidation.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class AuthorValidator implements Validator {

/*  если не проставить @Autowired, при использовании
    c @InitBinding binder.setValidator(new AuthorValidator()) можем словить NPE,
    т.к. поле validateSmthElse может быть не проинициализировано и == null

    link: https://stackoverflow.com/questions/12643944/springmvc-java-lang-nullpointerexception-is-the-configurations-correct
 */

//  @Autowired
//  public ValidateSmthElse validateSmthElse;

  @Override
  public boolean supports(Class clazz) {
    return Author.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors e) {
    // как вариант, до этого просто не передавали какие-либо сообщения в принципе
//    ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
    ValidationUtils.rejectIfEmpty(e, "name", "name.empty", "This name is empty");
    ValidationUtils.rejectIfEmpty(e, "avatarUrl", "avatarUrl.empty", "This URL is empty");
    Author a = (Author) obj;
    try {
      new URL(a.getAvatarUrl());
    } catch (MalformedURLException ex) {
//      e.reject("avatarUrl", "URL.incorrect");
      e.rejectValue("avatarUrl", "URL.incorrect", "This URL is incorrect");
    }
  }
}
