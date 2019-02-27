package by.it.subach.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error loading driver: " + e);
//        }
//    }

    public static void initDB() {
        try(Connection connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                            "?useUnicode=true&characterEncoding=UTF-8",
                            "root",
                            "");
            Statement statement = connection.createStatement()
                ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `subach` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `subach` " +
                    "DEFAULT CHARACTER SET utf8 ;"
             );

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(50) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `subach`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `subach`.`ads` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `rooms` INT(11) NULL," +
                    "  `floors` INT(11) NULL," +
                    "  `floor` INT(11) NULL," +
                    "  `price` DOUBLE NULL," +
                    "  `area` DOUBLE NULL," +
                    "  `description` VARCHAR(200) NULL," +
                    "  `address` VARCHAR(200) NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_ads_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `subach`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin@tut.by', 'adminpass', 1);");
            statement.executeUpdate("INSERT INTO `subach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'vasia', 'vasia@mail.ru', 'vasia', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`ads` (`id`, `rooms`, `floors`, `floor`, `price`, `area`, `description`, `address`, `users_id`) VALUES (DEFAULT, 2, 2, 5, 50000.00, 60.2, 'Good apartments', 'Lenina, 1', 2);");
            statement.executeUpdate("INSERT INTO `subach`.`ads` (`id`, `rooms`, `floors`, `floor`, `price`, `area`, `description`, `address`, `users_id`) VALUES (DEFAULT, 5, 16, 8, 130000.00, 98.5, 'Big apartments', 'Knorina, 6', 2);");

            System.out.println("DataBase RESTORED");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
