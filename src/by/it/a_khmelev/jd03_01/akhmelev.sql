-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `akhmelev` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;
USE `akhmelev` ;

-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `akhmelev`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(3000) NULL,
  `address` VARCHAR(555) NULL,
  `floor` INT NULL,
  `floors` INT NULL,
  `rooms` INT NULL,
  `area` DOUBLE NULL,
  `price` DOUBLE NULL,
  `user_id` INT NOT NULL,
  `data` TIMESTAMP(6) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `akhmelev`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `akhmelev`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'administrator', 'administrator@mail.ru', 'administrator', 1);
INSERT INTO `akhmelev`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2);
INSERT INTO `akhmelev`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'petrov', 'petrov@mail.ru', 'petrov', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`, `price`, `user_id`, `data`) VALUES (DEFAULT, 'Good appartments', 'Minsk Lenina str., 10 app.12', 3, 5, 2, 55, 77777, 3, '2019-02-20 11:45:00');
INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`, `price`, `user_id`, `data`) VALUES (DEFAULT, 'Small house', 'Minsk Halturina, 14', 1, 1, 2, 44, 55555, 3, '2019-02-20 11:46:00');

COMMIT;

