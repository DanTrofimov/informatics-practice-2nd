package ru.itis.trofimoff.form.repository.user;


import ru.itis.trofimoff.form.models.User;
import ru.itis.trofimoff.form.repository.utils.RowMapper;
import ru.itis.trofimoff.form.repository.utils.SqlJDBCTemplate;

import javax.sql.DataSource;
import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    //language=SQL
    private static final String SQL_INSERT_USER = "INSERT INTO users_test (name, age) VALUES (?,?)";

    private RowMapper<User> userRowMapper = row -> User.builder()
            .name(row.getString("name").trim())
            .age(row.getInt("age"))
            .build();

    private SqlJDBCTemplate simpleJDBSTemplate;
    private DataSource dataSource;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJDBSTemplate = new SqlJDBCTemplate(dataSource);
    }

    @Override
    public void save(User entity) {
        simpleJDBSTemplate.execute(SQL_INSERT_USER, entity.getName(), entity.getAge());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List findAll() {
        return null;
    }
}