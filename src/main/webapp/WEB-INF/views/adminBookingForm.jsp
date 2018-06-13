<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>New Facility Form</title>

<spring:url value="/css/FacilityFormNew.css" var="FacilityFormNew" />
<link rel="STYLESHEET" type="text/css" href="${FacilityFormNew}" />


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

</head>

<body>

	<form:form method="POST" commandName="adminBookingF"
		action="${pageContext.request.contextPath}/admin/manageBM/editBooking">

		<div class="row">

			<div class="col-md-offset-2 col-md-8">
				<div class="panel-heading">

					<h4>Edit Booking (Admin)</h4>
					<hr>

				</div>
							

				<div class="panel panel-primary">

					<div class="form-group">
						<label class="control-label col-md-4">Booking Id</label>

							<!-- attribute name -->
							<input class="control-label col-md-4" path="bookingid" value="${booking.getBookingid()}" readonly="readonly"/>

					</div>
					
					
					<div class="form-group">
						<label class="control-label col-md-4">Transaction Time</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="transactiontime" value="${booking.getTransactiontime()}"/>

					</div>

					
					<div class="form-group">
						<label class="control-label col-md-4">User Id</label>
	
							<!-- attribute name -->
							<input class="control-label col-md-4" path="users" value="${booking.getUser().userId}"/>

					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Total ($)</label>
		
							<!-- attribute name -->
							<input class="control-label col-md-4" path="total" value="${booking.total}"/>
	
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-4">Status</label>
	
							<!-- attribute name -->
							<input class="control-label col-md-4" path="total" value="${booking.status}"/>

					</div>

				</div>

			</div>
		</div>
		
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				
			   <th>Facility Id</th>
   			   <th>Facility Name</th>
			   <th>Timeslot</th>
			   <th>Booked Date</th>
			   <th>Price ($)</th>			   
			   
			</tr>
		</thead>
		<tbody>
				<c:forEach var="bookingDetail" items="${booking.getBookings()}">
			
					<tr class="bookingDetail">
						<td>${bookingDetail.getFacility().getFacilityID()}</td>
						<td>${bookingDetail.getFacility().getFacilityName()}</td>
						<td>${bookingDetail.getTimeslots().getTime()}</td>
						<td>${bookingDetail.getBookingdate()}</td>
						<td>${bookingDetail.getBookingprice()}</td>
					</tr>
					
			</c:forEach>
			
		</tbody>
	</table>
 
			<input class ="btn btn-danger" id="btnSubmit" type="submit" value="Cancel Booking" style="width: 100px;"/>

		<script
			src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src="js/index.js"></script>


	</form:form>
	
<script>

$( function() {
    $( "#datepicker_start" ).datepicker(         
    		dateFormat: 'yyyy-mm-dd',
            defaultDate: '2018-06-01')
);
  } 
);
  
$( function() {
    $( "#datepicker_end" ).datepicker(dateFormat : "dd/mm/yy");
  } 
);
  
</script>

