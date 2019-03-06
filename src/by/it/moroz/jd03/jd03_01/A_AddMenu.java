package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddMenu {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addMenu() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'steak', 29.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'pizza', 13.4);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'spaghetti', 11.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'salad', 9.3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'coffe', 5.0);"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
