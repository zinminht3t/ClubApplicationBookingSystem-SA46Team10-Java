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
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	
	<script type="text/javascript">
	        $(document).ready(function() {
	    $('#ulist').DataTable();
	} );
	    </script>
</head>
<body>
	
	<br/>
	<br/>
	<br/>
	
	<a href="${pageContext.request.contextPath}/admin/user/list"></a>

	<div class="container" width="80%" margin-right="10%" margin-left="10%" padding-top="120px" margin-top="120px">
	
		<div class="row">
			<div class="col-md-12 text-center">
			<h3>Members Listing</h3>
			</div>
		</div>	
		<hr>

			<div class="row ">
				<div class="col-md-12 ">
			<c:if test="${fn:length(userlist) gt 0}">
				<table id="ulist" class="display" style="width: auto; padding-left:10px; padding-right:10px; font-size: 12px;">
					<thead class="text-info">			 
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
								<td>
									<a href="${pageContext.request.contextPath}/admin/user/UserFormEdit/${user.userId}">
										<i class="fa fa-edit text-danger fa-2x"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
		
				</table>
			</c:if>
		
				</div>
			</div>
		
	</div>
</body>
</html>