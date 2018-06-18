# SA46Team12CABProject
SA46 Team 12 Java EE Spring MVC Project for CAB System

This document provides supplementary information 
about the software on the following items:

1. Summary on Application
2. Scope of Application
3. User Login / Passwords
4. Troubleshoot
5. System Requirements
6. Android Configurations
7. Test Case Scripts
8. Authors

## 1. Summary on Application

### a. Members Access

Only members can access "My Accounts" and "Facilities Booking". Anonymous users do 
not have the rights and will be prompted to login if attempting to access the page.

### b. Admin Access

Admin have a custom navigation bar that allows them see reports and manage the 
business.

### c. Android 

Members can login and book facilities via the mobile application.

------------------


## 2. Scope of Application


### a. Home page

> Contact us form <br/>
> Information about Spring club<br/>

### b. Membership

> Selection of subscription<br/>
> Registration of user<br/>

### c. Facilities

> Anonymous can see all facilities<br/>
> Only members can book the facilities<br/>
> Unavailable / maintenance slots will be shown<br/>

### d. My Account

> User can manage subscription<br/>
> User can view all past and upcoming booking<br/>
> User can delete upcoming booking<br/>
> User can manage account information<br/>

### e. Reports

> Only admin can access<br/>
> Dashboard / charts of vital information<br/>
> Reports printable / viewable in PDF format<br/>

### f. Manage Facility

> Only admin can access<br/>
> Toggle facilities between active / not active<br/>
> Edit facilities information<br/>
> Add new facilities<br/>

### g. Manage User

> Only admin can access<br/>
> Edit user information<br/>

### h. Manage Booking

> Only admin can access<br/>
> Toggle between calendar / list view<br/>
> Book maintenance<br/>
> Manage maintenance<br/>
> Delete booking<br/>

### i. Android

> Only for members<br/>
> Login access<br/>
> Booking of facilities<br/>

### j. Others

> JUnit<br/>
	-> CRUD test on service classes<br/>
	-> Rollback database after test is done<br/>

> Scheduler<br/>
	-> Update of expired accounts at 12am daily<br/>

> Emails are sent when:<br/>
	-> Account is created<br/>
	-> Booking is made<br/>
	-> Booking is cancelled<br/>
	-> Account is expired<br/>
	-> Account is renewed<br/>


------------------


## 3. User Login / Passwords


Users can login using their email and password. <br/>

Some accessible ID / password are as follows:<br/>

User ID     Email                     Password<br/>
1           non@est.edu	              12345678      (Member)<br/>
30          springclub12@gmail.com    12345678      (Admin)<br/>


GMail Access :<br/>
-------------- 
User: springclub12@gmail.com<br/>
Pass: wearesa46team12<br/>

Emails are received from contact us form<br/>



------------------

3. Database setup


Database script is available in the folder: SQL Backup > team12cabproject.sql<br/>
Access to database password should be configured under: application.properties<br/>



------------------

## 4. Troubleshooting


When visiting the following website:<br/>

http://localhost:8080/springclub/facilities <br/>
http://localhost:8080/springclub/admin/calendar<br/>


The following error might occur:<br/>
com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: <br/>
Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated <br/>
column 'team12cabproject.facility0_.facilityid' which is not functionally dependent <br/>
on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by<br/>

Cause: <br/>
only_full_group_by restriction in MySQL Server.<br/>
	

Solution<br/>

1. Run this query -> SELECT @@GLOBAL.sql_mode;<br/>
	

2. If only_full_group_by is included in result, remove and update the sql_mode.<br/>
		
e.g. if select result returns this result <br/>
=> ONLY_FULL_GROUP_BY, STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,
ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION<br/>
		

Run this query => SET @@GLOBAL.sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,
NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';<br/>



------------------

## 5. System Requirements


Recommended Browser: <br/>

Google Chrome<br/>

Server:<br/>

Tomcat v8.5<br/>

Datebase:

MySQL Server<br/>



------------------

## 6. Android Configuration

1.	Install XAMPP on: https://www.apachefriends.org/download.html<br/>
2.	Add the PHP files' SpringClub folder to XAMPP htdocs folder<br/>
3.	Start Apache and MySQL<br/>
4.	Open MySQL<br/>
5.	Open Android Studio<br/>
6.	Change the IP address of the HttpUrls in the activities java files to your
	computer IP's address<br/>
7.	Run the app<br/>

--IMPORTANT NOTES:
Ensure that every facilityid in the database is associated with a maintenance id.<br/>
Whenever a new facility is created, a new maintenanceid with the new facility id <br/>
will need to be created as well so that it is possible to join the table <br/>
between bookingdetails and subscriptions as the Query in the getTimeslots.php is :<br/>
	$sql1 = "SELECT * FROM bookingdetails bd, maintenances m where <br/>
	bd.facilityid = m.facilityid and m.facilityid = $selectedFacilityId";<br/>

--Sample SQL Query to insert dummy maintenanceid <br/>
(Replace 1 for the value of the facilityid, active will be 0 so that there<br/> 
will be no impact on the availability of the faciltily):<br/>
INSERT INTO `team12cabproject`.`maintenances` (`maintenanceid`, `facilityid`, 
`startdate`, `enddate`, `timestartid`, `timeendid`, `active`) 
VALUES ('8', '1', '2018-06-18', '2018-06-18', '1', '2', '0');<br/>



------------------

## 7. Test Case Scripts

First visit this link fist - http://localhost:8080/springclub/<br/>
Play the test cases in order as the following order<br/>
1. User Registration Test Case
2. Anonymous User Facility Booking Test Case
3. Login Validation Test Case
4. Facility Booking Test Case
5. Edit Profile Test Case
6. User Overall Test Case
7. Admin Overall Test Case



------------------


## 8. Authors
	
GDIP SA 46 Team 12 (NUS ISS)<br/>
CHIRAG SHETTY<br/>
HENDRI SETIA WARDANA<br/>
LIM HOE KIT<br/>
ONG WEI TING<br/>
PEH GUEK LAN<br/>
WONG WEI JIE<br/>
ZIN MIN HTET
<br/>
