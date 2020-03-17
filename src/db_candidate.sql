CREATE DATABASE  IF NOT EXISTS `db_candidate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_candidate`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_candidate
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `candidates`
--

DROP TABLE IF EXISTS `candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidates` (
  `idCandidates` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(80) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `candidateType` int(11) DEFAULT NULL,
  `expInYear` int(11) DEFAULT NULL,
  `proSkill` varchar(45) DEFAULT NULL,
  `graduationDate` varchar(45) DEFAULT NULL,
  `graduationRank` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `universityName` varchar(45) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCandidates`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidates`
--

LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (1,'Name updated','08/10/1997','0378397678','trhuuluong@gmail.com',0,5,'Android','','','','','',0),(2,'Hoang Van Dai','09/05/1998','0986777453','daohv@gmail.com',1,0,'','09/09/2017','Junior','Goolge Challenge','','',0),(3,'Nguyen Cong Vuong','23/06/1995','0983882564','nguyencv@gmail.com',2,0,'','','','','Information Technology','QBU',4),(4,'Duong Cong Thu','02/03/1994','036547662','duongcongthu@gmail.com',0,3,'Backend Java','','','','','',0),(5,'New Insert Name','08/10/1997','0378345678','newinsert@gmail.com',0,10,'New Skill',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificated`
--

DROP TABLE IF EXISTS `certificated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificated` (
  `idcertificated` int(11) NOT NULL AUTO_INCREMENT,
  `certificatedName` varchar(80) DEFAULT NULL,
  `certificatedRank` varchar(45) DEFAULT NULL,
  `certificatedDate` varchar(45) DEFAULT NULL,
  `idCandidates` int(11) NOT NULL,
  PRIMARY KEY (`idcertificated`),
  KEY `idCandidates_idx` (`idCandidates`),
  CONSTRAINT `idCandidates` FOREIGN KEY (`idCandidates`) REFERENCES `candidates` (`idCandidates`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificated`
--

LOCK TABLES `certificated` WRITE;
/*!40000 ALTER TABLE `certificated` DISABLE KEYS */;
INSERT INTO `certificated` VALUES (1,'Nodejs','Junior','03/02/2020',1);
/*!40000 ALTER TABLE `certificated` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-17 14:46:33
