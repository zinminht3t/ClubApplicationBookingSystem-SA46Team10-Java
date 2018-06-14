<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html>
<head>
</head>
<body>
${selecteddate}
<br />
Booked Times: 
<c:forEach var="court" items="${courtAndTimes}">
	<c:forEach var="times" items="${court.value}">
		<c:forEach var="time" items="${times}">
			${time}
		</c:forEach>
		<br />
	</c:forEach>
</c:forEach>
</body>
</html>