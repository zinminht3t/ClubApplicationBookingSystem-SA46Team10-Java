<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>Edit Facility Form</title>
</head>

<body>

	<form:form method="POST" commandName="maintenance"
			action="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormEdit/${maintenanceID}">
		
		<div class="container">
		
			<br/>
			<br/>
			<br/>
		
			<div class="row">
				<div class="col-md-12 text-center">
					<h3>Edit Maintenance page</h3>
				</div>
			</div>	
		
			<hr>
	
			<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
				<tbody>		  
					<tr>
						<td><spring:message code="Maintenance ID" /></td>
						<td><form:input path="maintenanceid" readonly="true" disabled="true" /></td>
					</tr> 
					<tr>
						<td><spring:message code="Facility ID" /></td>
						<td><form:input path="facilities.facilityID" readonly="true"  disabled="true" /></td>
					</tr>
					<tr>
						<td><spring:message code="Start Date" /></td>
						<td><form:input path="startdate" readonly="true"  disabled="true" /></td>
					</tr>
					<tr>
						<td><spring:message code="Time Start ID" /></td>
						<td><form:input path="timeslots_start.time" readonly="true"  disabled="true" /></td>
					</tr>
					<tr>
						<td><spring:message code="End Date" /></td>
						<td><form:input path="enddate" readonly="true"  disabled="true" />
					</tr>						
					<tr>
						<td><spring:message code="Time End ID" /></td>
						<td><form:input path="timeslots_end.time" readonly="true"  disabled="true" /></td>
					</tr>
								
					<tr>
						<td></td>
						 <td><input  class ="btn btn-danger" type="submit" value="Cancel Maintenance"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form:form>
</body>	