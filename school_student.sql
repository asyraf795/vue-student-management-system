-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(500) NOT NULL,
  `LAST_NAME` varchar(500) NOT NULL,
  `PHONE_NUMBER` varchar(25) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `ADDRESS` varchar(500) NOT NULL,
  `POSTCODE` varchar(25) NOT NULL,
  `STATE` varchar(250) NOT NULL,
  `COUNTRY` varchar(250) NOT NULL,
  `DATE_OF_BIRTH` date NOT NULL,
  `IC` varchar(25) NOT NULL,
  `GENDER` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'MOHAMMAD ASYRAF','ISMAIL','0199564456','beta.asyraf95@gmail.com','1337, Jalan E4/17, Taman Ehsan, Kepong','52100','Kuala Lumpur','MY','2019-12-30','950723115119','MALE'),(2,'MOHAMMAD SYAMIN','ISMAIL','0199564456','beta.asyraf95@gmail.com','1337, Jalan E4/17, Taman Ehsan, Kepong','52100','Kuala Lumpur','MY','2019-12-30','950723115119','MALE'),(3,'MOHAMMAD SYAMIN','ISMAIL','0199564456','beta.asyraf95@gmail.com','1337, Jalan E4/17, Taman Ehsan, Kepong','52100','Kuala Lumpur','MY','2019-12-30','950723115119','MALE');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-31  6:20:56
