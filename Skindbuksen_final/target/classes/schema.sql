CREATE DATABASE IF NOT EXISTS Skindbuksen;

CREATE TABLE IF NOT EXISTS Skindbuksen.menukort (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `navn` tinytext,
  `pris` tinyint(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS Skindbuksen.bestillinger (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `retter` varchar(50) DEFAULT NULL,
  `totalpris` smallint(6) unsigned DEFAULT NULL,
  `bord` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS Skindbuksen.reservationer (
  `reservationID` int(11) NOT NULL AUTO_INCREMENT,
  `bord_nr` int(11) NOT NULL,
  `antal` int(11) NOT NULL DEFAULT '0',
  `tidspunkt` varchar(50) DEFAULT NULL,
  `dato` date DEFAULT NULL,
  `fornavn` varchar(50) DEFAULT NULL,
  `efternavn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`reservationID`)
);


CREATE TABLE IF NOT EXISTS Skindbuksen.users (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `roles` varchar(20) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_username_roles` (`roles`,`username`)
);
