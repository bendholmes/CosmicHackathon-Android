# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: bdholmes.com (MySQL 5.5.37-0ubuntu0.12.04.1)
# Database: bdholmes
# Generation Time: 2014-05-31 10:28:50 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table cosmic_answers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_answers`;

CREATE TABLE `cosmic_answers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `value` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_answers` WRITE;
/*!40000 ALTER TABLE `cosmic_answers` DISABLE KEYS */;

INSERT INTO `cosmic_answers` (`id`, `name`, `value`)
VALUES
	(1,'Yes','1'),
	(2,'No','0');

/*!40000 ALTER TABLE `cosmic_answers` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_cards
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_cards`;

CREATE TABLE `cosmic_cards` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_cards` WRITE;
/*!40000 ALTER TABLE `cosmic_cards` DISABLE KEYS */;

INSERT INTO `cosmic_cards` (`id`, `name`, `image`)
VALUES
	(1,'Yes','http://bellacaledonia.files.wordpress.com/2012/05/yes.jpg');

/*!40000 ALTER TABLE `cosmic_cards` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_questions
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_questions`;

CREATE TABLE `cosmic_questions` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_questions` WRITE;
/*!40000 ALTER TABLE `cosmic_questions` DISABLE KEYS */;

INSERT INTO `cosmic_questions` (`id`, `title`, `description`, `type`)
VALUES
	(1,'Is Ben Awesome?','We all know the answer !!!!!!!',0);

/*!40000 ALTER TABLE `cosmic_questions` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_question_answers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_question_answers`;

CREATE TABLE `cosmic_question_answers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `answer_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_question_answers` WRITE;
/*!40000 ALTER TABLE `cosmic_question_answers` DISABLE KEYS */;

INSERT INTO `cosmic_question_answers` (`id`, `answer_id`, `question_id`, `card_id`)
VALUES
	(1,1,1,1);

/*!40000 ALTER TABLE `cosmic_question_answers` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_quiz
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_quiz`;

CREATE TABLE `cosmic_quiz` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_quiz` WRITE;
/*!40000 ALTER TABLE `cosmic_quiz` DISABLE KEYS */;

INSERT INTO `cosmic_quiz` (`id`, `name`, `description`)
VALUES
	(1,'Cosmic Quiz','Help us gather feedback about your experience with Cosmic :)');

/*!40000 ALTER TABLE `cosmic_quiz` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_quiz_questions
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_quiz_questions`;

CREATE TABLE `cosmic_quiz_questions` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `quiz_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_quiz_questions` WRITE;
/*!40000 ALTER TABLE `cosmic_quiz_questions` DISABLE KEYS */;

INSERT INTO `cosmic_quiz_questions` (`id`, `quiz_id`, `question_id`)
VALUES
	(1,1,1);

/*!40000 ALTER TABLE `cosmic_quiz_questions` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_user_answers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_user_answers`;

CREATE TABLE `cosmic_user_answers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `quiz_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_user_answers` WRITE;
/*!40000 ALTER TABLE `cosmic_user_answers` DISABLE KEYS */;

INSERT INTO `cosmic_user_answers` (`id`, `user_id`, `question_id`, `card_id`, `answer_id`, `quiz_id`)
VALUES
	(1,1,1,1,1,1);

/*!40000 ALTER TABLE `cosmic_user_answers` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cosmic_users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cosmic_users`;

CREATE TABLE `cosmic_users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `cosmic_users` WRITE;
/*!40000 ALTER TABLE `cosmic_users` DISABLE KEYS */;

INSERT INTO `cosmic_users` (`id`, `name`, `age`)
VALUES
	(1,'Ben',4);

/*!40000 ALTER TABLE `cosmic_users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
