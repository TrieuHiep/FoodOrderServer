-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: fooddb
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES ('2090758514581187','NULL'),('742203739307672','NULL'),('JavaBot','abcxyz123'),('staff1','abcxyz123'),('tatsuya','nthangzuzu'),('tptitcb','123'),('trieuhiep','abcxyz123'),('trieuhiepptit','abcxyz123');
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bill`
--

DROP TABLE IF EXISTS `Bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bill` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `EmployeePersonID` int(10) NOT NULL,
  `OrderID` int(10) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKBill69969` (`OrderID`),
  KEY `FKBill448541` (`EmployeePersonID`),
  CONSTRAINT `FKBill448541` FOREIGN KEY (`EmployeePersonID`) REFERENCES `Employee` (`PersonID`),
  CONSTRAINT `FKBill69969` FOREIGN KEY (`OrderID`) REFERENCES `FoodOrder` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bill`
--

LOCK TABLES `Bill` WRITE;
/*!40000 ALTER TABLE `Bill` DISABLE KEYS */;
INSERT INTO `Bill` VALUES (1,3,20,'No description');
/*!40000 ALTER TABLE `Bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Chicken`
--

DROP TABLE IF EXISTS `Chicken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Chicken` (
  `FoodID` int(10) NOT NULL,
  PRIMARY KEY (`FoodID`),
  KEY `FKChicken848746` (`FoodID`),
  CONSTRAINT `FKChicken848746` FOREIGN KEY (`FoodID`) REFERENCES `Food` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Chicken`
--

LOCK TABLES `Chicken` WRITE;
/*!40000 ALTER TABLE `Chicken` DISABLE KEYS */;
INSERT INTO `Chicken` VALUES (6),(7),(8);
/*!40000 ALTER TABLE `Chicken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `Email` varchar(255) DEFAULT NULL,
  `PersonID` int(10) NOT NULL,
  PRIMARY KEY (`PersonID`),
  KEY `FKCustomer220859` (`PersonID`),
  CONSTRAINT `FKCustomer220859` FOREIGN KEY (`PersonID`) REFERENCES `Person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES ('tatsuya@gmail.com',1),('trieuhiep@gmail.com',2),('javabot@gmail.com',4),('trieuhiepptit@gmail.com',5),('trieuhiepptit@gmail.com',6),('test@gmail.com',7),('tptitcb@gmail.com',9);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `InternalMail` varchar(255) DEFAULT NULL,
  `PersonID` int(10) NOT NULL,
  PRIMARY KEY (`PersonID`),
  KEY `FKEmployee925855` (`PersonID`),
  CONSTRAINT `FKEmployee925855` FOREIGN KEY (`PersonID`) REFERENCES `Person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES ('ngoc@gmail.com',3);
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Food`
--

DROP TABLE IF EXISTS `Food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Food` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) DEFAULT NULL,
  `Price` bigint(20) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `ImageURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Food`
--

LOCK TABLES `Food` WRITE;
/*!40000 ALTER TABLE `Food` DISABLE KEYS */;
INSERT INTO `Food` VALUES (1,'Burger Big Star',50000,100,'http://192.168.43.11:8080/images/burger/bigstar.png'),(2,'Burger Gà Cay',48000,100,'http://192.168.43.11:8080/images/burger/gacay.png'),(3,'Burger Tôm',43000,100,'http://192.168.43.11:8080/images/burger/tom.png'),(4,'Bulgogi Burger',40000,100,'http://192.168.43.11:8080/images/burger/bulgogi.png'),(5,'Burger Phô Mai',32000,100,'http://192.168.43.11:8080/images/burger/phomai.png'),(6,'Gà Sốt Phô Mai',37000,100,'http://192.168.43.11:8080/images/chicken/ga_sot_pho_mai.png'),(7,'Gà Rán',35000,100,'http://192.168.43.11:8080/images/chicken/garan.png'),(8,'Gà Sốt Đậu',36000,100,'http://192.168.43.11:8080/images/chicken/gasotdau.png'),(9,'Cơm Thịt Sốt Cay',40000,100,'http://192.168.43.11:8080/images/rice/comsotcay.png'),(10,'Cơm Thịt Phô Mai',40000,100,'http://192.168.43.11:8080/images/rice/comphomai.png');
/*!40000 ALTER TABLE `Food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FoodOrder`
--

DROP TABLE IF EXISTS `FoodOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FoodOrder` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `MealID` int(10) NOT NULL,
  `CreattionDate` varchar(255) DEFAULT NULL,
  `PaymentType` varchar(255) DEFAULT NULL,
  `Status` varchar(45) CHARACTER SET dec8 DEFAULT NULL,
  `Address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKOrder403025` (`MealID`),
  CONSTRAINT `FKOrder403025` FOREIGN KEY (`MealID`) REFERENCES `Meal` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FoodOrder`
--

LOCK TABLES `FoodOrder` WRITE;
/*!40000 ALTER TABLE `FoodOrder` DISABLE KEYS */;
INSERT INTO `FoodOrder` VALUES (18,21,'4 May 2018 14:36:09','PaypalPayment','Sent','Ph??ng ??, Hà Giang, Vietnam'),(19,21,'4 May 2018 17:32:34','PaypalPayment','Sent','Cat Ba, Cát H?i, Hai Phong, Vietnam'),(20,26,'7 May 2018 15:27:34','PaypalPayment','Delivered','11 Nguy?n ?ình Chi?u, ?a Kao, Qu?n 1, H? Chí Minh, Vietnam'),(21,28,'7 May 2018 15:27:34','PaypalPayment','Sent','11 Nguy?n ?ình Chi?u, ?a Kao, Qu?n 1, H? Chí Minh, Vietnam'),(22,27,'7 May 2018 15:27:34','PaypalPayment','Sent','11 Nguy?n ?ình Chi?u, ?a Kao, Qu?n 1, H? Chí Minh, Vietnam');
/*!40000 ALTER TABLE `FoodOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hamburger`
--

DROP TABLE IF EXISTS `Hamburger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hamburger` (
  `FoodID` int(10) NOT NULL,
  PRIMARY KEY (`FoodID`),
  KEY `FKHamburger777727` (`FoodID`),
  CONSTRAINT `FKHamburger777727` FOREIGN KEY (`FoodID`) REFERENCES `Food` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hamburger`
--

LOCK TABLES `Hamburger` WRITE;
/*!40000 ALTER TABLE `Hamburger` DISABLE KEYS */;
INSERT INTO `Hamburger` VALUES (1),(2),(3),(4),(5);
/*!40000 ALTER TABLE `Hamburger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Meal`
--

DROP TABLE IF EXISTS `Meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Meal` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Quantity` int(10) NOT NULL,
  `FoodID` int(10) NOT NULL,
  `CustomerPersonID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Meal` (`FoodID`),
  KEY `Meal2` (`CustomerPersonID`),
  CONSTRAINT `Meal` FOREIGN KEY (`FoodID`) REFERENCES `Food` (`ID`),
  CONSTRAINT `Meal2` FOREIGN KEY (`CustomerPersonID`) REFERENCES `Customer` (`PersonID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Meal`
--

LOCK TABLES `Meal` WRITE;
/*!40000 ALTER TABLE `Meal` DISABLE KEYS */;
INSERT INTO `Meal` VALUES (21,3,1,2),(22,1,9,2),(23,1,4,2),(24,1,6,2),(25,1,7,2),(26,2,3,4),(27,1,4,4),(28,1,2,4);
/*!40000 ALTER TABLE `Meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `AccountUsername` varchar(255) NOT NULL,
  `Age` int(10) NOT NULL,
  `FullName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKPerson427004` (`AccountUsername`),
  CONSTRAINT `FKPerson427004` FOREIGN KEY (`AccountUsername`) REFERENCES `Account` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'tatsuya',23,'Tatsuya'),(2,'trieuhiep',23,'Trieu Tuan Hiep'),(3,'staff1',30,'Nguyen Hong Ngoc'),(4,'JavaBot',23,'Java Bot'),(5,'trieuhiepptit',23,'Trieu Hiep PTIT'),(6,'742203739307672',23,'Tri?u Hi?p'),(7,'2090758514581187',23,'Mai Chi ?inh'),(9,'tptitcb',23,'Dang Quang Thanh');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rice`
--

DROP TABLE IF EXISTS `Rice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rice` (
  `FoodID` int(10) NOT NULL,
  PRIMARY KEY (`FoodID`),
  KEY `FKRice703597` (`FoodID`),
  CONSTRAINT `FKRice703597` FOREIGN KEY (`FoodID`) REFERENCES `Food` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rice`
--

LOCK TABLES `Rice` WRITE;
/*!40000 ALTER TABLE `Rice` DISABLE KEYS */;
INSERT INTO `Rice` VALUES (9),(10);
/*!40000 ALTER TABLE `Rice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-07 21:49:39
