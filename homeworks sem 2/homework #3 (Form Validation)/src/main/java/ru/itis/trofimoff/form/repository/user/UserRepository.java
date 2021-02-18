package ru.itis.trofimoff.form.repository.user;

import ru.itis.trofimoff.form.dto.UserDto;
import ru.itis.trofimoff.form.models.User;
import ru.itis.trofimoff.form.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User> {
    // some logic for user
}
