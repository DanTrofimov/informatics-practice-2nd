package ru.itis.troifmoff.orm.utils.manager;

import ru.itis.troifmoff.orm.model.User;
import ru.itis.troifmoff.orm.utils.helpers.SqlJDBCTemplate;

import java.util.List;

public class EntityManager<T> {
    public SqlJDBCTemplate<T> sqlJDBCTemplate;
}
