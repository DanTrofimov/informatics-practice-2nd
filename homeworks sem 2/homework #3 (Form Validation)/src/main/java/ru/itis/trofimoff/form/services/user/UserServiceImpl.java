package ru.itis.trofimoff.form.services.user;

import ru.itis.trofimoff.form.models.User;
import ru.itis.trofimoff.form.repository.user.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository usersRepository;

    public UserServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void saveUser(User user) {
        this.usersRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEMail(String name) {
        return Optional.empty();
    }

    @Override
    public void updateUser(User user, HttpServletRequest request) {

    }

    @Override
    public void deleteUser(User user, HttpServletRequest request) {

    }
}
