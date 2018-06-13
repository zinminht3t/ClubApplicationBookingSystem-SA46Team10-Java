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
		
		<div class=top-content>
		<br>
		<br>
		<br>
		<br>
		
			<h3>Manage Bookings and Maintenance</h3>

			
			<div class="monthyear" id="viewMonthYear"> ${sessionScope.currentMonthName}-${sessionScope.currentYear}</div>
			<div class="calendar-buttons">
				<form action="${pageContext.request.contextPath}/admin/viewCalendar"
					class="nextprev-form" method="post">
					<input type="submit" name="btnPrev" value="prev">
					</input>
					<input type="submit" name="btnNext" value="next">
					</input>
				</form>
			
			
			<form action="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormNew">
				<input id="btn-add-maintenance" type="submit" name="btnShowAddMaintenance" value="Add Maintenance"></input>
			</form>
			
			
			</div>
			
			<div class="legend">
				<p>Legend:</p>
				<p>Green-Bookings</p>
				<p>Blue-Maintenance</p>
			</div>
			<p>Toggle View</p>
			<form action="${pageContext.request.contextPath}/admin/viewMaintenances">
				<input id="btn-show-maintenances" type="submit" name="btnShowMaintenances" value="Display Maintenance"></input>
			</form>
			<form action="${pageContext.request.contextPath}/admin/viewBookings">
				<input id="btn-show-bookings" type="submit" name="btnShowBookings" value="Display Bookings"></input>
			</form>
		</div>
					
					
		<table style="width: 100%;">
			<c:forEach var="day" items="${sessionScope.daysOfWeek}">
				<td style="border: 1px solid black; float: left; width: 13%; background-color:#FFD700;">${day}</td>
			</c:forEach>
		</table>
		
		<c:forEach begin="0" end="34" varStatus="loop">
			<div class="calendar-tile"
				style="border: 1px solid black; float: left; width: 13%; height: 15%;">

				<c:if test="${sessionScope.currentFirstDayIndex-loop.index<=0 && loop.index-sessionScope.currentFirstDayIndex+1<=sessionScope.lastDayOfCurrentMonth}">
					<p class="day-header">${loop.index-sessionScope.currentFirstDayIndex+1}</p>
				
					<div class="calendar-tile-content">
						<c:forEach var="booking" items="${sessionScope.bookingViewList}">
						<fmt:parseDate var="thisDate" value="${sessionScope.currentYear}-${sessionScope.currentMonth}-${loop.index-sessionScope.currentFirstDayIndex+1}" pattern="yyyy-MM-dd" />
						<fmt:parseDate var="bookingDate" value="${booking.getBookingdate()}" pattern="yyyy-MM-dd" />
		
							<c:if
								test="${bookingDate==thisDate}">

					            <a href="${pageContext.request.contextPath}/admin/viewBookings/editBooking/${booking.getBookingid()}">
								<button id="${booking.getBookingid()}" name="btnIDeditBooking" class="btn-booking-slot">${booking.getMinTime().substring(0, 4)}--${booking.getMaxTime().substring(booking.getMaxTime().length()-4)}</button></a>
							</c:if>
						</c:forEach>
						
						<c:forEach var="maintenance" items="${sessionScope.maintenanceList}">
						<fmt:parseDate var="thisDate" value="${sessionScope.currentYear}-${sessionScope.currentMonth}-${loop.index-sessionScope.currentFirstDayIndex+1}" pattern="yyyy-MM-dd" />
						<fmt:parseDate var="maintenanceStartDate" value="${maintenance.getStartdate()}" pattern="yyyy-MM-dd" />
						<fmt:parseDate var="maintenanceEndDate" value="${maintenance.getEnddate()}" pattern="yyyy-MM-dd" />
		
							<c:if test="${maintenanceStartDate==thisDate || maintenanceEndDate==thisDate}">
								 <a href="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormEdit/${maintenance.getMaintenanceid()}">
								<button id="${maintenance.getMaintenanceid()}" class="btn-maintenance-slot">
								<c:if test="${thisDate==maintenanceEndDate && maintenanceStartDate!=maintenanceEndDate}">
									0000-${maintenance.getTimeslots_end().getTime().substring(0, 4)}
								</c:if>
								
								<c:if test="${thisDate==maintenanceEndDate && maintenanceStartDate==maintenanceEndDate}">
									${maintenance.getTimeslots_start().getTime().substring(0, 4)}-${maintenance.getTimeslots_end().getTime().substring(0, 4)}
								</c:if>
								
								<c:if test="${thisDate!=maintenanceEndDate}">
									${maintenance.getTimeslots_start().getTime().substring(0, 4)}--*
								</c:if>
								</button></a>
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
