CREATE DATABASE  IF NOT EXISTS `event_directory`;
USE `event_directory`;


DROP TABLE IF EXISTS `events_table`;

CREATE TABLE `events_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_name` varchar(45) DEFAULT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `tickets_sold` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `events_table` VALUES 
	(1,'Dancing Queen','DM Studios', 190),
	(2,'Move Your Body','Studio One', 230),
	(3,'Pirates of Dreams','Dreams Theatre', 174);