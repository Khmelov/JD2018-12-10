package by.it.dziomin.jd03_01.SQL_queries;

public interface CreateTables {
    String DROP_TABLES = "DROP SCHEMA IF EXISTS `dziomin` ;";
    String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS `dziomin` DEFAULT CHARACTER SET utf8 ;";
    String CREATE_USERS = "CREATE TABLE IF NOT EXISTS `dziomin`.`user` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(100) NULL,\n" +
            "  `passport` VARCHAR(100) NULL,\n" +
            "  `phone` VARCHAR(100) NULL,\n" +
            "  `role_id` INT NOT NULL DEFAULT 2,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_user_role_idx` (`role_id` ASC),\n" +
            "  CONSTRAINT `fk_user_role`\n" +
            "    FOREIGN KEY (`role_id`)\n" +
            "    REFERENCES `dziomin`.`role` (`id`)\n" +
            "    ON DELETE RESTRICT\n" +
            "    ON UPDATE RESTRICT)";
    String CREATE_ROLES = "CREATE TABLE IF NOT EXISTS `dziomin`.`role` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(100) NULL,\n" +
            "  PRIMARY KEY (`id`))";
    String CREATE_RENTS = "CREATE TABLE IF NOT EXISTS `dziomin`.`rent` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `date` INT NULL,\n" +
            "  `price` DECIMAL(10,2) NULL,\n" +
            "  `isopen` TINYINT(1) NOT NULL,\n" +
            "  `user_id` INT NOT NULL,\n" +
            "  `car_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_rent_user_idx` (`user_id` ASC),\n" +
            "  INDEX `fk_rent_car_idx` (`car_id` ASC),\n" +
            "  CONSTRAINT `fk_rent_user`\n" +
            "    FOREIGN KEY (`user_id`)\n" +
            "    REFERENCES `dziomin`.`user` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_rent_car`\n" +
            "    FOREIGN KEY (`car_id`)\n" +
            "    REFERENCES `dziomin`.`car` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)";
    String CREATE_CARS = "CREATE TABLE IF NOT EXISTS `dziomin`.`car` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NULL,\n" +
            "  `number` VARCHAR(45) NULL,\n" +
            "  `engine` VARCHAR(45) NULL,\n" +
            "  `transmission` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`))";


}
