<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">



<head>
<meta charset="UTF-8">
<title>Manage Bookings and Maintenance</title>


<link href="${pageContext.request.contextPath}/css/Calendar.css"
	rel="stylesheet" type="text/css">
	
</head>

<body>
	<div>
		<h1>Manage Bookings and Maintenance</h1>

		<table style="width: 100%;">

			<div id="viewMonth">Month:${sessionScope.currentMonth}</div>
			<div id="viewYear">Year:${sessionScope.currentYear}</div>
			<div>
				<form action="${pageContext.request.contextPath}/admin/viewCalendar"
					class="contact-form" method="post">
					<input type="submit" name="btnPrev" value="prev">
					</input>
					<input type="submit" name="btnNext" value="next">
					</input>
				</form>
			</div>
			
			<form action="${pageContext.request.contextPath}/admin/calendar/maintenance/create">
			
				<input type="submit" name="btnShowAddMaintenance" value="Add Maintenance">
					</input>
			</form>
			
			<div class="legend">
				<p>Legend:</p>
				<p>Green-Bookings</p>
				<p>Blue-Maintenance</p>
			</div>
					
			<c:forEach var="day" items="${sessionScope.daysOfWeek}">
				<td style="border: 1px solid black; float: left; width: 13%;">${day}</td>
			</c:forEach>
		</table>
		
		<c:forEach begin="0" end="34" varStatus="loop">
			<div class="calendar-tile"
				style="border: 1px solid black; float: left; width: 13%; height: 15%;">

				<c:if test="${sessionScope.currentFirstDayIndex-loop.index<=0 && loop.index-sessionScope.currentFirstDayIndex+1<=sessionScope.lastDayOfCurrentMonth}">
					<p>${loop.index-sessionScope.currentFirstDayIndex+1}</p>
				
					<div class="calendar-tile-content">
						<c:forEach var="booking" items="${sessionScope.bookingViewList}">
						<fmt:parseDate var="thisDate" value="${sessionScope.currentYear}-${sessionScope.currentMonth}-${loop.index-sessionScope.currentFirstDayIndex+1}" pattern="yyyy-MM-dd" />
						<fmt:parseDate var="bookingDate" value="${booking.getBookingdate()}" pattern="yyyy-MM-dd" />
		
							<c:if
								test="${bookingDate==thisDate}">
<%-- 					<form:form modelAttribute="getbookingtiming" method="POST" action="${pageContext.request.contextPath}/manageBM/editBooking/${booking.getBookingid()}"> --%>
											            <a href="${pageContext.request.contextPath}/admin/manageBM/editBooking/${booking.getBookingid()}">
								<button id="${booking.getBookingid()}" name="btnIDeditBooking" class="btn-booking-slot">${booking.getMinTime()}--${booking.getMaxTime()}</button></a>
<%-- 								</form:form> --%>
							</c:if>
						</c:forEach>
						
						<c:forEach var="maintenance" items="${sessionScope.maintenanceList}">
						<fmt:parseDate var="thisDate" value="${sessionScope.currentYear}-${sessionScope.currentMonth}-${loop.index-sessionScope.currentFirstDayIndex+1}" pattern="yyyy-MM-dd" />
						<fmt:parseDate var="maintenanceStartDate" value="${maintenance.getStartdate()}" pattern="yyyy-MM-dd" />
						<fmt:parseDate var="maintenanceEndDate" value="${maintenance.getEnddate()}" pattern="yyyy-MM-dd" />
		
							<c:if
								test="${maintenanceStartDate==thisDate}">
								 <a href="${pageContext.request.contextPath}/admin/facility/MaintenanceFormEdit/${maintenance.getMaintenanceid()}">
								<button id="${maintenance.getMaintenanceid()}" class="btn-maintenance-slot">${maintenance.getTimeslots_start().getTime()}--${maintenance.getTimeslots_end().getTime()}</button></a>
							</c:if>
						</c:forEach>
					</div>
				
				</c:if>


			</div>
		</c:forEach>


		<script>
			
		</script>


	</div>

<script>
function viewBooking(id){
	$('btn-booking-slot').load('MaintenanceFormNew.jsp');
}
</script>
</body>


</html>
