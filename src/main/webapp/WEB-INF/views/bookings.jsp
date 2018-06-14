<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<fmt:setLocale value="en_SG" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<title></title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	
	<link href="${pageContext.request.contextPath}/css/Calendar.css"
		rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="fonts/font-awesome.min.css">
    <link rel="stylesheet" href="css/styles.css">

<script type="text/javascript">
        $(document).ready(function() {
    $('#bookingList').DataTable();
} );
    </script>
</head>
<body>
<br>
<br>
<br>

	<a href="${pageContext.request.contextPath}/admin/viewBookings"></a>

	<div class='col-xs-12'>
		<div class="panel-heading">

			<h4 style="color:blue; margin-left: 10px">Bookings Listing</h4>	
					
			<div class="row">
				<div class="col-sm-12 col-md-12"><h3>Toggle View</h3></div>
				
				<div class="col-sm-6 col-md-2">
					<form action="${pageContext.request.contextPath}/admin/viewCalendar">
						<input id="btn-show-calendar" type="submit" name="btnShowCalendar" value="Display Calendar" class="btn-primary btn-sm"></input>
					</form>
				</div>
					
				<div class="col-sm-6 col-md-2">
					<form action="${pageContext.request.contextPath}/admin/viewMaintenances">
						<input id="btn-show-maintenances" type="submit" name="btnShowMaintenances" value="Display Maintenance" class="btn-primary btn-sm"></input>
					</form>
				</div>
			</div>
			

		</div>
	</div>

	<c:if test="${fn:length(bookingList) gt 0}">
		<table id="bookingList" class="display" style="width: 100%; padding-left:10px; padding-right:10px">
			<thead style="color:blue">
				<tr>
					<th><spring:message code="Booking Id" /></th>
					<th><spring:message code="Transaction Time" /></th>
					<th><spring:message code="User Id" /></th>
					<th><spring:message code="User Name" /></th>
					<th><spring:message code="Facility" /></th>
					<th><spring:message code="Time" /></th>
					<th><spring:message code="Total ($)" /></th>
					<th><spring:message code="Status" /></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bookings" items="${bookingList}">
				<c:forEach var="bookingDetail" items="${bookings.getBookings()}">
					<tr>
						<td>${bookings.bookingid}</td>
						<td>${bookings.transactiontime}</td>
						<td>${bookings.getUser().userId}</td>
						<td>${bookings.getUser().fullname}</td>
						<td>${bookingDetail.getFacility().getFacilityName()}</td>
						<td>${bookingDetail.getTimeslot().getTime()}</td>	
						<td><fmt:formatNumber value="${bookings.total}" type="currency" /></td>
						<td>${bookings.status}</td>
						
						<td><a
							href="${pageContext.request.contextPath}/admin/viewBookings/editBooking/${bookings.bookingid}"><button
									type="button" class="btn btn-warning btn-xs">Edit</a></td>
						
					</tr>
				
				</c:forEach>
				</c:forEach>
						

			</tbody>

		</table>
	</c:if>


</body>
</html>
