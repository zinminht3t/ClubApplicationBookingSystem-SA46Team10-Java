<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Edit Facility Form</title>


<spring:url value="/css/FacilityFormNew.css" var="FacilityFormEdit" />
<link rel="STYLESHEET" type="text/css" href="${FacilityFormEdit}" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>

<body>

<form:form method="POST" commandName="maintenance"
		action="${pageContext.request.contextPath}/admin/facility/MaintenanceFormEdit/${maintenance.maintenanceid}.html">

<h3>Edit Maintenance page</h3>

	<table>
		<tbody>		  
			<tr>
				<td><spring:message code="Maintenance ID" /></td>
				<td><form:input path="maintenanceid" readonly="true"  /></td>
			</tr> 
			<tr>
				<td><spring:message code="Facility ID" /></td>
				<td><form:input path="facilities.facilityID" readonly="true" /></td>
			</tr>
			<tr>
				<td><spring:message code="Start Date" /></td>
				<td><form:input path="startdate" readonly="true" /></td>
			</tr>
			<tr>
				<td><spring:message code="Time Start ID" /></td>
				<td><form:input path="timeslots_start.time" readonly="true" /></td>
			</tr>
			<tr>
				<td><spring:message code="End Date" /></td>
				<td><form:input path="enddate" readonly="true" />
			</tr>						
			<tr>
				<td><spring:message code="Time End ID" /></td>
				<td><form:input path="timeslots_end.time" readonly="true" /></td>
			</tr>
						
			<tr>
				<td></td>
				 <td><input type="submit" value="Cancel Booking"></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
