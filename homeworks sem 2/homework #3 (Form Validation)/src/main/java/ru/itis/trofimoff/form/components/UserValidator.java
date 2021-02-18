package ru.itis.trofimoff.form.components;

import org.springframework.stereotype.Component;
import ru.itis.trofimoff.form.dto.UserForm;

@Component
public class UserValidator {
    public boolean isValid(UserForm form) {
        return form.getName().length() > 6 && form.getAge() > 0;
    }
}