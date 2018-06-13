
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:url value="js/jquery-ui.js" var="jquery-ui" />
<link rel="JQUERY-UI" type="jquery-ui" href="${jquery-ui}" />


<h3>Booking page</h3>

<a href="${pageContext.request.contextPath}/facilities/confirm-booking">Book Facility</a>

	
	<c:forEach var="courts" items="${availableCourtsTime}">
		<c:forEach var="court" items="${courts.key}">
				${court} <br />
			<c:forEach var="time" items="${availableCourtsTime[court]}">
				<div style="display: inline">
						<button>${time.getTime()}</button>
				</div>
				</c:forEach>
			<br />
		</c:forEach>
	</c:forEach>
	
	
	
	
	
	
	
	 <!--  
	<c:forEach var="courts" items="${bookedCourtsTime}">
		<c:forEach var="court" items="${courts.key}">
			${court} <br />
			<c:forEach var="time" items="${bookedCourtsTime[court]}">
					${time.getTimeslots().getTime()} <br />
			</c:forEach>
		</c:forEach>
	</c:forEach>
	-->