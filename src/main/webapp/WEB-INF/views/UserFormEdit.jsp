<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Edit User Form</title>


<spring:url value="/css/FacilityFormNew.css" var="UserFormEdit" />
<link rel="STYLESHEET" type="text/css" href="${UserFormEdit}" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>

<body>

<form:form method="POST" commandName="users"  
		action="${pageContext.request.contextPath}/admin/user/edit/${users.userId}.html">

<div class="container">
			<form>
				<div class="row">

					<div class="col-md-offset-2 col-md-12">
						<div class="panel-heading">

							<h4 style="margin-left: .7em">Edit User</h4>
							<hr>

						</div>

						<div class="panel panel-primary">

							<div class="form-group">
								<label class="control-label col-md-6">User ID</label>
								<div class="col-xl-12">
									<!-- attribute name -->
									<form:input path="userId" readonly="true"  />
									<form:errors path="userId" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Full Name</label>
								<div class="col-xl-12">
									<!-- attribute name -->
									<form:input path="fullname" style="background:#87CEFA" />
									<form:errors path="fullname" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">NRIC</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="nric" readonly="true"/>
									<form:errors path="nric" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Date of Birth</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="dateofbirth" readonly="true"/>
									<form:errors path="dateofbirth" cssStyle="color: red;" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-6">Gender</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="gender" readonly="true"/>
									<form:errors path="gender" cssStyle="color: red;" />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-6">Address</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="address" style="background:#87CEFA"/>
									<form:errors path="address" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Contact No.</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="contactno" style="background:#87CEFA"/>
									<form:errors path="contactno" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Email</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="email" style="background:#87CEFA"/>
									<form:errors path="email" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Role</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="role" readonly="true"/>
									<form:errors path="role" cssStyle="color: red;" />
								</div>
							</div>

							
						</div>

					</div>
				</div>
				<table id="action-button">
					<tr>
						<td><input type="submit" value="Submit"
							style="margin-left: .9em; background:#F0AD4E"/></td>
						<td></td>
						<td><input type="reset" value="Reset"
							style="margin-left: 2em; background:#F0AD4E" /></td>
				</table>

			</form>
		</div>

		<script
			src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src="js/index.js"></script>

	</form:form>

</body>

</html>