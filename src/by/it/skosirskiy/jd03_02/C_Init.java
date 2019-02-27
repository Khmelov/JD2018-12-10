package by.it.skosirskiy.jd03_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {


    public static void main(String[] args) {
        loadTables();
    }



     static void loadTables() {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+
                             "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `skosirskiy`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `skosirskiy` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skosirskiy`.`address` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `city` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `street` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `house` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `flat` INT(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 4\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skosirskiy`.`statuses` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `status` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 4\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skosirskiy`.`roles` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 9\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skosirskiy`.`users` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `password` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `email` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `roles_id` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `skosirskiy`.`roles` (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 8\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skosirskiy`.`requests` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `type` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `date_create` TIMESTAMP NULL DEFAULT NULL,\n" +
                    "  `date_complete` TIMESTAMP NULL DEFAULT NULL,\n" +
                    "  `user_id` INT(11) NOT NULL,\n" +
                    "  `status_id` INT(11) NOT NULL,\n" +
                    "  `address_id` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_requests_users1_idx` (`user_id` ASC),\n" +
                    "  INDEX `fk_requests_statuses1_idx` (`status_id` ASC),\n" +
                    "  INDEX `fk_requests_address1_idx` (`address_id` ASC),\n" +
                    "  CONSTRAINT `fk_requests_address1`\n" +
                    "    FOREIGN KEY (`address_id`)\n" +
                    "    REFERENCES `skosirskiy`.`address` (`id`),\n" +
                    "  CONSTRAINT `fk_requests_statuses1`\n" +
                    "    FOREIGN KEY (`status_id`)\n" +
                    "    REFERENCES `skosirskiy`.`statuses` (`id`),\n" +
                    "  CONSTRAINT `fk_requests_users1`\n" +
                    "    FOREIGN KEY (`user_id`)\n" +
                    "    REFERENCES `skosirskiy`.`users` (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 8\n" +
                    "DEFAULT CHARACTER SET = utf8");
            statement.executeUpdate("INSERT INTO `skosirskiy`.`address` (`id`, `city`, `street`, `house`, `flat`) VALUES\n" +
                    "(1, 'minsk', 'lenina', '11', 5),\n" +
                    "(2, 'minsk', 'marksa', '15', 13);");

            statement.executeUpdate("INSERT INTO `skosirskiy`.`roles` (`id`, `role`) VALUES\n" +
                    "(1, 'admin'),\n" +
                    "(2, 'user'),\n" +
                    "(3, 'dispatcher'),\n" +
                    "(4, 'worker'),\n" +
                    "(5, 'brigadier'),\n" +
                    "(6, 'dispatcher'),\n" +
                    "(7, 'worker'),\n" +
                    "(8, 'brigadier');\n");
            statement.executeUpdate("INSERT INTO `skosirskiy`.`statuses` (`id`, `status`) VALUES\n" +
                    "(1, 'in_work'),\n" +
                    "(2, 'canceled'),\n" +
                    "(3, 'complete');");
            statement.executeUpdate("INSERT INTO `skosirskiy`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES\n" +
                    "(1, 'sidorov', 'sidorov', 'sidorov@mail.ru', 1),\n" +
                    "(2, 'petrov', 'petrov', 'petrov@mail.ru', 2),\n" +
                    "(3, 'ivanov1', 'ivanov1', 'ivanov1@mail.ru', 2),\n" +
                    "(4, 'semen', 'semen', 'semen@mail.ru', 2),\n" +
                    "(5, 'sergei', 'sergei', 'sergei@mail.ru', 3),\n" +
                    "(6, 'alex', 'alex', 'alex@mail.ru', 4),\n" +
                    "(7, 'iliya', 'iliya', 'iliya@mail.ru', 5);");
            statement.executeUpdate("INSERT INTO `skosirskiy`.`requests` (`id`, `type`, `date_create`, `date_complete`, `user_id`, `status_id`, `address_id`) VALUES\n" +
                    "(1, 'no water', '2019-02-01', '2019-02-07', 1, 1, 1),\n" +
                    "(2, 'no water', '2019-02-02', '2019-02-08', 2, 2, 2),\n" +
                    "(3, 'fix the door', '2019-02-08', '2019-02-28', 1, 2, 1),\n" +
                    "(4, 'no internet', '2019-04-08', '2019-02-05', 2, 1, 1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
