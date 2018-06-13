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

<spring:url value="/css/MaintenanceFormNew.css" var="MaintenanceFormNew" />
<link rel="STYLESHEET" type="text/css" href="${MaintenanceFormNew}" />

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

	<form:form method="POST" commandName="maintenance"
		action="${pageContext.request.contextPath}/admin/calendar/maintenance/create.html">

		<div class="row">

			<div class="col-md-offset-2 col-md-8">
				<div class="panel-heading">

					<h4>New Maintenance session Creation</h4>
					<hr>

				</div>
							

				<div class="panel panel-primary">

					<div class="form-group">
						<label class="control-label col-md-4">Maintenance Id</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<label class="control-label col-md-4" path="maintenanceid">${nextMaintenanceId}</label>
							
							<form:errors path="maintenanceid" cssClass="help-block"
								element="em" />
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-4">Facility</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<select name="facilityName">
							    <c:forEach items="${facilityList}" var="facility">
							        <option value="${facility}"><c:out value="${facility}" /></option>
							    </c:forEach>
							</select>
							
							<select name="courtName">
							    <c:forEach items="${facilityCourtsList}" var="court">
							        <option value="${court}"><c:out value="${court}" /></option>
							    </c:forEach>
							</select>
							<form:errors path="facilities" cssClass="help-block" element="em" />
						</div>
					</div>
					<br>
					<br>
					<div class="form-group">
						<label class="control-label col-md-4">Start Date</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<fmt:formatDate value="${startdate.date}" 
			                pattern="yyyy-MM-dd" 
			                var="formattedDate"/>
							<form:input id="datepicker_start" path="startdate" type="date" pattern="yyyy-mm-dd"/>
							<form:errors path="startdate" cssClass="help-block" element="em" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-md-4">End Date</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<fmt:formatDate value="${enddate.date}" 
			                pattern="yyyy-MM-dd" 
			                var="formattedDate"/>
							<form:input id="datepicker_end" path="enddate" type="date"/>
							<form:errors path="enddate" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-4">Start Time</label>
						<div class="col-md-8">
							<!-- attribute name -->
							
							<select name="timeslotsName_start">
							    <c:forEach items="${timeslotsList}" var="timeSlot">
							        <option value="${timeSlot.time}"><c:out value="${timeSlot.time}" /></option>
							    </c:forEach>
							</select>
							<form:errors path="timeslots_start" cssClass="help-block" element="em" />
						</div>
					</div>
					<br>
					<br>
					
					<div class="form-group">
						<label class="control-label col-md-4">End Time</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<select name="timeslotsName_end">
							    <c:forEach items="${timeslotsList}" var="timeSlot">
							        <option value="${timeSlot.time}"><c:out value="${timeSlot.time}" /></option>
							    </c:forEach>
							</select>
							<form:errors path="timeslots_end" cssClass="help-block" element="em" />
						</div>
					</div>
					<br>
					<br>

				</div>

			</div>
		</div>
 
		<div class="action-button">
			<input id="btnSubmit" type="submit" value="Submit" />
			<input id="btnReset" type="reset" value="Reset"/>
		</div>
		
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

	

</body>

</html>
