CREATE DATABASE IF NOT EXISTS Skindbuksen;

CREATE TABLE IF NOT EXISTS Skindbuksen.menukort (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `navn` varchar(50) NOT NULL,
  `pris` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `navn` (`navn`)
);

CREATE TABLE IF NOT EXISTS Skindbuksen.bestillinger (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `retter` varchar(50) DEFAULT NULL,
  `totalpris` smallint(6) DEFAULT NULL,
  `bord` tinyint(4) DEFAULT NULL,
  `tidspunkt` smallint(6) DEFAULT NULL,
  `dato` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS Skindbuksen.reservationer (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `bord_nr` int(11) NOT NULL,
  `antal` int(11) NOT NULL DEFAULT '0',
  `tidspunkt` varchar(50) DEFAULT NULL,
  `dato` date DEFAULT NULL,
  `kunde_fornavn` varchar(50) DEFAULT NULL,
  `kunde_efternavn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`)
);

CREATE TABLE IF NOT EXISTS Skindbuksen.users (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`)
);