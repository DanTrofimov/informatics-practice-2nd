package ru.itis.trofimoff.ajax.service;

import ru.itis.trofimoff.ajax.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getAllUsersWithPagination(int usersAmount, int offset);
    void removeUser(int id);
}
