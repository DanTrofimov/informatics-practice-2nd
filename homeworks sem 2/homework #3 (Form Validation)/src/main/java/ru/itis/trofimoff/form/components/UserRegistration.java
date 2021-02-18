package ru.itis.trofimoff.form.components;

import ru.itis.trofimoff.form.DataBaseConnector;
import ru.itis.trofimoff.form.dto.UserForm;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistration {

    private Connection conn;
    private ResultSet result;
    private PreparedStatement preparedStatement;
    //language=SQL
    private String sqlInsertFormat = "INSERT INTO users_test(name, age) VALUES(?, ?)";

    public void saveUser(UserForm userForm) {
        String name = userForm.getName();
        int age = userForm.getAge();
        try {
            DataBaseConnector connector = new DataBaseConnector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement(sqlInsertFormat);
            System.out.println(conn);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        }  catch(SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println("Problems with a saving user. Can't close statement.");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Problems with a saving user. Can't close connection.");
                }
            }
        }
    }
}
