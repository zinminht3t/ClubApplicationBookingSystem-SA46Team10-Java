<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<form:form method="POST" commandName="facility"
		action="${pageContext.request.contextPath}/admin/facility/edit/${facility.facilityID}.html">

<div class="container">
			<form>
				<div class="row">

					<div class="col-md-offset-2 col-md-12">
						<div class="panel-heading">

							<h4 style="margin-left: .7em">Edit Facility</h4>
							<hr>

						</div>

						<div class="panel panel-primary">

							<div class="form-group">
								<label class="control-label col-md-6">Facility ID</label>
								<div class="col-xl-12">
									<!-- attribute name -->
									<form:input path="facilityID" readonly="true"  />
									<form:errors path="facilityID" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Facility Name</label>
								<div class="col-xl-12">
									<!-- attribute name -->
									<form:input path="facilityName" readonly="true"/>
									<form:errors path="facilityName" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Court</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="court" readonly="true"/>
									<form:errors path="court" cssStyle="color: red;" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-6">Price</label>
								<div class="col-md-12">									
									<form:input path="price" style="background:#87CEFA"/>					
									<form:errors path="price" cssStyle="color: red;" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-6">Remark</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="remark" style="background:#87CEFA"/>
									<form:errors path="remark" cssStyle="color: red;" />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-md-6">Image Path</label>
								<div class="col-md-12">
									<!-- attribute name -->
									<form:input path="imagePath" style="background:#87CEFA"/>
									<form:errors path="imagePath" cssStyle="color: red;" />
								</div>
							</div>
							
							<div class="col-half">
						<h6 style="margin-left: .9em">Active</h6>
						<div class="input-group" style="margin-left: .9em">
							<form:radiobutton path="active" value="true" label="Yes"/> 							
							<form:radiobutton path="active" value="false" label="No"/>
							<form:errors path="active" cssStyle="color: red;" />
						</div>
					</div>

					</div>
					
					</div>
				</div>
				<table id="action-button">
					<tr>
						<td><input type="submit" value="Submit"
							style="margin-left: .9em;background:#F0AD4E" /></td>
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