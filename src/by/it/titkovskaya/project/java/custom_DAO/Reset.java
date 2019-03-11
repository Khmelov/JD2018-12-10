package by.it.titkovskaya.project.java.custom_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Reset {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    static void resetDB() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `titkovskaya` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `titkovskaya` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(100) NULL," +
                    "  `password` VARCHAR(100) NULL," +
                    "  `email` VARCHAR(100) NULL," +
                    "  `name` VARCHAR(100) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles1_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `titkovskaya`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`account status` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `status` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`accounts` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `number` INT NOT NULL," +
                    "  `currency` VARCHAR(45) NOT NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  `account_status_id` INT NOT NULL," +
                    "  `unlock_request` TINYINT(1) NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_Accounts_users1_idx` (`users_id` ASC)," +
                    "  INDEX `fk_accounts_account status1_idx` (`account_status_id` ASC)," +
                    "  UNIQUE INDEX `number_UNIQUE` (`number` ASC)," +
                    "  CONSTRAINT `fk_Accounts_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `titkovskaya`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `fk_accounts_account status1`" +
                    "    FOREIGN KEY (`account_status_id`)" +
                    "    REFERENCES `titkovskaya`.`account status` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`payments` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `date` TIMESTAMP(0) NOT NULL," +
                    "  `amount` DOUBLE NOT NULL," +
                    "  `recipient` VARCHAR(200) NOT NULL," +
                    "  `accounts_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_payments_accounts1_idx` (`accounts_id` ASC)," +
                    "  CONSTRAINT `fk_payments_accounts1`" +
                    "    FOREIGN KEY (`accounts_id`)" +
                    "    REFERENCES `titkovskaya`.`accounts` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `titkovskaya`.`replenishments` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `date` TIMESTAMP(0) NOT NULL," +
                    "  `amount` DOUBLE NULL," +
                    "  `accounts_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_replenishments_accounts1_idx` (`accounts_id` ASC)," +
                    "  CONSTRAINT `fk_replenishments_accounts1`" +
                    "    FOREIGN KEY (`accounts_id`)" +
                    "    REFERENCES `titkovskaya`.`accounts` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'client');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`users` (`id`, `login`, `password`, `email`, `name`, `roles_id`) VALUES (DEFAULT, 'admin', '00000', 'admin@it.by', 'Samanta Jones', 1);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`users` (`id`, `login`, `password`, `email`, `name`, `roles_id`) VALUES (DEFAULT, 'johnSMITH', '11111', 'johnSMITH@it.by', 'John Smith', 2);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`users` (`id`, `login`, `password`, `email`, `name`, `roles_id`) VALUES (DEFAULT, 'janeDOUGH', '22222', 'janeDOUGH@it.by', 'Jane Dough', 2);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`account status` (`id`, `status`) VALUES (DEFAULT, 'active');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`account status` (`id`, `status`) VALUES (DEFAULT, 'locked');");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`accounts` (`id`, `number`, `currency`, `users_id`, `account_status_id`, `unlock_request`) VALUES (DEFAULT, 100000001, 'USD', 2, 2, false);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`accounts` (`id`, `number`, `currency`, `users_id`, `account_status_id`, `unlock_request`) VALUES (DEFAULT, 100000002, 'BYN', 2, 1, false);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`accounts` (`id`, `number`, `currency`, `users_id`, `account_status_id`, `unlock_request`) VALUES (DEFAULT, 100000003, 'EUR', 3, 1, false);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`payments` (`id`, `date`, `amount`, `recipient`, `accounts_id`) VALUES (DEFAULT, '2019-01-04 16:50', 2000, 'Schneider Electric', 1);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`payments` (`id`, `date`, `amount`, `recipient`, `accounts_id`) VALUES (DEFAULT, '2019-01-25 12:00', 10000, 'BAE Systems', 2);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`payments` (`id`, `date`, `amount`, `recipient`, `accounts_id`) VALUES (DEFAULT, '2019-02-15 13:30', 25000, 'Thales Group', 3);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`replenishments` (`id`, `date`, `amount`, `accounts_id`) VALUES (DEFAULT, '2019-01-04 15:25', 2000, 1);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`replenishments` (`id`, `date`, `amount`, `accounts_id`) VALUES (DEFAULT, '2019-01-15 09:40', 30000, 2);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`replenishments` (`id`, `date`, `amount`, `accounts_id`) VALUES (DEFAULT, '2019-02-02 11:30', 50000, 3);");
        }
    }
}
