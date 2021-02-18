package ru.itis.trofimoff.form.repository.utils;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataBaseConnector {

    private static final String DBname = "manager"; // put here name of your DB
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String USERS_DB_URL = "jdbc:postgresql://localhost:5432/" + DBname;
    private static final String USER = "postgres";
    private static final String PASS = "admin";
    private static Connection conn;

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(USERS_DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Problems with a initializing of connection.");
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

