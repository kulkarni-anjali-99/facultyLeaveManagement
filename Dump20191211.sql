CREATE DATABASE  IF NOT EXISTS `dbmsproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbmsproject`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbmsproject
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `leave_`
--

DROP TABLE IF EXISTS `leave_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_` (
  `staff_id` varchar(10) NOT NULL,
  `earned_leave` int(11) DEFAULT NULL,
  `casual_leave` int(11) DEFAULT NULL,
  `maternity_leave` int(11) DEFAULT NULL,
  `paternity_leave` int(11) DEFAULT NULL,
  `restricted_holidays` int(11) DEFAULT NULL,
  `encashment_status` varchar(10) DEFAULT NULL,
  `total_leaves` int(11) NOT NULL,
  `leave_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`staff_id`,`total_leaves`),
  CONSTRAINT `leave__ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `leave__ibfk_2` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_`
--

LOCK TABLES `leave_` WRITE;
/*!40000 ALTER TABLE `leave_` DISABLE KEYS */;
INSERT INTO `leave_` VALUES ('BMSIS001',2,0,0,0,0,NULL,0,'approved'),('BMSIS002',0,0,0,0,0,NULL,0,'approved'),('BMSIS003',0,0,0,0,0,NULL,0,NULL),('BMSIS004',0,0,0,0,0,NULL,0,NULL),('BMSIS005',0,0,0,0,0,NULL,0,NULL),('BMSIS006',0,0,0,0,0,NULL,0,NULL),('BMSIS007',0,0,0,0,0,NULL,0,NULL),('BMSIS008',0,0,0,0,0,NULL,0,'approved'),('BMSIS009',0,0,0,0,0,NULL,0,NULL),('BMSIS010',0,0,0,0,0,NULL,0,NULL),('BMSIS011',0,0,0,0,0,NULL,0,NULL),('BMSIS012',0,0,0,0,0,NULL,0,NULL),('BMSIS013',0,0,0,0,0,NULL,0,NULL),('BMSIS014',0,0,0,0,0,NULL,0,NULL),('BMSIS015',0,0,0,0,0,NULL,0,NULL),('BMSIS016',0,0,0,0,0,NULL,0,NULL),('BMSIS017',0,0,0,0,0,NULL,0,NULL),('BMSIS018',0,0,0,0,0,NULL,0,NULL),('BMSIS019',0,0,0,0,0,NULL,0,NULL),('BMSIS020',0,0,0,0,0,NULL,0,NULL),('BMSIS021',0,0,0,0,0,NULL,0,NULL),('BMSIS022',0,0,0,0,0,NULL,0,NULL),('BMSIS023',0,0,0,0,0,NULL,0,NULL),('BMSIS024',0,0,0,0,0,NULL,0,NULL),('BMSIS025',0,0,0,0,0,NULL,0,NULL),('BMSIS026',0,0,0,0,0,NULL,0,NULL),('BMSIS027',0,0,0,0,0,NULL,0,NULL),('BMSIS028',0,0,0,0,0,NULL,0,NULL),('BMSIS029',0,0,0,0,0,NULL,0,NULL),('BMSIS030',0,0,0,0,0,NULL,0,NULL),('BMSIS031',0,0,0,0,0,NULL,0,NULL),('BMSIS032',0,0,0,0,0,NULL,0,NULL);
/*!40000 ALTER TABLE `leave_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_report`
--

DROP TABLE IF EXISTS `leave_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_report` (
  `staff_id` varchar(20) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date DEFAULT NULL,
  `no_of_days` int(11) NOT NULL,
  `DAY_OF_START` varchar(10) NOT NULL,
  `reason` varchar(100) NOT NULL,
  PRIMARY KEY (`staff_id`,`from_date`),
  CONSTRAINT `leave_report_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_report`
--

LOCK TABLES `leave_report` WRITE;
/*!40000 ALTER TABLE `leave_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` varchar(10) NOT NULL,
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `middle_name` varchar(25) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `passwrd` varchar(15) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('BMSIS001','Guruprasad','H','S','anannya.is17@bmsce.ac.in','hsgise','Professor'),('BMSIS002','Shambhavi','R','B','brshambhavi.ise@bmsce.ac.in','brsise','Associate Professor'),('BMSIS003','Sheela','S','V','ssv.ise@bmsce.ac.in','ssvise','Professor'),('BMSIS004','Jayarekha','P','','jayarekha.ise@bmsce.ac.in','pjrise','Professor'),('BMSIS005','Mamatha','R','K','aishwaryapatil.is17@bmsce.ac.in','krmise','Assistant Professor'),('BMSIS006','Sreelatha','R','','sree.ise@bmsce.ac.in','slrise','Assistant Professor'),('BMSIS007','Nalini','M','K','nalini.ise@bmsce.ac.in','mknise','Assistant Professor'),('BMSIS008','Shubha','V','Rao','harikajayanthi.is17@bmsce.ac.in','vsrise','Assistant Professor'),('BMSIS009','Sindhu','K','','ksindhu.ise@bmsce.ac.in','ksise','Assistant Professor'),('BMSIS010','Preetha','S','','harikajrox@gmail.com','spise','Assistant Professor'),('BMSIS011','Mahalakshmi','S','B','bsmahalakshmi.ise@bmsce.ac.in','bsmise','Assistant Professor'),('BMSIS012','Rajeshwari','K','','harjanu@gamil.com','rkise','Assistant Professor'),('BMSIS013','Nalina','V','','nalinav.ise@bmsce.ac.in','nvise','Assistant Professor'),('BMSIS014','Roopa','R','','roopa.ise@bmsce.ac.in','rrise','Assistant Professor'),('BMSIS015','Gururaj','H','S','gururajhs.ise@bmsce.ac.in','ghsgise','Assistant Professor'),('BMSIS016','Sowmya','K','S','sowmyaks.ise@bmsce.ac.in','sksise','Assistant Professor'),('BMSIS017','Chandrakala','Raju','G','chandrakalagraju.ise@bmsce.ac.in','xyz','Assistant Professor'),('BMSIS018','Anitha','M','H','anithahm.ise@bmsce.ac.in','ahmise','Assistant Professor'),('BMSIS019','Sandeep','Varma','N','sandeepvarma.ise@bmsce.ac.in','svnise','Assistant Professor'),('BMSIS020','Indra','R','','indra.ise@bmsce.ac.in','irise','Assistant Professor'),('BMSIS021','Radhika','K','R','rkr.ise@bmsce.ac.in','rkrise','Professor'),('BMSIS022','Ashok','Kumar','R','ashokkumar.ise@bmsce.ac.in','akrise','Professor'),('BMSIS023','Dakshayini','M','','anjaliv.is17@bmsce.ac.in','hodise','HOD'),('BMSIS024','Shobana','S','T','shobanats.ise@bmsce.ac.in','stsise','Assistant Professor'),('BMSIS025','Monisha','M','H','monishahm.ise@bmsce.ac.in','mhmise','Assistant Professor'),('BMSIS026','Rashmi','R','','rashmir.ise@bmsce.ac.in','rrise','Assistant Professor'),('BMSIS027','Rashmi','B','K','rashmikb.ise@bmsce.ac.in','rkbise','Assistant Professor'),('BMSIS028','Roopa','K','Murthy','roopak.ise@bmsce.ac.in','rkmise','Assistant Professor'),('BMSIS029','Ramesh','T','S','tssairamesh@gmail.com','tsrise','Programmer'),('BMSIS030','Jayshree','','','jayashree.ise@bmsce.ac.in','jise','SDA'),('BMSIS031','Sree Lakshmi','S','B','sreelakshmibs.ise@bmsce.ac.in','srbise','Assistant Instructor'),('BMSIS032','Bharathi','J','','bharathij.ise@bmsce.ac.in','bjise','SDA');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `substitution`
--

DROP TABLE IF EXISTS `substitution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `substitution` (
  `leave_staff_id` varchar(10) NOT NULL,
  `sub_staff_id` varchar(10) NOT NULL,
  `sem` int(11) NOT NULL,
  PRIMARY KEY (`leave_staff_id`,`sub_staff_id`,`sem`),
  CONSTRAINT `substitution_ibfk_1` FOREIGN KEY (`leave_staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `substitution_ibfk_2` FOREIGN KEY (`leave_staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `substitution`
--

LOCK TABLES `substitution` WRITE;
/*!40000 ALTER TABLE `substitution` DISABLE KEYS */;
/*!40000 ALTER TABLE `substitution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable` (
  `staff_id` varchar(10) NOT NULL,
  `subject_` varchar(10) DEFAULT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `day_of_week` varchar(10) NOT NULL,
  `semester` int(11) DEFAULT NULL,
  `section` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`staff_id`,`start_time`,`end_time`,`day_of_week`),
  CONSTRAINT `timetable_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES ('BMSIS001','DSC','09:50:00','10:45:00','MONDAY',3,'A'),('BMSIS001','DSC','09:50:00','10:45:00','TUEDSDAY',3,'A'),('BMSIS001','DSC','09:50:00','10:45:00','WEDNESDAY',3,'A'),('BMSIS002','DBMS','08:55:00','09:50:00','SATURDAY',5,'A'),('BMSIS002','DBMS','09:50:00','10:45:00','FRIDAY',5,'A'),('BMSIS002','DBMS','11:15:00','12:10:00','MONDAY',5,'A'),('BMSIS002','DS','11:15:00','12:10:00','WEDNESDAY',3,'C'),('BMSIS002','DBMS LAB','11:15:00','13:05:00','TUESDAY',5,'A'),('BMSIS002','DS','12:10:00','13:05:00','THURSDAY',3,'C'),('BMSIS002','DS LAB','14:00:00','15:50:00','MONDAY',3,'C'),('BMSIS003','WP','08:55:00','09:50:00','FRIDAY',5,'A'),('BMSIS003','MAD','08:55:00','09:50:00','THURSDAY',7,'A'),('BMSIS003','MAD LAB','08:55:00','10:45:00','SATURDAY',7,'A'),('BMSIS003','MAD','09:50:00','10:45:00','MONDAY',7,'A'),('BMSIS003','MAD','09:50:00','10:45:00','TUESDAY',7,'A'),('BMSIS003','WP','11:15:00','12:10:00','THURSDAY',5,'A'),('BMSIS003','WP LAB','11:15:00','13:05:00','FRIDAY',5,'A'),('BMSIS004','DCN','09:50:00','10:45:00','MONDAY',5,'A'),('BMSIS004','DCN','09:50:00','10:45:00','SATURDAY',5,'A'),('BMSIS004','DCN LAB','11:15:00','13:05:00','SATURDAY',5,'B'),('BMSIS004','DCN TUTOR','11:15:00','13:05:00','WEDNESDAY',5,'A'),('BMSIS004','DCN','14:00:00','14:55:00','TUESDAY',5,'A'),('BMSIS004','DCN LAB','14:00:00','15:50:00','THURSDAY',5,'A'),('BMSIS005','DD','08:55:00','09:50:00','TUESDAY',3,'A'),('BMSIS005','IE','08:55:00','09:50:00','WEDNESDAY',7,'A'),('BMSIS005','WP LAB','08:55:00','10:45:00','MONDAY',5,'B'),('BMSIS005','CCP LAB','08:55:00','10:45:00','THURSDAY',1,'J'),('BMSIS005','DD','09:50:00','10:45:00','FRIDAY',3,'A'),('BMSIS005','WP LAB','11:15:00','13:05:00','FRIDAY',5,'A'),('BMSIS005','IE','11:15:00','13:05:00','SATURDAY',7,'A'),('BMSIS005','MAD LAB','11:15:00','13:05:00','THURSDAY',7,'B'),('BMSIS005','CCP LAB','11:15:00','13:05:00','TUESDAY',1,'G'),('BMSIS005','CCP LAB','11:15:00','13:05:00','WEDNESDAY',1,'B'),('BMSIS005','DD TUTOR','14:00:00','15:50:00','MONDAY',3,'A'),('BMSIS005','OOP LAB','14:00:00','15:50:00','THURSDAY',3,'C'),('BMSIS006','WP','08:55:00','09:50:00','TUESDAY',5,'B'),('BMSIS006','WP LAB','08:55:00','10:45:00','MONDAY',5,'B'),('BMSIS006','MC LAB','08:55:00','10:45:00','THURSDAY',7,'B'),('BMSIS006','PYTHON LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS006','DD','09:50:00','10:45:00','FRIDAY',3,'B'),('BMSIS006','WP','09:50:00','10:45:00','SATURDAY',5,'B'),('BMSIS006','DBMS LAB','11:15:00','12:10:00','TUESDAY',5,'A'),('BMSIS006','DD','11:15:00','12:50:00','WEDNESDAY',3,'B'),('BMSIS006','WP LAB','11:15:00','13:05:00','FRIDAY',5,'A'),('BMSIS006','WP','12:10:00','13:05:00','THURSDAY',5,'B'),('BMSIS006','DD TUTOR','14:00:00','15:50:00','MONDAY',3,'A'),('BMSIS006','DD TUTOR','14:00:00','15:50:00','TUESDAY',3,'B'),('BMSIS006','DD TUTOR','14:00:00','15:50:00','WEDNESDAY',3,'C'),('BMSIS007','CCP','08:55:00','09:05:00','SATURDAY',1,'G'),('BMSIS007','CCP LAB','08:55:00','09:50:00','THURSDAY',1,'J'),('BMSIS007','CCP','08:55:00','10:45:00','FRIDAY',1,'G'),('BMSIS007','CCP LAB','08:55:00','10:45:00','MONDAY',1,'N'),('BMSIS007','DM LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS007','CCP','11:15:00','12:10:00','THURSDAY',1,'N'),('BMSIS007','CCP LAB','11:15:00','13:05:00','FRIDAY',1,'L'),('BMSIS007','CCP LAB','11:15:00','13:05:00','TUESDAY',1,'G'),('BMSIS007','CCP','11:15:00','13:05:00','WEDNESDAY',1,'N'),('BMSIS007','DS LAB','14:00:00','15:50:00','MONDAY',3,'B'),('BMSIS007','CCP LAB','14:00:00','15:50:00','WEDNESDAY',1,'M'),('BMSIS008','AWP','08:55:00','09:50:00','TUESDAY',7,'A'),('BMSIS008','OOP LAB','08:55:00','10:45:00','THURSDAY',3,'A'),('BMSIS008','DM LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS008','OOP','11:15:00','12:10:00','SATURDAY',3,'A'),('BMSIS008','AWP','11:15:00','13:05:00','FRIDAY',7,'A'),('BMSIS008','WP LAB','11:15:00','13:05:00','MONDAY',3,'C'),('BMSIS008','MC LAB','11:15:00','13:05:00','TUESDAY',7,'A'),('BMSIS008','OOP','12:10:00','13:05:00','THURSDAY',3,'A'),('BMSIS008','OOP','14:00:00','14:55:00','FRIDAY',3,'A'),('BMSIS008','WP LAB','14:00:00','15:50:00','TUESDAY',3,'A'),('BMSIS008','WP LAB','14:00:00','15:50:00','WEDNESDAY',3,'B'),('BMSIS009','JAVA LAB','08:55:00','10:45:00','FRIDAY',5,'B'),('BMSIS009','MAD LAB','08:55:00','10:45:00','SATURDAY',7,'A'),('BMSIS009','OOP LAB','08:55:00','10:45:00','THURSDAY',3,'A'),('BMSIS009','MAD','09:50:00','10:45:00','MONDAY',7,'B'),('BMSIS009','OOP','09:50:00','10:45:00','WEDNESDAY',3,'B'),('BMSIS009','OOP','11:15:00','12:10:00','MONDAY',3,'B'),('BMSIS009','OOP','11:15:00','12:10:00','OOP',3,'B'),('BMSIS009','MAD','11:15:00','12:10:00','TUEDAY',7,'B'),('BMSIS009','MAD','11:15:00','12:10:00','WEDNESDAY',7,'B'),('BMSIS009','MAD LAB','11:15:00','13:05:00','THURSDAY',7,'B'),('BMSIS009','OOP LAB','14:00:00','15:50:00','MONDAY',3,'B'),('BMSIS009','OOP LAB','14:00:00','15:50:00','THURSDAY',3,'C'),('BMSIS010','COA','08:55:00','09:50:00','WEDNESDAY',3,'A'),('BMSIS010','JAVA LAB','08:55:00','10:45:00','FRIDAY',5,'B'),('BMSIS010','MAD LAB','08:55:00','10:45:00','SATURDAY',7,'A'),('BMSIS010','JAVA LAB','08:55:00','10:45:00','TUESDAY',5,'A'),('BMSIS010','ICL','09:50:00','10:45:00','THURSDAY',7,'A'),('BMSIS010','ICL','11:15:00','13:05:00','ICL',7,'A'),('BMSIS010','DCN LAB','11:15:00','13:05:00','SATURDAY',5,'B'),('BMSIS010','MAD LAB','11:15:00','13:05:00','THURSDAY',7,'B'),('BMSIS010','COA','12:10:00','13:05:00','FRIDAY',3,'A'),('BMSIS010','COA','12:10:00','13:05:00','TUESDAY',3,'A'),('BMSIS010','DCN LAB','14:00:00','15:50:00','THURSDAY',5,'A'),('BMSIS010','WP LAB','14:00:00','15:50:00','TUESDAY',3,'A'),('BMSIS011','COA','08:55:00','09:50:00','FRIDAY',3,'B'),('BMSIS011','COA','08:55:00','09:50:00','WEDNESDAY',3,'B'),('BMSIS011','WPLAB','08:55:00','10:45:00','MONDAY',5,'B'),('BMSIS011','OOP LAB','08:55:00','10:45:00','THURSDAY',3,'A'),('BMSIS011','OOP','09:50:00','10:45:00','SATURDAY',3,'C'),('BMSIS011','OOP','09:50:00','10:45:00','TUESDAY',3,'C'),('BMSIS011','WP LAB','11:15:00','12:10:00','MONDAY',3,'C'),('BMSIS011','COA','12:10:00','13:05:00','TUESDAY',3,'B'),('BMSIS011','OOP','12:10:00','13:05:00','WEDNESDAY',3,'C'),('BMSIS011','OOP LAB','14:00:00','15:50:00','THURSDAY',3,'C'),('BMSIS011','WP LAB','14:00:00','15:50:00','TUESDAY',3,'A'),('BMSIS011','WP LAB','14:00:00','15:50:00','WEDNESDAY',3,'B'),('BMSIS012','IE','08:55:00','09:50:00','WEDNESDAY',7,'A'),('BMSIS012','OS TUTOR','08:55:00','10:45:00','MONDAY',3,'B'),('BMSIS012','MAD LAB','08:55:00','10:45:00','SATURDAY',7,'A'),('BMSIS012','OOP LAB','08:55:00','10:45:00','THURSDAY',3,'A'),('BMSIS012','OS','11:15:00','12:10:00','FRIDAY',3,'A'),('BMSIS012','OS','11:15:00','12:10:00','THURSDAY',3,'A'),('BMSIS012','IE','11:15:00','13:05:00','SATURDAY',7,'A'),('BMSIS012','OS','12:10:00','13:05:00','MONDAY',3,'A'),('BMSIS012','OOP LAB','14:00:00','15:50:00','MONDAY',3,'B'),('BMSIS012','OS TUTOR','14:00:00','15:50:00','TUESDAY',3,'C'),('BMSIS012','OS TUTOR','14:00:00','15:50:00','WEDNESDAY',3,'A'),('BMSIS013','ICL','08:55:00','09:50:00','MONDAY',7,'B'),('BMSIS013','MC LAB','08:55:00','10:45:00','THURSDAY',7,'B'),('BMSIS013','ICL','09:50:00','10:45:00','FRIDAY',7,'B'),('BMSIS013','ICL','09:50:00','10:45:00','TUESDAY',7,'B'),('BMSIS013','DCN','11:15:00','12:10:00','TUESDAY',5,'B'),('BMSIS013','WP LAB','11:15:00','13:05:00','MONDAY',3,'C'),('BMSIS013','DCN LAB','11:15:00','13:05:00','SATURDAY',5,'B'),('BMSIS013','DCN','12:10:00','13:05:00','FRIDAY',5,'B'),('BMSIS013','DCN TUTOR','14:00:00','15:50:00','MONDAY',5,'B'),('BMSIS013','DCN LAB','14:00:00','15:50:00','THURSDAY',5,'A'),('BMSIS013','WP LAB','14:00:00','15:50:00','TUESDAY',3,'A'),('BMSIS013','WP LAB','14:00:00','15:50:00','WEDNESDAY',3,'B'),('BMSIS014','COA','08:55:00','09:50:00','SATURDAY',3,'C'),('BMSIS014','WP LAB','08:55:00','10:45:00','MONDAY',5,'B'),('BMSIS014','MC LAB','08:55:00','10:45:00','THURSDAY',7,'B'),('BMSIS014','DBMS','09:50:00','10:45:00','TUESDAY',5,'B'),('BMSIS014','COA','09:50:00','10:45:00','WEDNESDAY',3,'C'),('BMSIS014','DBMS','11:15:00','12:10:00','FRIDAY',5,'B'),('BMSIS014','COA','11:15:00','12:10:00','THURSDAY',3,'C'),('BMSIS014','DBMS','11:15:00','12:10:00','WEDNESDAY',5,'B'),('BMSIS014','DBMS LAB','11:15:00','13:05:00','TUESDAY',5,'A'),('BMSIS014','DBMS LAB','14:00:00','15:50:00','FRIDAY',5,'B'),('BMSIS014','DS LAB','14:00:00','15:50:00','MONDAY',3,'C'),('BMSIS015','DD','08:55:00','09:50:00','FRIDAY',3,'C'),('BMSIS015','DS LAB','08:55:00','10:45:00','SATURDAY',3,'A'),('BMSIS015','AI','08:55:00','10:45:00','THURSDAY',5,'A'),('BMSIS015','AI LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS015','DD','11:15:00','12:10:00','SATURDAY',3,'C'),('BMSIS015','DBMS LAB','11:15:00','13:05:00','TUESDAY',5,'A'),('BMSIS015','CCP LAB','11:15:00','13:05:00','WEDNESDAY',1,'H'),('BMSIS015','AI','12:10:00','13:05:00','MONDAY',5,'A'),('BMSIS015','DBMS LAB','14:00:00','15:50:00','FRIDAY',5,'B'),('BMSIS015','DD TUTOR','14:00:00','15:50:00','TUESDAY',3,'B'),('BMSIS015','DD TUTOR','14:00:00','15:50:00','WEDNESDAY',3,'C'),('BMSIS016','MC','08:55:00','09:50:00','FRIDAY',7,'B'),('BMSIS016','CCP LAB','08:55:00','09:50:00','MONDAY',1,'N'),('BMSIS016','CCP','08:55:00','09:50:00','SATURDAY',1,'H'),('BMSIS016','MC LAB','08:55:00','10:45:00','THURSDAY',7,'B'),('BMSIS016','MC','09:50:00','10:45:00','WEDNESDAY',7,'B'),('BMSIS016','MC','11:15:00','12:10:00','MONDAY',7,'B'),('BMSIS016','CCP','11:15:00','13:05:00','FRIDAY',1,'H'),('BMSIS016','CCP LAB','11:15:00','13:05:00','SATURDAY',1,'K'),('BMSIS016','DS LAB','11:15:00','13:05:00','THURSDAY',3,'B'),('BMSIS016','MC LAB','11:15:00','13:05:00','TUESDAY',7,'A'),('BMSIS016','CCP LAB','11:15:00','13:05:00','WEDNESDAY',1,'H'),('BMSIS017','JAVA LAB','08:55:00','10:45:00','FRIDAY',5,'B'),('BMSIS017','PYTHON','08:55:00','10:45:00','THURSDAY',5,'A'),('BMSIS017','JAVA LAB','08:55:00','10:45:00','TUESDAY',5,'A'),('BMSIS017','PYTHON LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS017','JAVA','11:15:00','12:10:00','SATURDAY',5,'A'),('BMSIS017','CCP LAB','11:15:00','13:05:00','TUESDAY',1,'G'),('BMSIS017','CCP LAB','11:15:00','13:05:00','WEDNESDAY',1,'H'),('BMSIS017','PYTHON','12:10:00','13:05:00','MONDAY',5,'A'),('BMSIS017','JAVA','12:10:00','13:05:00','THURSDAY',5,'A'),('BMSIS017','DBMS LAB','14:00:00','15:50:00','FRIDAY',5,'B'),('BMSIS017','JAVA','14:05:00','15:50:00','TUESDAY',1,'G'),('BMSIS018','OS','08:55:00','09:50:00','THURSDAY',3,'B'),('BMSIS018','JAVA LAB','08:55:00','10:45:00','FRIDAY',5,'B'),('BMSIS018','OS TUTOR','08:55:00','10:45:00','MONDAY',3,'B'),('BMSIS018','JAVA LAB','08:55:00','10:45:00','TUESDAY',5,'A'),('BMSIS018','OS','09:50:00','13:05:00','SATURDAY',3,'B'),('BMSIS018','DCN LAB','11:15:00','10:45:00','SATURDAY',5,'B'),('BMSIS018','JAVA','11:15:00','12:10:00','MONDAY',5,'B'),('BMSIS018','JAVA','11:15:00','12:10:00','THURSDAY',5,'B'),('BMSIS018','WP LAB','11:15:00','13:05:00','FRIDAY',5,'A'),('BMSIS018','JAVA','12:10:00','13:05:00','TUESDAY',5,'B'),('BMSIS018','OS','12:10:00','13:05:00','WEDNESDAY',3,'B'),('BMSIS018','OS TUTOR','14:00:00','15:50:00','WEDNESDAY',3,'A'),('BMSIS019','WP LAB','11:15:00','13:05:00','MONDAY',3,'C'),('BMSIS019','WP LAB','14:00:00','15:50:00','TUESDAY',3,'A'),('BMSIS019','WP LAB','14:00:00','15:50:00','WEDNESDAY',3,'B'),('BMSIS020','CCP','08:55:00','10:45:00','FRIDAY',1,'J'),('BMSIS020','DS LAB','08:55:00','10:45:00','SATURDAY',3,'A'),('BMSIS020','CCP LAB','08:55:00','10:45:00','THURSDAY',1,'J'),('BMSIS020','CCP','08:55:00','10:45:00','TUESDAY',1,'K'),('BMSIS020','PYTHON LAB','08:55:00','10:45:00','WEDNESDAY',1,'G'),('BMSIS020','CCP LAB','11:15:00','13:05:00','FRIDAY',1,'L'),('BMSIS020','CCP LAB','11:15:00','13:05:00','SATURDAY',1,'K'),('BMSIS020','CCP LAB','11:15:00','13:05:00','TUESDAY',1,'G'),('BMSIS020','CCP','12:10:00','13:05:00','THURSDAY',1,'J'),('BMSIS020','CCP','12:10:00','13:05:00','WEDNESDAY',1,'K'),('BMSIS020','CCP LAB','14:00:00','15:50:00','WEDNESDAY',1,'M'),('BMSIS021','DS','09:50:00','10:45:00','THURSDAY',3,'B'),('BMSIS021','DS','11:15:00','12:10:00','FRIDAY',3,'B'),('BMSIS021','DS','11:15:00','12:10:00','TUESDAY',3,'B'),('BMSIS024','MC','08:55:00','10:45:00','FRIDAY',7,'A'),('BMSIS024','CCP LAB','08:55:00','10:45:00','MONDAY',1,'N'),('BMSIS024','DS LAB','08:55:00','10:45:00','SATURDAY',3,'A'),('BMSIS024','DM ','08:55:00','10:45:00','THURSDAY',5,'A'),('BMSIS024','DM LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS024','MC','09:50:00','10:45:00','TUESDAY',7,'A'),('BMSIS024','CCP LAB','09:50:00','10:45:00','WEDNESDAY',1,'H'),('BMSIS024','CCP LAB','11:15:00','13:05:00','FRIDAY',1,'L'),('BMSIS024','CCPLAB','11:15:00','13:05:00','SATURDAY',1,'K'),('BMSIS024','DS LAB','11:15:00','13:05:00','THURSDAY',3,'B'),('BMSIS024','MC LAB','11:15:00','13:05:00','TUESDAY',7,'A'),('BMSIS024','DM','12:10:00','13:05:00','MONDAY',5,'A'),('BMSIS024','OOP LAB','14:00:00','15:50:00','THURSDAY',3,'C'),('BMSIS024','CCP LAB','14:00:00','15:50:00','WEDNESDAY',1,'M'),('BMSIS025','CCP LAB','08:55:00','10:45:00','THURSDAY',1,'J'),('BMSIS025','JAVA LAB','08:55:00','10:45:00','TUESDAY',5,'A'),('BMSIS025','PYTHON LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS025','OS','09:50:00','10:45:00','FRIDAY',3,'C'),('BMSIS025','OS','09:50:00','10:45:00','MONDAY',3,'C'),('BMSIS025','OS','11:15:00','12:10:00','TUESDAY',3,'C'),('BMSIS025','CCP LAB','11:15:00','13:05:00','FRIDAY',1,'L'),('BMSIS025','CCP','11:15:00','13:05:00','SATURDAY',1,'L'),('BMSIS025','MAD LAB','11:15:00','13:05:00','THURSDAY',7,'B'),('BMSIS025','CCP','12:10:00','13:05:00','WEDNESDAY',1,'L'),('BMSIS025','DBMS LAB','14:00:00','15:50:00','FRIDAY',5,'B'),('BMSIS025','OOP LAB','14:00:00','15:50:00','MONDAY',3,'B'),('BMSIS025','OS TUTOR','14:00:00','15:50:00','TUESDAY',3,'C'),('BMSIS025','CCP LAB','14:00:00','15:50:00','WEDNESDAY',1,'M'),('BMSIS026','FDS','08:55:00','09:50:00','TUESDAY',7,'A'),('BMSIS026','CCP LAB','08:55:00','10:45:00','MONDAY',1,'N'),('BMSIS026','DS LAB','08:55:00','10:45:00','SATURDAY',3,'A'),('BMSIS026','DM LAB','08:55:00','10:45:00','WEDNESDAY',5,'A'),('BMSIS026','CCP','11:15:00','12:10:00','WEDNESDAY',1,'M'),('BMSIS026','FDS','11:15:00','13:05:00','FRIDAY',7,'A'),('BMSIS026','CCP LAB','11:15:00','13:05:00','SATURDAY',1,'K'),('BMSIS026','DS LAB','11:15:00','13:05:00','THURSDAY',3,'B'),('BMSIS026','CCP LAB','11:15:00','13:05:00','TUESDAY',1,'G'),('BMSIS026','OOP LAB','14:00:00','15:50:00','MONDAY',3,'B'),('BMSIS026','DCN LAB','14:00:00','15:50:00','THURSDAY',5,'A'),('BMSIS026','CCP LAB','14:00:00','15:50:00','WEDNESDAY',1,'M');
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbmsproject'
--

--
-- Dumping routines for database 'dbmsproject'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 14:45:57
