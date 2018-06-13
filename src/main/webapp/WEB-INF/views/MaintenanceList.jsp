
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Maintenance List page</h3>

<a href="${pageContext.request.contextPath}/admin/calendar/maintenance/list">List
	Bookings</a>
	<c:if test="${fn:length(maintenanceList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
			   <th>Maintenance Id</th>
			   <th>Facility Name</th>
			   <th>Start Date</th>
			   <th>End Date</th>
			   <th>Start Time</th>
			   <th>End Time</th>
			   <th>Active</th>				   
			   
			</tr>
		</thead>
		<tbody>
		
			
			<c:forEach var="maintenance" items="${maintenanceList}">
			
					<tr class="maintenanceRecord">
						<td>${maintenance.getMaintenanceid()}</td>
						<td>${maintenance.getFacilities().getFacilityName()}</td>
						<td>${maintenance.getStartdate()}</td>
						<td>${maintenance.getEnddate()}</td>
						<td>${maintenance.getTimeslots_start().getTime()}</td>
						<td>${maintenance.getTimeslots_end().getTime()}</td>
						<td>${maintenance.isActive()}</td>
						
						
						
					</tr>
					
			</c:forEach>
		</tbody>
	</table>
</c:if>

