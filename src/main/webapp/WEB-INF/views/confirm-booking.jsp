
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <spring:url value="/js/confirm-booking.js" var="javascript" />
  <script src="${javascript}"></script>
  
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	  
	   $( "#datepicker" ).datepicker({
		   dateFormat: 'yy-mm-dd',
	    	onSelect: function(select){
	    		updateAb(select);
	    	}
	    });
		  function updateAb(value){
			  	window.location.replace('${pageContext.request.contextPath}/facilities/confirm-booking/'+value);
			  }
			  
			  
		  } );

 $( function() {
     $( "input" ).checkboxradio();
	   } );  

  </script>

</head>
<body>
<a href="${pageContext.request.contextPath}/facilities/confirm-booking">Book your booking</a>

<form:form method="POST" action="${pageContext.request.contextPath}/facilities/confirm-booking/booking-details">
	<p>Date: <input type="text" name="selecteddate" value="${date}" id="datepicker" ></p>	
	<script>	
	</script>
	
	<c:forEach var="courts" items="${availableCourtsTime}">
		<c:forEach var="court" items="${courts.key}">
				${court} <br />
			<c:forEach var="time" items="${availableCourtsTime[court]}">
				<div style="display: inline">		
				<!-- <span class="button-checkbox"> -->
        				<!--  <button type="button" class="btn" data-color="success">-->
							<input type="checkbox" name="${court}" value="${time.getTime()}">${time.getTime()}
					<!-- </button> -->
					<!-- </span> -->
				</div>
				</c:forEach>
			<br />
		</c:forEach>
	</c:forEach>
	<input type="submit">
</form:form>
</body>
</html>
	
	
	
	
	
	
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