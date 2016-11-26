package ru.reeson2003;

import ru.reeson2003.DAO.UserDao;
import ru.reeson2003.model.User;

import java.sql.*;


/**
 * Created by Toshiba on 22.11.2016.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String  URL = "jdbc:mysql://localhost:3306/test", user = "root", password = "1234";
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(URL,user,password);
            statement = connection.createStatement();
//            statement.execute("CREATE TABLE `users` (`id` int(11) NOT NULL,`login` varchar(50) NOT NULL," +
//                    "`password` varchar(50) NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1");
            UserDao userDao = new UserDao(statement);
//            User kostya = new User(2, "Kostya", "456");
//            userDao.applyUser(kostya);
//            User tonya = new User(1,"Tonya", "123");
//            System.out.println(tonya);
//            resultSet = statement.executeQuery("show databases");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//            }
//            userDao.applyUser(tonya);
            User tonya2 = userDao.getUser(1);
            User kostya = userDao.getUser(2);
            System.out.println(tonya2);
            System.out.println(kostya);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
