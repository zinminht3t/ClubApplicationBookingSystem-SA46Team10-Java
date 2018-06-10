<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Edit Role page</h3>

<form:form method="POST" commandName="userProfile"
	action="e.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.userid" /></td>
				<td><form:input path="userid" readonly="true" /></td>
				<td><form:errors path="userid" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: red;" /></td>
			</tr>
		<tr>
				<td><spring:message code="fieldLabel.nric" /></td>
				<td><form:input path="nric" /></td>
				<td><form:errors path="nric" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
</body>
</html>