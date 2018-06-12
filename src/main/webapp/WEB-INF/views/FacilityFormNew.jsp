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


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

</head>

<body>

	<form:form method="POST" commandName="facilities"
		action="${pageContext.request.contextPath}/admin/facility/create.html">

		<div class="row">

			<div class="col-md-offset-2 col-md-8">
				<div class="panel-heading">

					<h4>New Facility Creation</h4>
					<hr>

				</div>

				<div class="panel panel-primary">

					<div class="form-group">
						<label class="control-label col-md-4">Facility Name</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<form:input path="facilityName" type="text"
								placeholder="Enter the facilty name" />
							<form:errors path="facilityName" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Court</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<form:input path="court" type="text"
								placeholder="Enter the court number" />
							<form:errors path="court" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-4">Price</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<form:input path="price" type="text"
								placeholder="Enter the price" />
							<form:errors path="price" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Remark</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<form:input path="remark" type="text"
								placeholder="Enter the remark" />							
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Image Path</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<form:input path="imagePath" type="text"
								placeholder="Enter the image path" />
							<form:errors path="imagePath" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-4">Active</label>
						<div class="col-md-8">
							<!-- attribute name -->
							<form:input path="active" type="text"
								placeholder="Enter the active status" />
							<form:errors path="active" cssClass="help-block" element="em" />
						</div>
					</div>

				</div>

			</div>
		</div>
 
		<div class="action-button">
			<input type="submit" value="Submit" />
			<input type="reset" value="Reset"/>
		</div>
		</div>
		
		<script
			src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src="js/index.js"></script>


	</form:form>
	


	

</body>

</html>
