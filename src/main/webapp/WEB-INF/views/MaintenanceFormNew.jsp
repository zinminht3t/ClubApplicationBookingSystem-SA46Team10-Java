<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html lang="en">
<head>
   <title>Admin | New Facility</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous">
 
<link rel="stylesheet" href="css/FacilityFormNew.css">

</head>
<body>

<a href="${pageContext.request.contextPath}/admin/maintenance/create"></a>

<div class="container" style="margin-top: 100px">

	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-info fade in">${message}</div>
			</div>
		</div>
	</c:if>

	<div class="row">

		<div class="col-md-offset-2 col-md-8">
				<div class="panel-heading">

					<h4>New Facility Creation</h4>
					<hr>

				</div>

			<div class="panel panel-primary">	

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="maintenance"
						action="${contextRoot}/admin/maintenance/list" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4">Maintenance Id</label>
							<div class="col-md-8">
								<!-- attribute name -->
								<sf:input type="text" path="maintenanceid" class="form-control"
									placeholder="Enter Maintenance id here!" />
								<sf:errors path="maintenanceid" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Facilities</label>
							<div class="col-md-8">
								<sf:input type="text" path="facilities" class="form-control"
									placeholder="facilities" />
								<sf:errors path="facilities" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Start Date</label>
							<div class="col-md-8">
								<sf:input path="startdate" class="form-control"
									placeholder="Enter your StartDate here!" />
								<sf:errors path="startdate" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">End Date</label>
							<div class="col-md-8">
								<!-- attribute name -->
								<sf:input type="enddate" path="imagePath" class="form-control"
									placeholder="Enter EndDate here!" />
								<sf:errors path="enddate" cssClass="help-block" element="em" />
							</div>
						</div>					

						<div class="form-group">
							<label class="control-label col-md-4">Start Time</label>
							<div class="col-md-8">
								<sf:input path="timeslots_start" class="form-control"
									placeholder="Enter your StartTime here!" />
								<sf:errors path="timeslots_start" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">End Time</label>
							<div class="col-md-8">
								<!-- attribute name -->
								<sf:input type="timeslots_end" path="imagePath" class="form-control"
									placeholder="Enter EndTime here!" />
								<sf:errors path="timeslots_end" cssClass="help-block" element="em" />
							</div>
						</div>			
						
						<div class="form-group">
							<label class="control-label col-md-4">Active</label>
							<div class="col-md-8">
								<sf:input type="boolean" path="active" class="form-control"
									placeholder="Indicate status" />
								<sf:errors path="active" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">

								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />

							</div>
						</div>

					</sf:form>

				</div>

			</div>

		</div>

	</div>
</div>
    
    </body>
</html>
