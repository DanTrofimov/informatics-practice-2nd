package ru.itis.trofimoff.ajax.controllers;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.trofimoff.ajax.models.User;
import ru.itis.trofimoff.ajax.service.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsersWithPagination(@RequestParam Integer usersAmount, @RequestParam Integer offset) {
//        return ResponseEntity.ok(userService.getAllUsersWithPagination(usersAmount, offset));
//    }

    @DeleteMapping("/users")
    public ResponseEntity<?> removeUser(@RequestParam Integer userId) {
        userService.removeUser(userId);
        return ResponseEntity.ok().build();
    }
}
