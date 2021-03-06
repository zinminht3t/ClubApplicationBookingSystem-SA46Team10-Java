
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

</head>

<body>

	<form:form method="POST" commandName="facility"
		action="${pageContext.request.contextPath}/admin/facility/create.html">
		<div class="container" style="margin-top: 50px;">
			<form>
				<div class="row">

					<div class="col-md-offset-2 col-md-12">
						<div class="panel-heading">

							<h4 style="margin-left: .7em">New Facility Creation</h4>
							<hr>

						</div>

						<div class="panel panel-primary">

							<div class="form-group">
								<label class="control-label col-md-6">Facility Name</label>
								<div class="col-xl-12">
									<!-- attribute name -->
									<form:input path="facilityName" type="text"
										placeholder="Enter the facilty name" />
									<form:errors path="facilityName" cssClass="help-block"
										element="em" style="color:red" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Court</label>
								<div class="col-xl-12">
									<!-- attribute name -->
									<form:input path="court" type="text"
										placeholder="Enter the court number" />
									<form:errors path="court" cssClass="help-block" element="em"
										style="color:red" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Price</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="price" type="text"
										placeholder="Enter the price" />
									<form:errors path="price" cssClass="help-block" element="em"
										style="color:red" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Remark</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="remark" type="text"
										placeholder="Enter the remark" />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-6">Image Path</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="imagePath" type="text"
										placeholder="Enter the image path" />
									<form:errors path="imagePath" cssClass="help-block"
										element="em" />
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