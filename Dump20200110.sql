CREATE DATABASE  IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `school`;
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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(500) NOT NULL,
  `ABBREVIATION` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`TITLE`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Computer Science','CS'),(2,'Software Engineering','SE'),(3,'Medical','MD'),(4,'Law','LW'),(5,'Civil Engineering','CE'),(6,'Music and Arts','MS'),(7,'Agriculture','AG'),(8,'Islamic Studies','IM'),(9,'Russian Language','RS');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

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
  `PHONE_NUMBER` varchar(25) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  `POSTCODE` varchar(25) DEFAULT NULL,
  `STATE` varchar(250) DEFAULT NULL,
  `COUNTRY` varchar(250) DEFAULT NULL,
  `DATE_OF_BIRTH` datetime DEFAULT NULL,
  `IC` varchar(25) NOT NULL,
  `GENDER` varchar(6) DEFAULT NULL,
  `COURSE_ID` int(6) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IC_UNIQUE` (`IC`),
  KEY `COURSE_ID` (`COURSE_ID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'MOHAMMAD ASYRAF','ISMAIL','0199564456','ismail.asyraf795@gmail.com','1337, Jalan E4/17, Taman Ehsan, Kepong','52100','KUL',NULL,'1995-07-22 16:00:00','950723115119','M',3),(2,'NAN RAFIZAH','MEGAT AMAT','01110668279','isnarafizah71@gmail.com','1337, Jalan E4/17, Taman Ehsan, Kepong','52100','KUL',NULL,'1971-04-15 16:30:00','710416115060','F',2),(3,'ISMAIL','IBRAHIM','0147262164','nais7887@gmail.com','1337, Jalan E4/17, Taman Ehsan, Kepong','52100','KUL',NULL,'1964-05-13 16:30:00','640514115119','M',3),(4,'KUJI','IYOMI','0110442351','kuji.iyomi@gmail.com','1257, Jalan E5/17, Taman Ehsan','52100','KUL',NULL,'1994-02-11 16:00:00','940211115634','F',4),(5,'AHMAD','HANIF','01422156112','ahmad.hanif@gmail.com','152, Jalan Taman Semarak Jaya, Subang Jaya','52151','SGR',NULL,'1991-04-30 16:00:00','910501104231','M',5),(6,'MAI','IYOMI','0110442351','kuji.iyomi@gmail.com','1257, Jalan E5/17, Taman Ehsan','52100','KUL',NULL,'1996-02-10 16:00:00','960211115634','F',6),(7,'BRAVA','STRATVA','0195521482','brave.strat@gmail.com','4534, Apartment Merak Terbang, Petaling Jaya','52551','KUL',NULL,'1996-02-20 16:00:00','960221045631','M',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'school'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-10 23:15:31
