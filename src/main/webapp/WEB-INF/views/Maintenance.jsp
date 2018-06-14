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

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="fonts/font-awesome.min.css">
    <link rel="stylesheet" href="css/styles.css">
    
<script type="text/javascript">
        $(document).ready(function() {
    $('#maintenanceList').DataTable();
} );
    </script>
</head>
<body>
<br>
<br>
<br>

	<a href="${pageContext.request.contextPath}/admin/viewMaintenances"></a>

	<div class='col-xs-12'>
		<div class="panel-heading">

			<h4 style="color:blue; margin-left: 10px">Maintenance Listing</h4>		
				
			<div class="row">
				<div class="col-sm-12 col-md-12"><h3>Toggle View</h3></div>
				
				<div class="col-sm-6 col-md-2">
					<form action="${pageContext.request.contextPath}/admin/viewCalendar">
						<input id="btn-show-calendar" type="submit" name="btnShowCalendar" value="Display Calendar" class="btn-primary btn-sm"></input>
					</form>
				</div>
					
				<div class="col-sm-6 col-md-2">
					<form action="${pageContext.request.contextPath}/admin/viewBookings">
						<input id="btn-show-bookings" type="submit" name="btnShowBookings" value="Display Bookings" class="btn-primary btn-sm"></input>
					</form>
				</div>
			</div>

		</div>
	</div>

	<c:if test="${fn:length(maintenanceList) gt 0}">
		<table id="maintenanceList" class="display" style="width: 100%; padding-left:10px; padding-right:10px">
			<thead style="color:blue">
				<tr>
					<th><spring:message code="Maintenance Id" /></th>
					<th><spring:message code="Facility Id" /></th>
					<th><spring:message code="Facility Name" /></th>
					<th><spring:message code="Start Date" /></th>
					<th><spring:message code="Start Time" /></th>
					<th><spring:message code="End Date" /></th>
					<th><spring:message code="End Time" /></th>
					<th><spring:message code="Active" /></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="maintenance" items="${maintenanceList}">
					<tr>
						<td>${maintenance.getMaintenanceid()}</td>
						<td>${maintenance.getFacilities().getFacilityID()}</td>
						<td>${maintenance.getFacilities().getFacilityName()}</td>
						<td>${maintenance.getStartdate()}</td>
						<td>${maintenance.getTimeslots_start().getTime()}</td>	
						<td>${maintenance.getEnddate()}</td>
						<td>${maintenance.getTimeslots_end().getTime()}</td>
						<td>${maintenance.isActive()}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormEdit/${maintenance.getMaintenanceid()}"><button
									type="button" class="btn btn-warning btn-xs">Edit</a></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>
	</c:if>

	<div>
		<a
			href="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormNew"><button
				type="button" class="btn btn-warning btn-xs" style="margin-left:20px">Add</a>
	</div>

</body>
</html>

