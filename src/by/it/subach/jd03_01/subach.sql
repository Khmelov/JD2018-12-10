-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema subach
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `subach` ;

-- -----------------------------------------------------
-- Schema subach
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `subach` DEFAULT CHARACTER SET utf8 ;
USE `subach` ;

-- -----------------------------------------------------
-- Table `subach`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subach`.`roles` ;

CREATE TABLE IF NOT EXISTS `subach`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subach`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subach`.`users` ;

CREATE TABLE IF NOT EXISTS `subach`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `subach`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subach`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subach`.`ads` ;

CREATE TABLE IF NOT EXISTS `subach`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rooms` INT(11) NULL,
  `floors` INT(11) NULL,
  `floor` INT(11) NULL,
  `price` DOUBLE NULL,
  `area` DOUBLE NULL,
  `description` VARCHAR(200) NULL,
  `address` VARCHAR(200) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `subach`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `subach`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `subach`;
INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');
INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `subach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `subach`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `subach`;
INSERT INTO `subach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin@tut.by', 'adminpass', 1);
INSERT INTO `subach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'vasia', 'vasia@mail.ru', 'vasia', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `subach`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `subach`;
INSERT INTO `subach`.`ads` (`id`, `rooms`, `floors`, `floor`, `price`, `area`, `description`, `address`, `user_id`) VALUES (DEFAULT, 2, 2, 5, 50000.00, 60.2, 'Good apartments', 'Lenina, 1', 2);
INSERT INTO `subach`.`ads` (`id`, `rooms`, `floors`, `floor`, `price`, `area`, `description`, `address`, `user_id`) VALUES (DEFAULT, 5, 16, 8, 130000.00, 98.5, 'Big apartments', 'Knorina, 6', 2);

COMMIT;

