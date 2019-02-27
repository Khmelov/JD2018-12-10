-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema internet_shop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `internet_shop` ;

-- -----------------------------------------------------
-- Schema internet_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internet_shop` DEFAULT CHARACTER SET utf8 ;
USE `internet_shop` ;

-- -----------------------------------------------------
-- Table `internet_shop`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`roles` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '		',
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_shop`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`users` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '\n',
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `internet_shop`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_shop`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`categories` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NULL,
  `category_description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_shop`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`products` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NULL,
  `product_price` DOUBLE NULL,
  `product_description` VARCHAR(1000) NULL,
  `categories_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_products_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `internet_shop`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_shop`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`orders` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `internet_shop`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `internet_shop`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_shop`.`blacklist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`blacklist` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`blacklist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_blacklist_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `internet_shop`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_shop`.`checkout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `internet_shop`.`checkout` ;

CREATE TABLE IF NOT EXISTS `internet_shop`.`checkout` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `checkout_status` INT NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_checkout_orders1`
    FOREIGN KEY (`order_id`)
    REFERENCES `internet_shop`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `internet_shop`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `internet_shop`;
INSERT INTO `internet_shop`.`roles` (`id`, `role`) VALUES (DEFAULT, '');
INSERT INTO `internet_shop`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `internet_shop`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `internet_shop`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `internet_shop`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `internet_shop`;
INSERT INTO `internet_shop`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'admin', 'qwerty', 'admin@gmail.com', 1);
INSERT INTO `internet_shop`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'VasyaP', '1234', 'vasia@mail.ru', 2);
INSERT INTO `internet_shop`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'PetyaS', 'qqqq', 'petya@tut.by', 2);
INSERT INTO `internet_shop`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'SvetaV', 'aaaa1', 'sveta@gmail.com', 2);
INSERT INTO `internet_shop`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'Alfonso', 'zxcv', 'alfonso@yahoo.com', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `internet_shop`.`categories`
-- -----------------------------------------------------
START TRANSACTION;
USE `internet_shop`;
INSERT INTO `internet_shop`.`categories` (`id`, `category_name`, `category_description`) VALUES (DEFAULT, 'consoles', 'Consoles');
INSERT INTO `internet_shop`.`categories` (`id`, `category_name`, `category_description`) VALUES (DEFAULT, 'games', 'Console games');
INSERT INTO `internet_shop`.`categories` (`id`, `category_name`, `category_description`) VALUES (DEFAULT, 'accessorise', 'Accessorise for consoles');

COMMIT;


-- -----------------------------------------------------
-- Data for table `internet_shop`.`products`
-- -----------------------------------------------------
START TRANSACTION;
USE `internet_shop`;
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Play Station 5', 499.90, 'Best console fron Sony', 1);
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Xbox720', 599.90, 'Console from Microsoft', 1);
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Nintendo Woo', 350.50, 'Family console fron Nintendo', 1);
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Call of Booty 5', 50.00, 'FPS', 2);
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Heroes 3', 15.99, 'Strategy', 2);
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Baldurs gate 3 ', 19.99, 'RPG ', 2);
INSERT INTO `internet_shop`.`products` (`id`, `product_name`, `product_price`, `product_description`, `categories_id`) VALUES (DEFAULT, 'Dualshock 5', 80.00, 'Gamepad for PS5', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `internet_shop`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `internet_shop`;
INSERT INTO `internet_shop`.`orders` (`id`, `user_id`, `product_id`) VALUES (DEFAULT, 2, 3);
INSERT INTO `internet_shop`.`orders` (`id`, `user_id`, `product_id`) VALUES (DEFAULT, 2, 4);
INSERT INTO `internet_shop`.`orders` (`id`, `user_id`, `product_id`) VALUES (DEFAULT, 3, 5);

COMMIT;

