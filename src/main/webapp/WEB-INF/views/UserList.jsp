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
 
<link rel="stylesheet" href="css/UserList.css">

</head>
<body> 

<div class="row" style="margin-top: 100px; margin-left: 6px">
<div class='col-xs-12'>
	<div class="panel-heading">

					<h4>User List</h4>
					<hr>

				</div>

	<div class='col-xs-12'>
		<c:if test="${fn:length(userlist) gt 0}">
			<table id="userTable"
				class="table table-condensed table-bordered">
				<thead>
					<tr class="listHeading">
						<th><spring:message code="ID" /></th>
						<th><spring:message code="Name" /></th>
						<th><spring:message code="NRIC" /></th>
						<th><spring:message code="DOB" /></th>
						<th><spring:message code="Gender" /></th>
						<th><spring:message code="Address" /></th>
						<th><spring:message code="Email" /></th>
						<th><spring:message code="Contact" /></th>
						<th><spring:message code="Role" /></th>
						<th><spring:message code="Active" /></th>	
						<th></th>
						
					</tr>
				</thead>
				<tfoot>
					<c:forEach var="user" items="${userlist}">
						<tr class="listRecord">
							<td>${user.userId}</td>
							<td>${user.fullname}</td>
							<td>${user.nric}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${user.dateofbirth}"/></td>
							<td>${user.gender}</td>
							<td>${user.address}</td>
							<td>${user.email}</td>
							<td>${user.contactno}</td>
							<td>${user.role}</td>
							<td>${user.active}</td>
							<td><a
						href="${pageContext.request.contextPath}/admin/facility/edit/${user.nric}.html"><button type="button" class="btn btn-warning btn-xs">Edit
							</button></td>
							
						 							
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

