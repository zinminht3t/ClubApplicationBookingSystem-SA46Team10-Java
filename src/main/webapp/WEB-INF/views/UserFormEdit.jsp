<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Edit User Form</title>


<spring:url value="/css/FacilityFormNew.css" var="UserFormEdit" />
<link rel="STYLESHEET" type="text/css" href="${UserFormEdit}" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>

<body>

<form:form method="POST" commandName="users"  
		action="${pageContext.request.contextPath}/admin/user/edit/${user.userId}.html">

<h3>Edit User page</h3>

	<table>
		<tbody>		  
			<tr>
				<td><spring:message code="ID" /></td>
				<td><form:input path="userId" readonly="true"  /></td>
				<td><form:errors path="userId" cssStyle="color: red;" /></td>
			</tr> 
			<tr>
				<td><spring:message code="Name" /></td>
				<td><form:input path="fullname" /></td>
				<td><form:errors path="fullname" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="NRIC" /></td>
				<td><form:input path="nric" readonly="true" /></td>
				<td><form:errors path="nric" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Date of Birth" /></td>
				<td><form:input path="dateofbirth"/></td>				
				<td><form:errors path="dateofbirth" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Gender" /></td>
				<td><form:input path="gender" /></td>
				<td><form:errors path="gender" cssStyle="color: red;" /></td>
			</tr>			
			<tr>
				<td><spring:message code="Address" /></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Contact No." /></td>
				<td><form:input path="contactno" /></td>
				<td><form:errors path="contactno" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Role" /></td>
				<td><form:input path="role" /></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Active" /></td>
				<td><form:input path="active" readonly="true" /></td>
				<td><form:errors path="active" cssStyle="color: red;" /></td>
			</tr>
			
			
			<tr>
					<td><input type="submit" value="Update" /></td>
					<td><input type="reset" value="Reset"></td>
					<td></td>
					<td></td>
				</tr>
		</tbody>
	</table>
</form:form>
