-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema skosirskiy
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `skosirskiy` ;

-- -----------------------------------------------------
-- Schema skosirskiy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skosirskiy` DEFAULT CHARACTER SET utf8 ;
USE `skosirskiy` ;

-- -----------------------------------------------------
-- Table `skosirskiy`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`roles` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`users` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id_role` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id_role` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id_role`)
    REFERENCES `skosirskiy`.`roles` (`id_role`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`adress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`adress` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`adress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `house` VARCHAR(45) NULL,
  `flat` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`status` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`requests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`requests` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`requests` (
  `id_request` INT NOT NULL AUTO_INCREMENT,
  `data_create` DATE NULL,
  `data_complete` DATE NULL,
  `type_request` VARCHAR(100) NULL,
  `adress_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id_request`),
  INDEX `fk_requests_adress1_idx` (`adress_id` ASC),
  INDEX `fk_requests_status1_idx` (`status_id` ASC),
  INDEX `fk_requests_users1_idx` (`user_id` ASC),
  CONSTRAINT `fk_requests_adress1`
    FOREIGN KEY (`adress_id`)
    REFERENCES `skosirskiy`.`adress` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_requests_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `skosirskiy`.`status` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_requests_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `skosirskiy`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `skosirskiy`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`roles` (`id_role`, `role`) VALUES (1, 'user');
INSERT INTO `skosirskiy`.`roles` (`id_role`, `role`) VALUES (2, 'dispatcher');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`users` (`id`, `login`, `password`, `email`, `roles_id_role`) VALUES (1, 'petrov', 'petrov', 'petrov@mail.ru', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`adress`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`adress` (`id`, `city`, `house`, `flat`) VALUES (1, 'minsk', '5', '62');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`status`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`status` (`id`, `status`) VALUES (1, 'in_work');
INSERT INTO `skosirskiy`.`status` (`id`, `status`) VALUES (2, 'canceled');
INSERT INTO `skosirskiy`.`status` (`id`, `status`) VALUES (3, 'complete');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`requests`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`requests` (`id_request`, `data_create`, `data_complete`, `type_request`, `adress_id`, `status_id`, `user_id`) VALUES (1, '2018.02.02', '2018.02.07', 'no water', 1, 1, 1);

COMMIT;

