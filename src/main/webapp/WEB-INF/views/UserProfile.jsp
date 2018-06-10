<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="row" style="margin: 100px;">

		<div class="col-md-10 col-md-offset-1">

			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					id="pills-home-tab" data-toggle="pill" href="#pills-home"
					role="tab" aria-controls="pills-home" aria-selected="true">Profile</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-profile-tab"
					data-toggle="pill" href="#pills-profile" role="tab"
					aria-controls="pills-profile" aria-selected="false">Edit
						Profile</a></li>
				<li class="nav-item"><a class="nav-link"
					id="pills-pastbooking-tab" data-toggle="pill"
					href="#pills-pastbooking" role="tab"
					aria-controls="pills-pastbooking" aria-selected="false">Past
						Bookings</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-sub-tab"
					data-toggle="pill" href="#pills-sub" role="tab"
					aria-controls="pills-sub" aria-selected="false">Subscription</a></li>
			</ul>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">
					<div class="row">
					
					
					</div>

				</div>
				<div class="tab-pane fade" id="pills-profile" role="tabpanel"
					aria-labelledby="pills-profile-tab">




					<h3>Edit Role page</h3>

					<form:form method="POST" commandName="userProfile" action="e.html">
						<table>
							<tbody>
								<tr>
									<td><spring:message code="fieldLabel.userid" /></td>
									<td><form:input path="userid" readonly="true" /></td>
									<td><form:errors path="userid" cssStyle="color: red;" /></td>
								</tr>
								<tr>
									<td><spring:message code="fieldLabel.email" /></td>
									<td><form:input path="email" /></td>
									<td><form:errors path="email" cssStyle="color: red;" /></td>
								</tr>
								<tr>
									<td><spring:message code="fieldLabel.nric" /></td>
									<td><form:input path="nric" /></td>
									<td><form:errors path="nric" cssStyle="color: red;" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="Update" /></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
				<div class="tab-pane fade" id="pills-pastbooking" role="tabpanel"
					aria-labelledby="pills-pastbooking-tab">...</div>
				<div class="tab-pane fade" id="pills-sub" role="tabpanel"
					aria-labelledby="pills-sub-tab">...</div>
			</div>

		</div>
	</div>
</body>
</html>