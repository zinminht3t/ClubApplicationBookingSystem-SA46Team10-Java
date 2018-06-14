<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>New Facility Form</title>
	
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	
	<link rel='stylesheet prefetch'
		href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="fonts/font-awesome.min.css">
	<link rel="stylesheet" href="css/styles.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

</head>

<body>
	<br/>
	<br/>
	<br/>
	
	<form:form method="POST" commandName="maintenance"
		action="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormNew/create">

		<div class="container">
		
			<div class="row">
				<div class="col-md-12 text-center">
					<h2>New Maintenance Session Creation</h2>
				</div>
			</div>	
				
			<hr>
				
			<div class="row text-center">
				<div class="col-md-5"></div>
				<h5 class="col-md-2">Maintenance Id</h5>
				<div class="col-md-1">
					<!-- attribute name -->
					<h5 class="control-label col-md-4">${nextMaintenanceId}</h5>	
					<form:errors path="maintenanceid" cssClass="help-block" element="em" />
				</div>
			</div>

			<div class="row btn-group">
			
				<label class="col-md-12"><strong>Facility</strong></label>
				
				<div class="col-md-6">
					<!-- attribute name -->
					<select name="facilityName">
						<c:forEach items="${facilityList}" var="facility">
							<option value="${facility}"><c:out value="${facility}" /></option>
						</c:forEach>
					</select>
				</div>	
				
				<div class="col-md-2">
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
					
			<div class="row btn-group">
			
				<label class="control-label col-md-6"><strong>Start Date</strong></label>
				
				<div class="col-md-6">
					<!-- attribute name -->
					<fmt:formatDate value="${startdate.date}" 
						pattern="yyyy-MM-dd" 
						var="formattedDate"/>
					<form:input id="datepicker_start" path="startdate" type="date" pattern="yyyy-mm-dd"/>
					<form:errors path="startdate" cssClass="help-block" element="em" />
				</div>
			</div>
				
			<br/>	
			<br/>
					
			<div class="row btn-group">
			
				<label class="control-label col-md-6"><strong>End Date</strong></label>
				
				<div class="col-md-6">
					<!-- attribute name -->
					<fmt:formatDate value="${enddate.date}" 
			  			pattern="yyyy-MM-dd" 
			        	var="formattedDate"/>
					<form:input id="datepicker_end" path="enddate" type="date"/>
					<form:errors path="enddate" cssClass="help-block" element="em" />
				</div>
			</div>
			
			<br/>
			<br/>
					
			<div class="row btn-group">
			
				<label class="control-label col-md-7"><strong>Start Time</strong></label>
				
				<div class="col-md-5">
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
					
			<div class="row btn-group">
			
				<label class="control-label col-md-7"><strong>End Time</strong></label>
				
				<div class="col-md-5">
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
			
			<div class="row btn-group">
				<div class="col-md-6">
					<input id="btnSubmit" type="submit" value="Submit" />
				</div>	
				<div class="col-md-6">
					<input id="btnReset" type="reset" value="Reset"/>
				</div>
			</div>
			
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
