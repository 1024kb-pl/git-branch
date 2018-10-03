package pl.maniaq;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    private Connection connection;
    private final String databaseName = "users";

    public UserDao() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jbdc.Driver").newInstance();
            connection = DriverManager.getConnection("jbdc:mysql://localhost/users", "root", "admin");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        Statement statement = null;
        List<User> users = new LinkedList<>();
        try {
            statement = connection.createStatement();
            String query = "select * from " + databaseName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                Integer age = resultSet.getInt("age");

                User user = new User(name, lastname, age);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }
}
