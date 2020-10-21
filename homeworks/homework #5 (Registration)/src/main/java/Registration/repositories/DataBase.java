package Registration.repositories;

import java.sql.*;

public class DataBase {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String USERS_DB_URL = "jdbc:postgresql://localhost:5432/Users";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "postgres";
    static Connection conn = null;

    public static void addUser(String name, String email, String password) throws ClassNotFoundException, SQLException {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(USERS_DB_URL, USER, PASS);

            // Execute SQL query
            Statement stmt = conn.createStatement();
            /*
             TODO: links of examples
             TODO: https://metanit.com/java/database/2.4.php
             TODO: https://postgrespro.ru/docs/postgrespro/9.5/dml-insert
             TODO: https://www.tutorialspoint.com/servlets/servlets-database-access.htm
             TODO: https://vertex-academy.com/tutorials/ru/kak-podklyuchitsya-k-baze-dannyx-postgresql-s-pom/
             */
            // working way to make user's record
            String sqlFormat = "INSERT INTO users VALUES('%s', '%s', '%s')";
            stmt.executeUpdate(String.format(sqlFormat, name, email, password));

            // Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
