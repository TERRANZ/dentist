/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.1.61-2-log : Database - dentist
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dentist` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dentist`;

/*Table structure for table `appointment` */

DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `app_date` date DEFAULT NULL,
  `pat_id` int(11) NOT NULL,
  `diag_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  PRIMARY KEY (`app_id`),
  KEY `R_1` (`pat_id`),
  KEY `R_2` (`diag_id`),
  KEY `R_3` (`comment_id`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`pat_id`) REFERENCES `patient` (`pat_id`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`diag_id`) REFERENCES `diagnosis` (`diag_id`),
  CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT;

/*Data for the table `appointment` */

insert  into `appointment`(`app_id`,`app_date`,`pat_id`,`diag_id`,`comment_id`) values (1,'2012-04-08',1,1,1),(2,'2012-04-08',1,1,5),(3,'2012-04-08',1,1,8),(4,'2012-04-08',1,1,9),(5,'2012-04-08',1,4,12),(6,'2012-04-08',2,1,13);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_date` date DEFAULT NULL,
  `comment_title` varchar(100) DEFAULT NULL,
  `comment_text` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT;

/*Data for the table `comment` */

insert  into `comment`(`comment_id`,`comment_date`,`comment_title`,`comment_text`) values (1,'2012-04-08',NULL,'фцвфцв'),(2,'2012-04-08',NULL,''),(3,'2012-04-08',NULL,'фцвфцв'),(4,'2012-04-08',NULL,''),(5,'2012-04-08',NULL,''),(6,'2012-04-08',NULL,'фцвфвфцв'),(7,'2012-04-08',NULL,''),(8,'2012-04-08',NULL,''),(9,'2012-04-08',NULL,''),(10,'2012-04-08',NULL,''),(11,'2012-04-08',NULL,'awdawdawd'),(12,'2012-04-08',NULL,'awdawdawd'),(13,'2012-04-08',NULL,'awdawd');

/*Table structure for table `diagnosis` */

DROP TABLE IF EXISTS `diagnosis`;

CREATE TABLE `diagnosis` (
  `diag_id` int(11) NOT NULL AUTO_INCREMENT,
  `diag_code` varchar(20) NOT NULL,
  `diag_name` varchar(200) DEFAULT NULL,
  `diag_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`diag_id`,`diag_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT;

/*Data for the table `diagnosis` */

insert  into `diagnosis`(`diag_id`,`diag_code`,`diag_name`,`diag_price`) values (1,'','Удаление зуба',20),(2,'123','Пародонтит',0),(3,'546456','Пломбирование',1231230),(4,'123123','Чистка канала',1231230),(5,'456456','Протезирование',1231230);

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `pat_id` int(11) NOT NULL AUTO_INCREMENT,
  `pat_num` int(11) DEFAULT NULL,
  `pat_surname` varchar(100) DEFAULT NULL,
  `pat_name` varchar(100) DEFAULT NULL,
  `pat_midname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT;

/*Data for the table `patient` */

insert  into `patient`(`pat_id`,`pat_num`,`pat_surname`,`pat_name`,`pat_midname`) values (1,1,'Иванов','Иван','Иванович'),(2,20,'Петров','Петр','Петрович'),(3,230,'Сидоров','Сидор','Сидорович'),(4,2130,'Денисов','Денис','Денисович');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
