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

<a href="${pageContext.request.contextPath}/admin/facility/create"></a>

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
					<sf:form class="form-horizontal" modelAttribute="facility"
						action="${contextRoot}/admin/facility/list" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4">Facility Name</label>
							<div class="col-md-8">
								<!-- attribute name -->
								<sf:input type="text" path="facilityName" class="form-control"
									placeholder="Enter facility name here!" />
								<sf:errors path="facilityName" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Court</label>
							<div class="col-md-8">
								<sf:input type="text" path="court" class="form-control"
									placeholder="Court number" />
								<sf:errors path="court" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Remark</label>
							<div class="col-md-8">
								<sf:textarea path="remark" class="form-control"
									placeholder="Enter your remark here!" />
								<sf:errors path="remark" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Image Path</label>
							<div class="col-md-8">
								<!-- attribute name -->
								<sf:input type="text" path="imagePath" class="form-control"
									placeholder="Enter image path here!" />
								<sf:errors path="imagePath" cssClass="help-block" element="em" />
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
