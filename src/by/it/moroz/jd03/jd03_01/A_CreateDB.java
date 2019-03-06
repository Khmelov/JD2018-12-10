package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_CreateDB {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void createDB() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","CREATE SCHEMA IF NOT EXISTS `moroz` DEFAULT CHARACTER SET utf8 ;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(100) NULL," +
                    "  `password` VARCHAR(100) NULL," +
                    "  `email` VARCHAR(100) NULL," +
                    "  `address` VARCHAR(100) NULL," +
                    "  `name` VARCHAR(100) NULL," +
                    "  `surname` VARCHAR(100) NULL," +
                    "  `numberphone` INT(12) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `moroz`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`menu` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(100) NULL," +
                    "  `price` DOUBLE NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`orders` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `menu_id` INT NOT NULL," +
                    "  `count` INT NULL," +
                    "  `check` DOUBLE NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC)," +
                    "  INDEX `fk_orders_Menu1_idx` (`menu_id` ASC)," +
                    "  CONSTRAINT `fk_orders_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `moroz`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `fk_orders_Menu1`" +
                    "    FOREIGN KEY (`menu_id`)" +
                    "    REFERENCES `moroz`.`menu` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
