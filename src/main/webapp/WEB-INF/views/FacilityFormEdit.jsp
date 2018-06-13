<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Edit Facility Form</title>


<spring:url value="/css/FacilityFormNew.css" var="FacilityFormEdit" />
<link rel="STYLESHEET" type="text/css" href="${FacilityFormEdit}" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>

<body>

<form:form method="POST" commandName="facility"
		action="${pageContext.request.contextPath}/admin/facility/edit/${facility.facilityID}.html">

<h3>Edit Facility page</h3>

	<table>
		<tbody>		  
			<tr>
				<td><spring:message code="ID" /></td>
				<td><form:input path="facilityID" readonly="true"  /></td>
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
				<td><spring:message code="Price" /></td>
				<td><form:input path="price" />
				<td><form:errors path="price" cssStyle="color: red;" /></td>
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
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Edit Facility Form</title>


<spring:url value="/css/FacilityFormNew.css" var="FacilityFormEdit" />
<link rel="STYLESHEET" type="text/css" href="${FacilityFormEdit}" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>

<body>

<form:form method="POST" commandName="facilities"
		action="${pageContext.request.contextPath}/admin/facility/edit/${facility.facilityID}.html">

<h3>Edit Facility page</h3>

	<table>
		<tbody>		  
			<tr>
				<td><spring:message code="ID" /></td>
				<td><form:input path="facilityID" readonly="true"  /></td>
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
				<td><spring:message code="Price" /></td>
				<td><form:input path="price" />
				<td><form:errors path="price" cssStyle="color: red;" /></td>
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
>>>>>>> branch 'master' of https://github.com/zinminht3t/SA46Team12CABProject
