package by.it.naron.jd03_04.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    public static void main(String[] args) throws SQLException {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/" +
                                     "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `naron` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `naron` " +
                                        "DEFAULT CHARACTER SET utf8 ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`users` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(50) NULL,\n" +
                    "  `password` VARCHAR(50) NULL,\n" +
                    "  `e-mail` VARCHAR(50) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `naron`.`roles` (`id`)\n" +
                    "    ON DELETE restrict \n" +
                    "    ON UPDATE restrict )\n" +
                    "ENGINE = InnoDB;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`goods_flower` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`goods_flower` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(60) NULL,\n" +
                    "  `colour` VARCHAR(45) NULL,\n" +
                    "  `size` INT NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`orders` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `amount` INT NULL,\n" +
                    "  `time_delivery` INT NULL,\n" +
                    "  `date_orders` TIMESTAMP NULL,\n" +
                    "  `total_price` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `goods_flower_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_orders_goods_flower1_idx` (`goods_flower_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `naron`.`users` (`id`)\n" +
                    "    ON DELETE cascade \n" +
                    "    ON UPDATE cascade,\n" +
                    "  CONSTRAINT `fk_orders_goods_flower1`\n" +
                    "    FOREIGN KEY (`goods_flower_id`)\n" +
                    "    REFERENCES `naron`.`goods_flower` (`id`)\n" +
                    "    ON DELETE restrict \n" +
                    "    ON UPDATE restrict )\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'vasia', 'pvasia', 'vasia@it.by', 1);");
            statement.executeUpdate("INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'petia', 'ppetia', 'petia@it.by', 2);");
            statement.executeUpdate("INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'kolia', 'pkolia', 'kolia@it.by', 3);");

            statement.executeUpdate("INSERT INTO `naron`.`goods_flower` (`id`, `name`, `colour`, `size`, `price`) VALUES (DEFAULT, 'rose', 'red', 70, 6.5);");
            statement.executeUpdate("INSERT INTO `naron`.`goods_flower` (`id`, `name`, `colour`, `size`, `price`) VALUES (DEFAULT, 'orchid', 'white', 50, 22.5);");
            statement.executeUpdate("INSERT INTO `naron`.`goods_flower` (`id`, `name`, `colour`, `size`, `price`) VALUES (DEFAULT, 'begonia', 'pink', 30, 38.3);");

            statement.executeUpdate("INSERT INTO `naron`.`orders` (`id`, `amount`, `time_delivery`, `date_orders`, total_price, `users_id`, `goods_flower_id`) VALUES (DEFAULT, 3, 2,'2019-01-04 16:50', 20.5, 1, 1);");
            statement.executeUpdate("INSERT INTO `naron`.`orders` (`id`, `amount`, `time_delivery`, `date_orders`, total_price, `users_id`, `goods_flower_id`) VALUES (DEFAULT, 5, 6,'2019-01-04 16:50', 20.5, 2, 2);");


        }
    }
}
