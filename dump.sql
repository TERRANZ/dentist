/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.1.58-1-log : Database - terraobjects
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`terraobjects` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `terraobjects`;

/*Table structure for table `object` */

DROP TABLE IF EXISTS `object`;

CREATE TABLE `object` (
  `object_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_object_id` int(11) DEFAULT NULL,
  `object_template_id` int(11) DEFAULT NULL,
  `object_created_at` timestamp NULL DEFAULT NULL,
  `object_updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`object_id`),
  KEY `object_template_id` (`object_template_id`),
  CONSTRAINT `object_ibfk_1` FOREIGN KEY (`object_template_id`) REFERENCES `object_template` (`object_template_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT;

/*Data for the table `object` */

insert  into `object`(`object_id`,`parent_object_id`,`object_template_id`,`object_created_at`,`object_updated_at`) values (1,0,1,'2011-12-04 00:00:00','2011-12-04 00:00:00');

/*Table structure for table `object_prop_list` */

DROP TABLE IF EXISTS `object_prop_list`;

CREATE TABLE `object_prop_list` (
  `object_property_list_id` int(11) NOT NULL AUTO_INCREMENT,
  `list_id` int(11) NOT NULL,
  `object_id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`object_property_list_id`,`object_id`),
  KEY `object_id` (`object_id`),
  CONSTRAINT `object_prop_list_ibfk_1` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `object_prop_list` */

/*Table structure for table `object_props` */

DROP TABLE IF EXISTS `object_props`;

CREATE TABLE `object_props` (
  `object_props_id` int(11) NOT NULL AUTO_INCREMENT,
  `object_id` int(11) NOT NULL,
  `prop_id` int(11) NOT NULL,
  `intval` int(11) DEFAULT NULL,
  `floatval` float DEFAULT NULL,
  `strval` varchar(256) DEFAULT NULL,
  `textval` varchar(500) DEFAULT NULL,
  `dateval` datetime DEFAULT NULL,
  `listval` int(11) DEFAULT NULL,
  PRIMARY KEY (`object_props_id`,`object_id`,`prop_id`),
  KEY `R_1` (`object_id`),
  KEY `R_16` (`prop_id`),
  CONSTRAINT `object_props_ibfk_1` FOREIGN KEY (`object_id`) REFERENCES `object` (`object_id`),
  CONSTRAINT `object_props_ibfk_2` FOREIGN KEY (`prop_id`) REFERENCES `property` (`prop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `object_props` */

insert  into `object_props`(`object_props_id`,`object_id`,`prop_id`,`intval`,`floatval`,`strval`,`textval`,`dateval`,`listval`) values (11,1,1,0,NULL,NULL,NULL,NULL,NULL),(12,1,2,0,NULL,NULL,NULL,NULL,NULL),(13,1,3,NULL,NULL,'Коростелев',NULL,NULL,NULL),(14,1,4,NULL,NULL,'Вадим',NULL,NULL,NULL),(15,1,5,NULL,NULL,'Евгеньевич',NULL,NULL,NULL);

/*Table structure for table `object_template` */

DROP TABLE IF EXISTS `object_template`;

CREATE TABLE `object_template` (
  `object_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `Object_Template_Name` varchar(20) DEFAULT NULL,
  `parent_object_template_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`object_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT;

/*Data for the table `object_template` */

insert  into `object_template`(`object_template_id`,`Object_Template_Name`,`parent_object_template_id`) values (1,'Пациент',NULL),(2,'Диагноз',NULL),(3,'Приём',NULL),(4,'Заметки',NULL);

/*Table structure for table `object_template_props` */

DROP TABLE IF EXISTS `object_template_props`;

CREATE TABLE `object_template_props` (
  `object_template_id` int(11) NOT NULL,
  `prop_id` int(11) NOT NULL,
  `object_template_props_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`object_template_props_id`),
  KEY `R_18` (`object_template_id`),
  KEY `R_19` (`prop_id`),
  CONSTRAINT `object_template_props_ibfk_1` FOREIGN KEY (`object_template_id`) REFERENCES `object_template` (`object_template_id`),
  CONSTRAINT `object_template_props_ibfk_2` FOREIGN KEY (`prop_id`) REFERENCES `property` (`prop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `object_template_props` */

insert  into `object_template_props`(`object_template_id`,`prop_id`,`object_template_props_id`) values (1,1,1),(1,2,2),(1,3,3),(1,4,4),(1,5,5),(2,1,6),(2,10,7),(2,11,8),(2,12,9),(3,1,10),(3,6,11),(3,13,12),(3,14,13),(3,15,14),(4,1,15),(4,7,16),(4,8,17),(4,9,18);

/*Table structure for table `prop_type` */

DROP TABLE IF EXISTS `prop_type`;

CREATE TABLE `prop_type` (
  `prop_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `prop_type_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`prop_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `prop_type` */

insert  into `prop_type`(`prop_type_id`,`prop_type_name`) values (1,'Строка'),(2,'Целое число'),(3,'Дробеое число'),(4,'Заметка'),(5,'Дата'),(6,'Список');

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `prop_id` int(11) NOT NULL AUTO_INCREMENT,
  `prop_type_id` int(11) NOT NULL,
  `prop_defvalue` varchar(20) DEFAULT NULL,
  `prop_name` varchar(20) NOT NULL DEFAULT 'unnamed',
  PRIMARY KEY (`prop_id`),
  KEY `R_11` (`prop_type_id`),
  CONSTRAINT `property_ibfk_1` FOREIGN KEY (`prop_type_id`) REFERENCES `prop_type` (`prop_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `property` */

insert  into `property`(`prop_id`,`prop_type_id`,`prop_defvalue`,`prop_name`) values (1,2,NULL,'id'),(2,2,NULL,'номер пациента'),(3,1,NULL,'Фамилия'),(4,1,NULL,'Имя'),(5,1,NULL,'Отчество'),(6,5,NULL,'дата приёма'),(7,5,NULL,'дата заметки'),(8,1,NULL,'заголовок'),(9,1,NULL,'текст заметки'),(10,1,NULL,'наименование диагноз'),(11,2,NULL,'цена за диагноз'),(12,1,NULL,'код диагноза'),(13,2,NULL,'id пациент'),(14,2,NULL,'id диагноза'),(15,2,NULL,'id заметки');

/* Procedure structure for procedure `create_obj_prop` */

/*!50003 DROP PROCEDURE IF EXISTS  `create_obj_prop` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `create_obj_prop`(templ_id INT,obj_id INT)
BEGIN
	DECLARE no_more_props INT DEFAULT 0;
	DECLARE prop INT DEFAULT 0;	
	DECLARE props_cur CURSOR FOR SELECT prop_id FROM object_template_props WHERE object_template_id = templ_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET no_more_props = 1;	
	
	OPEN props_cur;
	FETCH props_cur INTO prop;
	REPEAT
		INSERT INTO `object_props` (`object_id`,`prop_id`) VALUES (obj_id,prop);
	FETCH props_cur INTO prop;		
	UNTIL no_more_props = 1
	end repeat;
	CLOSE props_cur;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
