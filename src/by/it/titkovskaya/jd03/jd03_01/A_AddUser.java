package by.it.titkovskaya.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddUser {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    void addUser(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("INSERT INTO `titkovskaya`.`users` (`id`, `login`, `password`, `email`, `name`, `roles_id`) VALUES (DEFAULT, 'jamesBOND', '33333', 'jamesBOND@it.by', 'James Bond', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
