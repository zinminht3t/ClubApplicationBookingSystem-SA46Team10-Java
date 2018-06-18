# SA46Team12CABProject
SA46 Team 12 Java EE Spring MVC Project for CAB System

This document provides supplementary information 
about the software on the following items:

## 1. Summary on Application
## 2. Scope of Application
## 3. User Login / Passwords
## 4. Troubleshoot
## 5. System Requirements
## 6. Android Configurations
## 7. Test Case Scripts
## 8. Authors

## 1. Summary on Application


### a. Members Access
------------------
Only members can access "My Accounts" and "Facilities Booking". Anonymous users do 
not have the rights and will be prompted to login if attempting to access the page.

### b. Admin Access
------------------
Admin have a custom navigation bar that allows them see reports and manage the 
business.

### c. Android 
------------------
Members can login and book facilities via the mobile application.

## 2. Scope of Application


### a. Home page
------------------
> Contact us form
> Information about Spring club

### b. Membership
------------------
> Selection of subscription
> Registration of user

### c. Facilities
------------------
> Anonymous can see all facilities
> Only members can book the facilities
> Unavailable / maintenance slots will be shown

### d. My Account
------------------
> User can manage subscription
> User can view all past and upcoming booking
> User can delete upcoming booking
> User can manage account information

### e. Reports
------------------
> Only admin can access
> Dashboard / charts of vital information
> Reports printable / viewable in PDF format

### f. Manage Facility
------------------
> Only admin can access
> Toggle facilities between active / not active
> Edit facilities information
> Add new facilities

### g. Manage User
------------------
> Only admin can access
> Edit user information

### h. Manage Booking
------------------
> Only admin can access
> Toggle between calendar / list view
> Book maintenance
> Manage maintenance
> Delete booking

### i. Android
-----------------
> Only for members
> Login access
> Booking of facilities

### j. Others
-----------------
> JUnit
	-> CRUD test on service classes
	-> Rollback database after test is done

> Scheduler
	-> Update of expired accounts at 12am daily

> Emails are sent when:
	-> Account is created
	-> Booking is made
	-> Booking is cancelled
	-> Account is expired
	-> Account is renewed


## 3. User Login / Passwords


Users can login using their email and password. 

Some accessible ID / password are as follows:

User ID     Email                     Password
1           non@est.edu	              12345678      (Member)
30          springclub12@gmail.com    12345678      (Admin)


GMail Access :
-------------- 
User: springclub12@gmail.com
Pass: wearesa46team12

Emails are received from contact us form


3. Database setup


Database script is available in the folder: SQL Backup > team12cabproject.sql
Access to database password should be configured under: application.properties


4. Troubleshooting


When visiting the following website:
--------------------
http://localhost:8080/springclub/facilities 
http://localhost:8080/springclub/admin/calendar


The following error might occur:
--------------------
com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: 
Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated 
column 'team12cabproject.facility0_.facilityid' which is not functionally dependent 
on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

Cause: 
only_full_group_by restriction in MySQL Server.
Solution : 
	

Solution
--------------------
1. Run this query -> SELECT @@GLOBAL.sql_mode;
	

2. If only_full_group_by is included in result, remove and update the sql_mode.
		
e.g. if select result returns this result 
=> ONLY_FULL_GROUP_BY, STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,
ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION
		

Run this query => SET @@GLOBAL.sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,
NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


5. System Requirements


Recommended Browser: 
--------------------
Google Chrome

Server:
--------------------
Tomcat v8.5


6. Android Configuration

1.	Install XAMPP on: https://www.apachefriends.org/download.html
2.	Add the PHP files' SpringClub folder to XAMPP htdocs folder
3.	Start Apache and MySQL
4.	Open MySQL
5.	Open Android Studio
6.	Change the IP address of the HttpUrls in the activities java files to your
	computer IP's address
7.	Run the app

--IMPORTANT NOTES:
Ensure that every facilityid in the database is associated with a maintenance id.
Whenever a new facility is created, a new maintenanceid with the new facility id 
will need to be created as well so that it is possible to join the table 
between bookingdetails and subscriptions as the Query in the getTimeslots.php is :
	$sql1 = "SELECT * FROM bookingdetails bd, maintenances m where 
	bd.facilityid = m.facilityid and m.facilityid = $selectedFacilityId";

--Sample SQL Query to insert dummy maintenanceid 
(Replace 1 for the value of the facilityid, active will be 0 so that there 
will be no impact on the availability of the faciltily):
INSERT INTO `team12cabproject`.`maintenances` (`maintenanceid`, `facilityid`, 
`startdate`, `enddate`, `timestartid`, `timeendid`, `active`) 
VALUES ('8', '1', '2018-06-18', '2018-06-18', '1', '2', '0');


7. Test Case Scripts

First visit this link fist - http://localhost:8080/springclub/
Play the test cases in order as the following order
1. User Registration Test Case
2. Anonymous User Facility Booking Test Case
3. Login Validation Test Case
4. Facility Booking Test Case
5. Edit Profile Test Case
6. User Overall Test Case
7. Admin Overall Test Case



8. Authors
	
GDIP SA 46 Team 12 (NUS ISS)
CHIRAG SHETTY
HENDRI SETIA WARDANA
LIM HOE KIT
ONG WEI TING
PEH GUEK LAN
WONG WEI JIE
ZIN MIN HTET
