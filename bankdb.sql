-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (arm64)
--
-- Host: localhost    Database: bankdb
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bankdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bankdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bankdb`;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_code` int NOT NULL AUTO_INCREMENT,
  `account_no` bigint NOT NULL,
  `customer_code` int NOT NULL,
  `product_code` int NOT NULL,
  PRIMARY KEY (`account_code`),
  KEY `customer_code` (`customer_code`),
  KEY `product_code` (`product_code`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`customer_code`) REFERENCES `customer` (`customercode`),
  CONSTRAINT `account_ibfk_2` FOREIGN KEY (`product_code`) REFERENCES `customer` (`customercode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,123456789,1,1),(2,123456312,2,2),(3,123456231,3,4),(4,123452121,4,3),(5,123432123,5,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customercode` int NOT NULL AUTO_INCREMENT,
  `customer_firstname` varchar(20) NOT NULL,
  `customer_lastname` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `age` int DEFAULT NULL,
  `phonenumber` bigint NOT NULL,
  `aadhar_no` bigint NOT NULL,
  PRIMARY KEY (`customercode`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Parul','Gandhi','Delhi',21,7863452678,2222329388),(2,'damodar','unnimakan','cochin',28,765889282,555555333334444),(3,'Nisha','Shankar','Mumbai',24,78999002900,12345678),(4,'Abhishek','Dutta','Mumbai',30,79893930202,7777719999288),(5,'Shankar','Nair','cochin',23,78298928102,2829912092922),(6,'ram','ravi','mumbai',35,9633511235,29192198),(7,'mahesh','r','mumbai',33,92199801290,21892180),(8,'ravi','shankar','mumbai',29,29889209,329902),(9,'nirupam','abhijith','palakkad',NULL,938928903,2109390139);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productcode` int NOT NULL AUTO_INCREMENT,
  `productname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`productcode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'savings account'),(2,'current account'),(3,'rural account'),(4,'womens savings account'),(5,'loan account'),(6,'max savings account');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_service`
--

DROP TABLE IF EXISTS `product_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_service` (
  `product_service_code` int NOT NULL AUTO_INCREMENT,
  `product_code` int NOT NULL,
  `service_code` int NOT NULL,
  PRIMARY KEY (`product_service_code`),
  KEY `product_code` (`product_code`),
  KEY `service_code` (`service_code`),
  CONSTRAINT `product_service_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `product` (`productcode`),
  CONSTRAINT `product_service_ibfk_2` FOREIGN KEY (`service_code`) REFERENCES `service` (`service_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_service`
--

LOCK TABLES `product_service` WRITE;
/*!40000 ALTER TABLE `product_service` DISABLE KEYS */;
INSERT INTO `product_service` VALUES (1,1,1),(2,1,4),(3,1,5),(4,2,1),(5,4,1),(6,4,3),(7,4,5);
/*!40000 ALTER TABLE `product_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_code` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(20) NOT NULL,
  PRIMARY KEY (`service_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Cash Deposit'),(2,'Cash Withdrawal'),(3,'ATM Deposit'),(4,'ATM Withdrawal'),(5,'Cheque book');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `product_code` int NOT NULL,
  `service_code` int NOT NULL,
  `date_of_transaction` datetime NOT NULL,
  `volume` bigint NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `product_code` (`product_code`),
  KEY `service_code` (`service_code`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `product` (`productcode`),
  CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`service_code`) REFERENCES `service` (`service_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1,1,'2021-11-16 19:32:18',60000000),(2,1,2,'2021-12-28 21:21:30',87654433),(3,1,4,'2021-12-29 18:16:34',788888888),(4,2,1,'2021-12-27 15:16:34',7986554),(5,2,2,'2021-11-16 23:10:49',366666666),(6,3,2,'2021-11-18 13:52:18',608654400);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-19 16:14:10
