<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Facility List page</h3>

<a href="${pageContext.request.contextPath}/admin/facility/list">List
	Facilities</a>
	<c:if test="${fn:length(facilitylist) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.facilityID" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="facility" items="${facilitylist}">
				<tr class="listRecord">
					<td>${facility.facilityID}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
