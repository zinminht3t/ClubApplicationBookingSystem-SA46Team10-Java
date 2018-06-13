<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title></title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
        $(document).ready(function() {
    $('#ulist').DataTable();
} );
    </script>
</head>
<body>

	<a href="${pageContext.request.contextPath}/admin/user/list"></a>

	<div class='col-xs-12'>
		<div class="panel-heading">

			<h4 style="color:blue; margin-left: 10px">Members Listing</h4>
			<hr>

		</div>
	</div>

	<c:if test="${fn:length(userlist) gt 0}">
		<table id="ulist" class="display" style="width: 100%; padding-left:10px; padding-right:10px">
			<thead style="color:blue">			 
				<tr>
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
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userlist}">
					<tr>
						<td>${user.userId}</td>
						<td>${user.fullname}</td>
						<td>${user.nric}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${user.dateofbirth}" /></td>
						<td>${user.gender}</td>
						<td>${user.address}</td>
						<td>${user.email}</td>
						<td>${user.contactno}</td>
						<td>${user.role}</td>
						<td><c:choose>
								<c:when test="${user.active == true}">
									<input type="checkbox" name="chkbox" checked="checked"
										onclick="return false;" />
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="chkbox" onclick="return false;" />
								</c:otherwise>
							</c:choose></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/user/UserFormEdit/${user.userId}"><button
									type="button" class="btn btn-warning btn-xs">Edit</button></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>
	</c:if>
</body>
</html>