package ru.itis.trofimoff.form.services.user;

import ru.itis.trofimoff.form.dto.UserDto;
import ru.itis.trofimoff.form.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService {
//    Long saveUser(User user);
    void saveUser(UserDto user);
    Optional<User> findUserByEMail(String name);
    void updateUser (User user, HttpServletRequest request);
    void deleteUser (User user, HttpServletRequest request);
}
