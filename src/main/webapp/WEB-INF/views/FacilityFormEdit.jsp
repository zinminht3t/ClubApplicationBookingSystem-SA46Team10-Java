<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Facility page</h3>
<form:form method="POST" modelAttribute="facility"
	action="${pageContext.request.contextPath}/admin/facility/edit/${facility.facilityName}.html">
	<table>
		<tbody>
	    <form:hidden path=""/>  
			<tr>
				<td><spring:message code="ID" /></td>
				<td><form:input path="facilityID" readonly="true" /></td>
				<td><form:errors path="facilityID" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Facility Name" /></td>
				<td><form:input path="facilityName" /></td>
				<td><form:errors path="facilityName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Court" /></td>
				<td><form:input path="court" /></td>
				<td><form:errors path="court" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Remark" /></td>
				<td><form:input path="remark" /></td>
				<td><form:errors path="remark" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Image Path" /></td>
				<td><form:input path="imagePath" /></td>
				<td><form:errors path="imagePath" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Active" /></td>
				<td><form:input path="active" /></td>
				<td><form:errors path="active" cssStyle="color: red;" /></td>
			</tr>
			<!-- <tr>
				<td><spring:message code="Facility Name" /></td>
				<td><form:select path="facilityName">
						<form:option value="" label="...." />
						<form:options items="${eidlist}" />
					</form:select></td>
				<td><form:errors path="managerId" cssStyle="color: red;" /></td>
			</tr> /-->
			
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
