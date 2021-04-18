package ru.itis.trofimoff.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.trofimoff.ajax.models.User;
import ru.itis.trofimoff.ajax.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersWithPagination(int usersAmount, int offset) {
        return userRepository.findAllWithPagination(usersAmount, offset);
    }

    @Override
    public void removeUser(int id) {
        userRepository.removeById(id);
    }
}
