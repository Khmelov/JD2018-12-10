package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void initDB() {
        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8", "root", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("%s","DROP SCHEMA IF EXISTS `moroz` ;"));
            statement.executeUpdate(String.format("%s","CREATE SCHEMA IF NOT EXISTS `moroz` DEFAULT CHARACTER SET utf8 ;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `address` VARCHAR(100) NULL,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `surname` VARCHAR(100) NULL,\n" +
                    "  `numberphone` INT(12) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `moroz`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`menu` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;"));
            statement.executeUpdate(String.format("%s","CREATE TABLE IF NOT EXISTS `moroz`.`orders` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `menu_id` INT NOT NULL,\n" +
                            "  `count` INT NULL,\n" +
                            "  `chek` DOUBLE NULL,\n" +
                            "  `users_id` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`id`),\n" +
                            "  INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                            "  INDEX `fk_orders_Menu1_idx` (`menu_id` ASC),\n" +
                            "  CONSTRAINT `fk_orders_users1`\n" +
                            "    FOREIGN KEY (`users_id`)\n" +
                            "    REFERENCES `moroz`.`users` (`id`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE,\n" +
                            "  CONSTRAINT `fk_orders_Menu1`\n" +
                            "    FOREIGN KEY (`menu_id`)\n" +
                            "    REFERENCES `moroz`.`menu` (`id`)\n" +
                            "    ON DELETE NO ACTION\n" +
                            "    ON UPDATE NO ACTION)\n" +
                            "ENGINE = InnoDB;\n"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, " +
                    "`name`, `surname`, `numberphone`, `roles_id`) " +
                    "VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', " +
                    "'Andrei', 'Trizno', 298563456, 2);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', " +
                    "NULL, NULL, 'Maria', 'Borokha', NULL, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, 'Kedishko, 3-1', " +
                    "'Vladislau', 'Makarevich', 447568394, 3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'steak', 29.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'pizza', 13.4);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'spaghetti', 11.6);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'salad', 9.3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'coffe', 5.0);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 1, 2, 59.2, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 2, 1, 13.4, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 3, 2, 23.2, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 4, 1, 9.3, 3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 5, 1, 5.0, 3);"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
