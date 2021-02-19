package ru.itis.trofimoff.form.services.validators;

import org.springframework.stereotype.Component;
import ru.itis.trofimoff.form.dto.UserDto;

@Component
public class UserValidator {
    public boolean isValid(UserDto form) {
        return form.getName().length() > 6 && form.getAge() > 0;
    }
}