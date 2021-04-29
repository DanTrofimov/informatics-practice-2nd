package ru.itis.troifmoff.orm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    String name;
    int age;

    // refactor
    String tableName;
}
