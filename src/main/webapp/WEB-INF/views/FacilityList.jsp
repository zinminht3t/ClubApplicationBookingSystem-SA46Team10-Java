<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<fmt:setLocale value="en_SG" scope="session"/>

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
    $('#faclist').DataTable();
} );
    </script>
</head>
<body>

	<a href="${pageContext.request.contextPath}/admin/facility/list"></a>

	<div class='col-xs-12'>
		<div class="panel-heading">

			<h4 style="color:blue; margin-left: 10px">Facilities Listing</h4>			
			<hr>

		</div>
	</div>

	<c:if test="${fn:length(facilitylist) gt 0}">
		<table id="faclist" class="display" style="width: 100%; padding-left:10px; padding-right:10px">
			<thead style="color:blue">
				<tr>
					<th><spring:message code="ID" /></th>
					<th><spring:message code="Name" /></th>
					<th><spring:message code="Court" /></th>
					<th><spring:message code="Price" /></th>
					<th><spring:message code="Remark" /></th>
					<th><spring:message code="Image Path" /></th>
					<th><spring:message code="Active" /></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="facility" items="${facilitylist}">
					<tr>
						<td>${facility.facilityID}</td>
						<td>${facility.facilityName}</td>
						<td>${facility.court}</td>
						<td><fmt:formatNumber value="${facility.price}" type="currency" /></td>
						<td>${facility.remark}</td>
						<td>${facility.imagePath}</td>
						<td><c:choose>
								<c:when test="${facility.active == true}">
									<input type="checkbox" name="chkbox" checked="checked"
										onclick="return false;" />
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="chkbox" onclick="return false;" />
								</c:otherwise>
							</c:choose></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/facility/FacilityFormEdit/${facility.facilityID}"><button
									type="button" class="btn btn-warning btn-xs">Edit</a></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>
	</c:if>

	<div>
		<a
			href="${pageContext.request.contextPath}/admin/facility/FacilityFormNew"><button
				type="button" class="btn btn-warning btn-xs" style="margin-left:20px">Add</a>
	</div>

</body>
</html>

