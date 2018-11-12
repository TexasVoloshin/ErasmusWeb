DROP DATABASE IF EXISTS `Erasmus`;
CREATE DATABASE `Erasmus` /*!40100 DEFAULT CHARACTER SET utf8 */;
DROP USER IF EXISTS 'user1'@'localhost';
CREATE USER 'user1'@'localhost' identified by 'user1_pass'; -- Creates the user
GRANT ALL ON Erasmus.* to 'user1'@'localhost'; -- Gives all the privileges to the new user on the newly created database

DROP TABLE IF EXISTS `Erasmus`.`role`;
CREATE TABLE  `Erasmus`.`role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Erasmus`.`user`;
CREATE TABLE  `Erasmus`.`user` (
  `id` int(11) NOT NULL auto_increment,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Erasmus`.`user_role`;
CREATE TABLE  `Erasmus`.`user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `user_role_key` (`role_id`),
  CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `Erasmus`.`user` (`id`),
  CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `Erasmus`.`role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Erasmus`.`persistent_logins`;
CREATE TABLE  `Erasmus`.`persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Erasmus`.`erasmusinfo`;
CREATE TABLE `Erasmus`.`erasmusinfo` (
  `user_id` int(11) NOT NULL,
  `ErasmusName` VARCHAR(45) NULL,
  `ErasmusSurname` VARCHAR(45) NULL,
  `ErasmusGender` VARCHAR(45) NULL,
  `ErasmusEmail` VARCHAR(45) NULL,
  `ErasmusTel` VARCHAR(45) NULL,
  `ErasmusCountry` VARCHAR(45) NULL,
  `ErasmusUni` VARCHAR(45) NULL,
  `ErasmusStudies` VARCHAR(45) NULL,
  `ErasmusFacultyAGH` VARCHAR(45) NULL,
  `ErasmusSupervisor` VARCHAR(45) NULL,
  `Dormitory` CHAR(3) NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `erasmusinfo_user` FOREIGN KEY (`user_id`) REFERENCES `Erasmus`.`user` (`id`)
  )
  ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT = 'Table contains personal information about Eramsus Student ';

DROP TABLE IF EXISTS `Erasmus`.`mentorinfo`;
CREATE TABLE `Erasmus`.`mentorinfo` (
  `user_id` int(11) NOT NULL,
  `MentorName` VARCHAR(45) NULL,
  `MentorSurname` VARCHAR(45) NULL,
  `MentorGender` VARCHAR(45) NULL,
  `MentorEmail` VARCHAR(45) NULL,
  `MentorTel` VARCHAR(45) NULL,
  `MentorStudies` VARCHAR(45) NULL,
  `MentorCountryOfErasmus` VARCHAR(45) NULL,
  `MentorFacultyAGH` VARCHAR(45) NULL,
  `MentorESN` CHAR(3) NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `mentorinfo_user` FOREIGN KEY (`user_id`) REFERENCES `Erasmus`.`user` (`id`)
  )
  ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT = 'Table contains personal information about Mentor Student ';

INSERT INTO `Erasmus`.`role` VALUES (1,'ADMIN');
INSERT INTO `Erasmus`.`role` VALUES (2,'ERASMUS');
INSERT INTO `Erasmus`.`role` VALUES (3,'MENTOR');

