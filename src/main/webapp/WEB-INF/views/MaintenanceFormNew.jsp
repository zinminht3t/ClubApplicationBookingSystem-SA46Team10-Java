<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<title>New Facility Form</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


</head>

<body>
	<br />
	<br />
	<br />



	<div class="container">

		<div class="row center-block">

			<div class="col-md-10 offset-md-1">
				<form:form method="POST" commandName="maintenance"
					action="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormNew/create">

					<div class="row">
						<div class="col-md-12 text-center">
							<h2>New Maintenance Session Creation</h2>
						</div>
					</div>

					<hr>

					<div class="row">
						<div class="col-md-2"></div>
						<h5 class="col-md-3 text-info">Maintenance ID :</h5>
						<div class="col-md-1">
							<!-- attribute name -->
							<h5 class="control-label col-md-4">${nextMaintenanceId}</h5>
							<form:errors path="maintenanceid" cssClass="help-block"
								element="em" />
						</div>
						<br />
						<br/>
						<br />
					</div>

					<div class="row">

						<label class="col-md-2"><strong>Facility : </strong></label>

						<div class="col-md-4">
							<!-- attribute name -->
							<select name="facilityName" class="form-control">
								<c:forEach items="${facilityList}" var="facility">
									<option value="${facility}"><c:out value="${facility}" /></option>
								</c:forEach>
							</select>
						</div>

						<div class="col-md-1">
							<select name="courtName" class="form-control">
								<c:forEach items="${facilityCourtsList}" var="court">
									<option value="${court}"><c:out value="${court}" /></option>
								</c:forEach>
							</select>
							<form:errors path="facilities" cssClass="help-block" element="em" />
						</div>
					</div>

					<br>
					<br>

					<div class="row">

						<label class="control-label col-md-2"><strong>Start
								Date : </strong></label>

						<div class="col-md-5">
							<!-- attribute name -->
							<fmt:formatDate value="${startdate.date}" pattern="yyyy-MM-dd"
								var="formattedDate" />
							<form:input id="datepicker_start" path="startdate"
								class="form-control" type="text"
								pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" />
							<form:errors path="startdate" cssClass="help-block" element="em" />
						</div>
					</div>

					<br />
					<br />

					<div class="row">

						<label class="control-label col-md-2"><strong>End
								Date : </strong></label>

						<div class="col-md-5">
							<!-- attribute name -->
							<fmt:formatDate value="${enddate.date}" pattern="yyyy-MM-dd"
								var="formattedDate" />
							<form:input id="datepicker_end" path="enddate" type="text"
								class="form-control"
								pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" />
							<form:errors path="enddate" cssClass="help-block" element="em" />
						</div>
					</div>

					<br />
					<br />

					<div class="row">

						<label class="control-label col-md-2"><strong>Start
								Time : </strong></label>

						<div class="col-md-5">
							<!-- attribute name -->
							<select name="timeslotsName_start" class="form-control">
								<c:forEach items="${timeslotsList}" var="timeSlot">
									<option value="${timeSlot.time}"><c:out
											value="${timeSlot.time}" /></option>
								</c:forEach>
							</select>
							<form:errors path="timeslots_start" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<br>
					<br>

					<div class="row">

						<label class="control-label col-md-2"><strong>End
								Time : </strong></label>

						<div class="col-md-5">
							<!-- attribute name -->
							<select name="timeslotsName_end" class="form-control">
								<c:forEach items="${timeslotsList}" var="timeSlot">
									<option value="${timeSlot.time}"><c:out
											value="${timeSlot.time}" /></option>
								</c:forEach>
							</select>
							<form:errors path="timeslots_end" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<br>
					<br>

					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-3">
							<input class="btn btn-outline-primary" id="btnSubmit"
								type="submit" value="Submit" /> <input
								class="btn btn-outline-danger" id="btnReset" type="reset"
								value="Reset" />
						</div>
					</div>


				</form:form>

			</div>

		</div>

	</div>

	<script>
		$(function() {
			$("#datepicker_start").datepicker({
				dateFormat : 'yy-mm-dd',
				minDate : 0,
			});
		});
		


		$(function() {
			$("#datepicker_end").datepicker({
				dateFormat : 'yy-mm-dd',
				minDate : 0
			});
		});
	</script>




</body>

</html>
