package ru.reeson2003.DAO;

import ru.reeson2003.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Toshiba on 22.11.2016.
 */
public class UserDao {
    private Statement statement;
    public UserDao(Statement statement) {
        this.statement = statement;
    }
    public void applyUser(User user) throws SQLException {
        int id = user.getId();
        String login = user.getLogin();
        String password = user.getPassword();
        statement.execute("INSERT INTO" +
                "`users` (`id`,`login`, `password`)" +
                "VALUES" +
                "    (" + id + ", '" + login + "', '" + password + "')");
    }
    public User getUser(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * from `users` WHERE (id = " + id + ")");
        resultSet.next();
        String login = resultSet.getString(2);
        String password = resultSet.getString(3);
        User result = new User();
        result.setId(id);
        result.setLogin(login);
        result.setPassword(password);
        return result;
    }
}
