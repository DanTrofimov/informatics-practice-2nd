package ru.itis.trofimoff.form.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    @Email(message = "Incorrect email")
    private String email;
    private int age;
}