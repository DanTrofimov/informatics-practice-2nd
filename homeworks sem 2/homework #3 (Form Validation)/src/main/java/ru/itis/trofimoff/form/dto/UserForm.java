package ru.itis.trofimoff.form.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserForm {
    private String name;
    private int age;
}