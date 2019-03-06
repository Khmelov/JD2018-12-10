-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema moroz
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `moroz` ;

-- -----------------------------------------------------
-- Schema moroz
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moroz` DEFAULT CHARACTER SET utf8 ;
USE `moroz` ;

-- -----------------------------------------------------
-- Table `moroz`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moroz`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `adress` VARCHAR(100) NULL,
  `name` VARCHAR(100) NULL,
  `surname` VARCHAR(100) NULL,
  `numberphone` INT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `moroz`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moroz`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `count` INT NULL,
  `price` DOUBLE NULL,
  `chek` DOUBLE NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_users1_idx` (`user_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `moroz`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `moroz`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `moroz`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, `surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', 'Andrei', 'Trizno', 375298564237, 2);
INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, `surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', NULL, NULL, 'Maria', 'Borokha', NULL, 1);
INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, `surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, 'Kedishko, 3-1', 'Vladislau', 'Makarevich', 375447568394, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `moroz`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `user_id`) VALUES (DEFAULT, 'Pizza', 2, 28.35, 56.7, 1);
INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `user_id`) VALUES (DEFAULT, 'Spaghetti pepperoni', 1, 18.26, 18.26, 1);
INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `user_id`) VALUES (DEFAULT, 'Coffee', 2, 5.00, 5.00, 1);
INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `user_id`) VALUES (DEFAULT, 'Steak', 1, 35.85, 35.85, 3);
INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `user_id`) VALUES (DEFAULT, 'Salad', 1, 13.25, 13.25, 3);

COMMIT;

