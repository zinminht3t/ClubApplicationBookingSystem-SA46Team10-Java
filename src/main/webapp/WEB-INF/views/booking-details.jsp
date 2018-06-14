<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html>
<head>
</head>
<body>


<br>
<br>
<br>
<br>
<br>
<br>
		<p>${booking.getBookingid()}</p>
		<p>${booking.getUser().getFullname()}</p>
		<p>${booking.getStatus()}</p>
		<c:forEach var="bookingdetails" items="${booking.getBookings()}">
			<p>${bookingdetails.getTimeSlot().getTime()}<p>
		</c:forEach>
<br />
</body>
</html>