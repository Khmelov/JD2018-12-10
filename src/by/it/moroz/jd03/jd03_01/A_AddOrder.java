package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddOrder {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addOrder() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 1, 2, 59.2, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 2, 1, 13.4, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 3, 2, 23.2, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 4, 1, 9.3, 3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) " +
                    "VALUES (DEFAULT, 5, 1, 5.0, 3);"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
