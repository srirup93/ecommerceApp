CREATE DATABASE IF NOT EXISTS `productservice`;

USE `productservice`;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`product_name` varchar(100) DEFAULT NULL,
	`price` double(20, 2) DEFAULT NULL,
	`description` varchar(100) DEFAULT NULL,
	`catagory` varchar(20) DEFAULT NULL,
	`availability` int(2) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;