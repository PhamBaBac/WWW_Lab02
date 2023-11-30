-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.35 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shops
DROP DATABASE IF EXISTS `shops`;
CREATE DATABASE IF NOT EXISTS `shops` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shops`;

-- Dumping structure for table shops.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cust_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(250) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `cust_name` varchar(150) NOT NULL,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`cust_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.customer: ~1 rows (approximately)
INSERT INTO `customer` (`cust_id`, `address`, `email`, `cust_name`, `phone`) VALUES
	(1, 'Nghệ An', 'bac@gail.com', 'Phạm Bắc', '0123456789');

-- Dumping structure for table shops.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(250) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `full_name` varchar(150) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.employee: ~1 rows (approximately)
INSERT INTO `employee` (`emp_id`, `address`, `dob`, `email`, `full_name`, `phone`, `status`) VALUES
	(1, 'HCM', '2023-11-13', 'bac@gmail.com', 'NaNa', '0986654321', 1);

-- Dumping structure for table shops.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `order_date` datetime(6) NOT NULL,
  `cust_id` bigint DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  `LSTORDER_emp_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_orders_LSTORDER_emp_id` (`LSTORDER_emp_id`),
  KEY `FK_orders_employee_id` (`employee_id`),
  KEY `FK_orders_cust_id` (`cust_id`),
  CONSTRAINT `FK_orders_cust_id` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `FK_orders_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `FK_orders_LSTORDER_emp_id` FOREIGN KEY (`LSTORDER_emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.orders: ~1 rows (approximately)
INSERT INTO `orders` (`order_id`, `order_date`, `cust_id`, `employee_id`, `LSTORDER_emp_id`) VALUES
	(1, '2023-11-30 09:40:41.000000', 1, 1, 1);

-- Dumping structure for table shops.order_detail
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `note` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `order_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FK_order_detail_product_id` (`product_id`),
  CONSTRAINT `FK_order_detail_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FK_order_detail_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.order_detail: ~2 rows (approximately)
INSERT INTO `order_detail` (`note`, `price`, `quantity`, `order_id`, `product_id`) VALUES
	(NULL, 40000000, 1, 1, 1),
	(NULL, 40000000, 1, 1, 2);

-- Dumping structure for table shops.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(250) NOT NULL,
  `manufacturer_name` varchar(100) NOT NULL,
  `name` varchar(150) NOT NULL,
  `status` int DEFAULT NULL,
  `unit` varchar(25) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.product: ~2 rows (approximately)
INSERT INTO `product` (`product_id`, `description`, `manufacturer_name`, `name`, `status`, `unit`) VALUES
	(1, 'Chip A17 Pro mạnh mẽ và pin dung lượng cực lớn', 'Apple', 'Apple iPhone 15 Pro', 1, 'chiếc'),
	(2, 'Chip A17 Pro mạnh mẽ và pin dung lượng cực lớn', 'Apple', 'Apple iPhone 15 Pro', 1, 'Chiếc');

-- Dumping structure for table shops.product_image
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE IF NOT EXISTS `product_image` (
  `image_id` bigint NOT NULL AUTO_INCREMENT,
  `alternative` varchar(250) DEFAULT NULL,
  `path` varchar(250) NOT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK_product_image_product_id` (`product_id`),
  CONSTRAINT `FK_product_image_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.product_image: ~2 rows (approximately)
INSERT INTO `product_image` (`image_id`, `alternative`, `path`, `product_id`) VALUES
	(1, NULL, 'https://salt.tikicdn.com/cache/750x750/ts/product/95/c1/a3/ebaf493be9f3a65768aa2125483f6be5.png.webp', 1),
	(2, NULL, 'https://salt.tikicdn.com/cache/750x750/ts/product/6c/6c/9e/f3464d16a782e0d9ed5f74d98f155642.png.webp', 2);

-- Dumping structure for table shops.product_price
DROP TABLE IF EXISTS `product_price`;
CREATE TABLE IF NOT EXISTS `product_price` (
  `price_date_time` datetime(6) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`price_date_time`,`product_id`),
  KEY `FK_product_price_product_id` (`product_id`),
  CONSTRAINT `FK_product_price_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table shops.product_price: ~2 rows (approximately)
INSERT INTO `product_price` (`price_date_time`, `note`, `price`, `product_id`) VALUES
	('2023-11-30 09:36:37.000000', NULL, 33999999, 1),
	('2023-11-30 10:28:18.000000', NULL, 33999999, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
