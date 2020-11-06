package REST.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String USERS_DB_URL = "jdbc:postgresql://localhost:5432/rest";
    static final String USER = "postgres";
    static final String PASS = "admin";
    static Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(USERS_DB_URL, USER, PASS);
        } catch (SQLException ex){
            System.out.println("Problems with a initializing of connection.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Not found driver class");
        }
        return conn;
    }
}