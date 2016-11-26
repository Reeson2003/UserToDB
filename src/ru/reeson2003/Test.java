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
            String  URL = "jdbc:mysql://192.168.1.43:3306/test", user = "root", password = "1234";
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(URL,user,password);
            statement = connection.createStatement();
//            statement.execute("CREATE TABLE `users` (`id` int(11) NOT NULL,`login` varchar(50) NOT NULL," +
//                    "`password` varchar(50) NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1");
            UserDao userDao = new UserDao(statement);
            User tonya2 = userDao.getUser(1);
            User kostya = userDao.getUser(2);
            System.out.println(tonya2);
            System.out.println(kostya);
            System.out.println(userDao.getUser(3));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }
}
