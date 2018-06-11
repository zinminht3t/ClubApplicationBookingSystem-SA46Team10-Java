<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html>
<head>
	<title>Admin | Facility</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous">
 
<link rel="stylesheet" href="css/FacilityList.css">

</head>
<body> 
   
<a href="${pageContext.request.contextPath}/admin/facility/list"></a>

<div class="row" style="margin-top: 100px; margin-left: 200px">
	<div class='col-xs-12'>
	<div class="panel-heading">

					<h4>Facilities List</h4>
					<hr>

				</div>
	
		<c:if test="${fn:length(facilitylist) gt 0}">
			<table id="facilityTable"
				class="table table-condensed table-bordered">
				<thead>
					<tr class="listHeading">
						<th><spring:message code="ID" /></th>
						<th><spring:message code="Name" /></th>
						<th><spring:message code="Court" /></th>
						<th><spring:message code="Remark" /></th>
						<th><spring:message code="Image Path" /></th>
						<th><spring:message code="Active" /></th>
						<th></th>						
					</tr>
				</thead>
				<tfoot>
					<c:forEach var="facility" items="${facilitylist}">
						<tr class="listRecord">
							<td>${facility.facilityID}</td>
							<td>${facility.facilityName}</td>
							<td>${facility.court}</td>
							<td>${facility.remark}</td>
							<td>${facility.imagePath}</td>
							<td>${facility.active}</td>
							<td>
							<a
						href="${pageContext.request.contextPath}/admin/facility/edit/${facility.facilityName}.html"><button type="button" class="btn btn-warning btn-xs">Edit</a>
							</td> 

						</tr>
					</c:forEach>

				</tfoot>
			</table>
		</c:if>
	</div>
</div>

<script src="static/js/jquery-1.11.1.min.js"></script>    
<script src="static/js/bootstrap.min.js"></script>
    
    </body>
</html>


