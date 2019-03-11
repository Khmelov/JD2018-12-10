package by.it.titkovskaya.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddData {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    void addData(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("INSERT INTO `titkovskaya`.`accounts` (`id`, `number`, `currency`, `users_id`, `account_status_id`, `unlock_request`) VALUES (DEFAULT, 444444444, 'USD', 4, 1, false);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`replenishments` (`id`, `date`, `amount`, `accounts_id`) VALUES (DEFAULT, '2019-02-19 14:20', 75000, 4);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`payments` (`id`, `date`, `amount`, `recipient`, `accounts_id`) VALUES (DEFAULT, '2019-02-19 15:05', 15000, 'gmbh XXX', 4);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
