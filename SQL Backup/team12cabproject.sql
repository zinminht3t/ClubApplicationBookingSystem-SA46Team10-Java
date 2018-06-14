-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: team12cabproject
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `bookingdetails`
--

CREATE DATABASE team12cabproject;
USE team12cabproject;


DROP TABLE IF EXISTS `bookingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookingdetails` (
  `bookingid` int(11) NOT NULL,
  `facilityid` int(11) NOT NULL,
  `timeslotid` int(11) NOT NULL,
  `bookingdate` date NOT NULL,
  `bookingprice` double NOT NULL,
  PRIMARY KEY (`bookingid`,`facilityid`,`timeslotid`),
  KEY `facilityid_idx` (`facilityid`),
  KEY `fk_____timeslotid` (`timeslotid`),
  CONSTRAINT `bookingdetails_timeslots_timeslotid_fk` FOREIGN KEY (`timeslotid`) REFERENCES `timeslots` (`timeslotid`),
  CONSTRAINT `bookingid` FOREIGN KEY (`bookingid`) REFERENCES `bookings` (`bookingid`),
  CONSTRAINT `facilityid` FOREIGN KEY (`facilityid`) REFERENCES `facilities` (`facilityid`),
  CONSTRAINT `fk_____timeslotid` FOREIGN KEY (`timeslotid`) REFERENCES `timeslots` (`timeslotid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingdetails`
--

LOCK TABLES `bookingdetails` WRITE;
/*!40000 ALTER TABLE `bookingdetails` DISABLE KEYS */;
INSERT INTO `bookingdetails` VALUES (1,1,1,'2018-06-20',1),(1,1,2,'2018-06-20',1),(2,3,3,'2018-06-19',1),(3,1,5,'2018-07-20',1),(3,1,6,'2018-07-20',1),(3,1,7,'2018-07-20',1);
/*!40000 ALTER TABLE `bookingdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `transactiontime` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  `total` double NOT NULL,
  `status` varchar(200) NOT NULL,
  PRIMARY KEY (`bookingid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,'2018-06-14 23:12:04',1,2,'CONFIRMED'),(2,'2018-06-16 23:12:04',2,1,'CANCELLED'),(3,'2018-06-14 23:15:55',3,3,'CONFIRMED');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facilities` (
  `facilityid` int(11) NOT NULL AUTO_INCREMENT,
  `facilityname` varchar(200) NOT NULL,
  `court` varchar(45) DEFAULT NULL,
  `remark` varchar(10000) NOT NULL,
  `imagepath` varchar(200) DEFAULT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  `price` double DEFAULT NULL,
  PRIMARY KEY (`facilityid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES (1,'Swimming Pool','A','Boasting several olympic-sized swimming pools, the club is proud to be home to several award-winning swimmers who grew up in the blue waters here. In addition to these, several smaller pools are also available, perfect for spending a relaxing weekend in. The pools are free to use for all club members.','pool.png',1,1),(2,'Tennis Court','A','Tread the grass courts that world champion Angre Addessi once trained on. The club\'s modern facilities make it a favourite amongst active professional players and you too can bask in their glory as you volley shots either in our high-tech indoor courts, or in our majestic nature-influence outdoor ones.','tennis.png',1,1),(3,'Tennis Court','B','Tread the grass courts that world champion Angre Addessi once trained on. The club\'s modern facilities make it a favourite amongst active professional players and you too can bask in their glory as you volley shots either in our high-tech indoor courts, or in our majestic nature-influence outdoor ones.','tennis.png',1,1),(4,'Gym','A','Want some time to tone your muscles? How about a space to do your cardio in relative luxury? The club is host to several gyms that will allow members to pump their iron while still revel in the conveniences of modern society. From treadmills to bikes, from weight-assisting machines to a variety of free-weight challenges, the gyms at the club will serve any and all your indoor needs.','gym.png',1,1),(5,'Golf Range','A','When you just need a swing break, or doing some off-office -hours mingling, the club\'s golf greens provide a lush and invigorating atmosphere to putt about enjoy the brisk breeze abundant in this area. Boasting over 10000 sq ft of playable area, you will be hard pressed to find a more accommodating field for such activities.','golf.png',1,1);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintenances`
--

DROP TABLE IF EXISTS `maintenances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintenances` (
  `maintenanceid` int(11) NOT NULL AUTO_INCREMENT,
  `facilityid` int(11) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `timestartid` int(11) NOT NULL,
  `timeendid` int(11) NOT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`maintenanceid`),
  KEY `facilityid_idx` (`facilityid`),
  KEY `timeslotid_idx` (`timestartid`),
  KEY `timeslotid_idx1` (`timeendid`),
  CONSTRAINT `facilityidfk` FOREIGN KEY (`facilityid`) REFERENCES `facilities` (`facilityid`),
  CONSTRAINT `maintenances_timeslots_timeslotid_fk` FOREIGN KEY (`timeendid`) REFERENCES `timeslots` (`timeslotid`),
  CONSTRAINT `timeslotid` FOREIGN KEY (`timestartid`) REFERENCES `timeslots` (`timeslotid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintenances`
--

LOCK TABLES `maintenances` WRITE;
/*!40000 ALTER TABLE `maintenances` DISABLE KEYS */;
INSERT INTO `maintenances` VALUES (1,1,'2018-05-14','2018-05-15',1,12,1),(2,2,'2018-06-14','2018-06-14',1,12,1),(3,3,'2018-06-15','2018-06-15',1,12,1);
/*!40000 ALTER TABLE `maintenances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `new_view`
--

DROP TABLE IF EXISTS `new_view`;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `new_view` AS SELECT 
 1 AS `bookingid`,
 1 AS `bookingdate`,
 1 AS `minTimeslotId`,
 1 AS `maxTimeslotId`,
 1 AS `minTime`,
 1 AS `maxTime`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `subscriptionpackages`
--

DROP TABLE IF EXISTS `subscriptionpackages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriptionpackages` (
  `packageid` int(11) NOT NULL AUTO_INCREMENT,
  `packageyears` varchar(45) NOT NULL,
  `packageprice` double NOT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`packageid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptionpackages`
--

LOCK TABLES `subscriptionpackages` WRITE;
/*!40000 ALTER TABLE `subscriptionpackages` DISABLE KEYS */;
INSERT INTO `subscriptionpackages` VALUES (1,'1 Year',89.99,1),(2,'3 Years',249.99,1);
/*!40000 ALTER TABLE `subscriptionpackages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriptions` (
  `subid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `joindate` date NOT NULL,
  `expirydate` date NOT NULL,
  `packageid` int(11) NOT NULL,
  `active` tinyint(4) NOT NULL,
  PRIMARY KEY (`subid`),
  KEY `packageid_idx` (`packageid`),
  KEY `userid_idx` (`userid`),
  CONSTRAINT `fk_____packageid` FOREIGN KEY (`packageid`) REFERENCES `subscriptionpackages` (`packageid`),
  CONSTRAINT `fk____userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (8,1,'2018-06-14','2019-06-14',1,1),(9,2,'2018-06-14','2021-06-14',2,1),(10,3,'2018-06-14','2019-06-14',1,1),(11,4,'2018-06-14','2021-06-14',2,1),(12,5,'2018-06-14','2019-06-14',1,1),(13,6,'2018-06-14','2021-06-14',2,1),(14,7,'2018-06-14','2019-06-14',1,1),(15,8,'2018-06-14','2021-06-14',2,1),(16,9,'2018-06-14','2019-06-14',1,1),(17,10,'2018-06-14','2021-06-14',2,1),(18,11,'2018-06-14','2019-06-14',1,1),(19,12,'2018-06-14','2021-06-14',2,1),(20,13,'2018-06-14','2019-06-14',1,1),(21,14,'2018-06-14','2021-06-14',2,1),(22,15,'2018-06-14','2019-06-14',1,1),(23,16,'2018-06-14','2021-06-14',2,1),(24,17,'2018-06-14','2019-06-14',1,1),(25,18,'2018-06-14','2021-06-14',2,1),(26,19,'2018-06-14','2019-06-14',1,1),(27,20,'2018-06-14','2021-06-14',2,1),(28,21,'2018-06-14','2019-06-14',1,1),(29,22,'2018-06-14','2021-06-14',2,1),(30,23,'2018-06-14','2019-06-14',1,1),(31,24,'2018-06-14','2021-06-14',2,1),(32,25,'2018-06-14','2019-06-14',1,1),(33,26,'2018-06-14','2021-06-14',2,1),(34,27,'2018-06-14','2019-06-14',1,1),(35,28,'2018-06-14','2021-06-14',2,1),(36,29,'2018-06-14','2019-06-14',1,1);
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeslots`
--

DROP TABLE IF EXISTS `timeslots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timeslots` (
  `timeslotid` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(200) NOT NULL,
  PRIMARY KEY (`timeslotid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslots`
--

LOCK TABLES `timeslots` WRITE;
/*!40000 ALTER TABLE `timeslots` DISABLE KEYS */;
INSERT INTO `timeslots` VALUES (1,'09:00 - 10:00'),(2,'10:00 - 11:00'),(3,'11:00 - 12:00'),(4,'12:00 - 13:00'),(5,'13:00 - 14:00'),(6,'14:00 - 15:00'),(7,'15:00 - 16:00'),(8,'16:00 - 17:00'),(9,'17:00 - 18:00'),(10,'18:00 - 19:00'),(11,'19:00 - 20:00'),(12,'20:00 - 21:00');
/*!40000 ALTER TABLE `timeslots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `nric` varchar(45) NOT NULL,
  `dateofbirth` date NOT NULL,
  `address` varchar(200) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `contactno` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Leigh Foreman','non@est.edu','1654010112699','2000-05-18','8710 Donec St','female','908603132','12345678','member',1),(2,'Paula Owens','dui.nec.urna@auctorquistristique.com','1667060962099','1997-03-19','297-5114 Purus Avenue','female','060679111','12345678','member',1),(3,'Mason Mccall','eu.ultrices.sit@Morbi.com','1603022668899','1996-01-31','349-9101 Augue St.','male','390854878','12345678','member',1),(4,'Rooney Guerrero','risus.Donec@ut.net','1685093065699','2001-10-26','646-148 Interdum Avenue','male','541323919','12345678','member',1),(5,'Dominic Horton','tincidunt@malesuada.com','1603020899799','1988-07-28','P.O. Box 344, 200 Tristique Ave','male','680990801','12345678','member',1),(6,'Eden Underwood','tristique.senectus.et@Sedpharetrafelis.net','1678012892399','1985-12-23','2609 Pretium Road','male','919416514','12345678','member',1),(7,'Wallace Rodriquez','lacus.Nulla@nonhendrerit.edu','1621012101999','1994-10-14','448-2172 Consequat, Rd.','male','969380252','12345678','member',1),(8,'Amity Gilbert','at.pede.Cras@malesuadafamesac.ca','1653042243099','1986-05-05','728-9436 Netus Rd.','female','099691198','12345678','member',1),(9,'Darryl Fisher','cursus.Nunc.mauris@elit.org','1686031428799','1999-10-15','5196 Nunc Road','male','576985841','12345678','member',1),(10,'Keelie Blackburn','viverra@idantedictum.edu','1699072122499','1988-06-11','Ap #281-3879 A Rd.','male','389399428','12345678','member',1),(11,'Briar Guzman','justo.eu.arcu@Nuncsed.ca','1694092037399','1988-06-09','P.O. Box 133, 2482 Suspendisse Ave','female','097838547','12345678','member',1),(12,'Denton Knowles','velit.Aliquam.nisl@atvelit.co.uk','1645021567399','1986-11-21','Ap #454-647 In, Rd.','female','961217420','12345678','member',1),(13,'Porter Knowles','luctus.ut.pellentesque@tincidunt.com','1646031388499','1987-05-21','956-2016 Ut Road','male','346588765','12345678','member',1),(14,'Vielka Chen','mauris.eu.elit@eutemporerat.co.uk','1663080479199','1996-09-19','347-4026 Urna. Street','female','676230543','12345678','member',1),(15,'Perry Burt','dolor@Sedeget.com','1670092064499','1988-08-24','Ap #325-3193 Ut Ave','female','561593568','12345678','member',1),(16,'Alec Hudson','consectetuer.euismod.est@orciUtsemper.ca','1643040418599','1986-09-16','P.O. Box 741, 704 Duis Rd.','female','797452958','12345678','member',1),(17,'Latifah Scott','Proin.vel@Mauris.com','1656043023899','1988-10-15','P.O. Box 985, 1287 At Road','female','161182652','12345678','member',1),(18,'Thor Freeman','feugiat@magnaet.org','1692042916999','1998-09-02','482-4948 Nunc Avenue','female','156990895','12345678','member',1),(19,'Ali Nicholson','magna@quismassa.edu','1696061731399','1995-05-23','882-6874 Maecenas Ave','female','710298955','12345678','member',1),(20,'David Morse','in@nullaInteger.edu','1663042681499','2000-05-27','Ap #784-1650 Tristique Avenue','male','401783698','12345678','member',1),(21,'Brenda Wright','magna.Sed.eu@vel.co.uk','1627112801699','1991-10-25','6660 Ornare, Avenue','female','630729303','12345678','member',1),(22,'Sandra Roman','vitae.sodales.nisi@Aliquamnec.com','1690091237499','1999-06-21','1307 In Rd.','male','819733336','12345678','member',1),(23,'Craig Mcdonald','varius@risusvarius.com','1689062585399','1986-09-28','660-1874 Rutrum Rd.','male','674474813','12345678','member',1),(24,'Sade Bryan','pretium@necluctusfelis.org','1684082896299','2001-09-12','Ap #747-5054 Nisl. Av.','female','285915316','12345678','member',1),(25,'Jarrod Anderson','malesuada.fringilla@morbitristiquesenectus.edu','1621100296999','1997-11-12','825-555 Malesuada Rd.','female','969701112','12345678','member',1),(26,'Kelsey Charles','dolor@egestasligula.com','1668031576899','1987-03-25','Ap #487-8623 Non, Ave','male','257970418','12345678','member',1),(27,'Vincent Clements','nec@justoeu.ca','1689010599899','1999-12-04','P.O. Box 216, 1491 Dapibus Av.','female','640054478','12345678','member',1),(28,'Frances Francis','Aliquam.nec@enim.edu','1605120258299','2005-01-09','618-8130 Facilisis St.','male','531658407','12345678','member',1),(29,'Harper Bullock','sed.facilisis.vitae@justo.edu','1686050141299','1993-03-14','6042 Quis, Road','male','166393406','12345678','member',1),(30,'SpringClub Administrator','springclub12@gmail.com','1673121604599','1991-05-30','172-3845 Rutrum Street','male','125940217','12345678','admin',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `new_view`
--

/*!50001 DROP VIEW IF EXISTS `new_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_view` AS select `bkg`.`bookingid` AS `bookingid`,`bkg`.`bookingdate` AS `bookingdate`,`bkg`.`minTimeslotId` AS `minTimeslotId`,`bkg`.`maxTimeslotId` AS `maxTimeslotId`,`t1`.`time` AS `minTime`,`t2`.`time` AS `maxTime` from (((select `bookingdetails`.`bookingid` AS `bookingid`,`bookingdetails`.`bookingdate` AS `bookingdate`,min(`bookingdetails`.`timeslotid`) AS `minTimeslotId`,max(`bookingdetails`.`timeslotid`) AS `maxTimeslotId` from `bookingdetails` where `bookingdetails`.`bookingid` in (select `b`.`bookingid` from `bookings` `b` where (`b`.`status` like '%CONFIRMED%')) group by `bookingdetails`.`bookingid`) `bkg` left join `timeslots` `t1` on((`t1`.`timeslotid` = `bkg`.`minTimeslotId`))) left join `timeslots` `t2` on((`t2`.`timeslotid` = `bkg`.`maxTimeslotId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-14 23:22:13
