drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NULL DEFAULT NULL,
	`price` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`order_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
	`fk_customer_id` INT(11) NOT NULL,
	PRIMARY KEY (`order_id`),
	FOREIGN KEY (`fk_customer_id`) REFERENCES `customers`(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items`(
	`order_items_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
	`total_price` DOUBLE NULL DEFAULT NULL, 
	`quantity` INT NOT NULL,
	`fk_order_id` INT NOT NULL,
	`fk_item_id` INT NOT NULL,
	PRIMARY KEY (`order_items_id`),
	CONSTRAINT FOREIGN KEY (`fk_order_id`) REFERENCES `orders`(`order_id`),
	CONSTRAINT FOREIGN KEY (`fk_item_id`) REFERENCES `items`(`item_id`)

);
