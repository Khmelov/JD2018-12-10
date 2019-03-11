package by.it.titkovskaya.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {

    void addRoles(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`roles` (" +
                    "`id` INT NOT NULL AUTO_INCREMENT," +
                    "`role` VARCHAR(100) NULL," +
                    "PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'client');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("UPDATE `titkovskaya`.`users` SET `roles_id` = '3' WHERE `users`.`id` = 4;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
