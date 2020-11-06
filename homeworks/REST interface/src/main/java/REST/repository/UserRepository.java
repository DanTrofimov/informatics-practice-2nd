package REST.repository;

import REST.models.User;
import REST.services.DataBaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final String SQL_CREATE_USER="INSERT INTO users(name, age, id) values (?,?,?)";
    private final String SQL_UPDATE_USER ="UPDATE users SET name =?,age=? WHERE id=?";
    private final String SQL_GET_USER_BY_ID="select users.name, users.id, users.age from users where id=?";
    private final String SQL_DELETE_USER_BY_ID="DELETE FROM users where id=?";

    private Connection conn;
    private ResultSet result;
    private PreparedStatement preparedStatement;

    public void create(User user) {
        try {
            DataBaseConnector connector = new DataBaseConnector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement(SQL_CREATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setLong(3, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problems with saving user");
        }
    }

    public void update(User user){
        try {
            DataBaseConnector connector = new DataBaseConnector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setLong(3, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problems with update user");
        }
    }

    public User get(long id) {
        try {
            DataBaseConnector connector = new DataBaseConnector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement(SQL_GET_USER_BY_ID);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeQuery();
            while(result.next()){
                long userId = result.getLong(2);
                if (userId == id) {
                    String name = result.getString(1);
                    int age = result.getInt(3);
                    preparedStatement.close();
                    conn.close();
                    return new User(age, name, userId);
                }
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problems with getting user");
        }
        return null;
    }

    public void delete(long id) {
        try {
            DataBaseConnector connector = new DataBaseConnector();
            conn = connector.getConnection();
            preparedStatement = conn.prepareStatement(SQL_DELETE_USER_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problems with deleting user");
        }
    }

    /* TODO: example of user's object:
        {
            "age": 37,
            "name": "Victor",
            "id": 4
        }
     */
}