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
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="fonts/font-awesome.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
	<div class="container" width="80%" margin-right="10%" margin-left="10%" padding-top="120px" margin-top="120px">
		
		<div class=top-content>
		<br>
		<br>
		<br>
		<br>
		
			<h2 style = "text-align: center">Manage Bookings and Maintenance</h2>
			<hr>
			
				<div class="row">
					<div class="monthyear col-md-12" id="viewMonthYear"><h3 style = "text-align: center"><strong>${sessionScope.currentMonthName}-${sessionScope.currentYear}</strong></h3></div>
						<div class="col-md-5"></div>
						<div class="col-md-2 text-center">
						<form action="${pageContext.request.contextPath}/admin/viewCalendar"
							class="nextprev-form" method="post">
						
								<input type="submit" name="btnPrev" value="prev" class="btn-primary" />
							
							
								<input type="submit" name="btnNext" value="next" class="btn-primary" />
							
						</form>
						
						<form action="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormNew">
						<input id="btn-add-maintenance" type="submit" name="btnShowAddMaintenance" value="Add Maintenance" class="btn-warning btn-sm"></input>
					</form>
						</div>
				</div>
				
				
			
			<div class="row text-center">
				<div class="col-md-4"></div>
				<div class="col-md-1"><p>Legend:</p></div>
				<div class="col-md-1"><p style="color: Green"><strong>Green</strong> = Bookings</p></div>
				<div class="col-md-1"><p style="color: blue"><strong>Blue</strong> = Maintenance</p></div>			
			</div>
			
			<div class="row text-center">
				<div class="col-md-12"><h3>Toggle View</h3></div>
				<div class="col-md-4"></div>
				<div class="col-sm-6 col-md-2">
					<form action="${pageContext.request.contextPath}/admin/viewMaintenances">
						<input id="btn-show-maintenances" type="submit" name="btnShowMaintenances" value="Display Maintenance" class="btn-primary btn-sm"></input>
					</form>
				</div>
				<div class="col-sm-6 col-md-2">
					<form action="${pageContext.request.contextPath}/admin/viewBookings">
						<input id="btn-show-bookings" type="submit" name="btnShowBookings" value="Display Bookings" class="btn-primary btn-sm"></input>
					</form>
				</div>
			</div>
		</div>
					
		<div class="calendar-tile calendar-tile" style="overflow:Hidden;">			
			<table class="table" style="width: 100%;">
				<c:forEach var="day" items="${sessionScope.daysOfWeek}">
					<td style="border: 1px solid black; float: left; width: 13%; background-color:#FFD700; padding: 5px;">${day}</td>
				</c:forEach>
			</table>
		
			<c:forEach begin="0" end="34" varStatus="loop">
				<div class="calendar-tile" 
					style="border: 1px solid black; float: left; width: 13%; height: 15%; padding: 5px;" >
	
					<c:if test="${sessionScope.currentFirstDayIndex-loop.index<=0 && loop.index-sessionScope.currentFirstDayIndex+1<=sessionScope.lastDayOfCurrentMonth}">
						<p class="day-header">${loop.index-sessionScope.currentFirstDayIndex+1}</p>
					
						<div class="calendar-tile-content">
							<c:forEach var="booking" items="${sessionScope.bookingViewList}">
							<fmt:parseDate var="thisDate" value="${sessionScope.currentYear}-${sessionScope.currentMonth}-${loop.index-sessionScope.currentFirstDayIndex+1}" pattern="yyyy-MM-dd" />
							<fmt:parseDate var="bookingDate" value="${booking.getBookingdate()}" pattern="yyyy-MM-dd" />
			
								<c:if
									test="${bookingDate==thisDate}">
	
						            <a href="${pageContext.request.contextPath}/admin/viewBookings/editBooking/${booking.getBookingid()}">
									<button id="${booking.getBookingid()}" name="btnIDeditBooking" class="btn-booking-slot">${booking.getMinTime().substring(0, 5)}-${booking.getMaxTime().substring(booking.getMaxTime().length()-5)}</button></a>
								</c:if>
							</c:forEach>
							
							<c:forEach var="maintenance" items="${sessionScope.maintenanceList}">
							<fmt:parseDate var="thisDate" value="${sessionScope.currentYear}-${sessionScope.currentMonth}-${loop.index-sessionScope.currentFirstDayIndex+1}" pattern="yyyy-MM-dd" />
							<fmt:parseDate var="maintenanceStartDate" value="${maintenance.getStartdate()}" pattern="yyyy-MM-dd" />
							<fmt:parseDate var="maintenanceEndDate" value="${maintenance.getEnddate()}" pattern="yyyy-MM-dd" />
			
								<c:if test="${thisDate ge maintenanceStartDate && thisDate le maintenanceEndDate}">
									 <a href="${pageContext.request.contextPath}/admin/viewMaintenances/MaintenanceFormEdit/${maintenance.getMaintenanceid()}">
									<button id="${maintenance.getMaintenanceid()}" class="btn-maintenance-slot">
									
									<c:if test="${thisDate gt maintenanceStartDate && thisDate lt maintenanceEndDate}">
										09:00-20:00
									</c:if>
									
									<c:if test="${thisDate==maintenanceEndDate && maintenanceStartDate!=maintenanceEndDate}">
										09:00-${maintenance.getTimeslots_end().getTime().substring(0, 5)}
									</c:if>
									
									<c:if test="${thisDate==maintenanceEndDate && maintenanceStartDate==maintenanceEndDate}">
										${maintenance.getTimeslots_start().getTime().substring(0, 5)}-${maintenance.getTimeslots_end().getTime().substring(0, 5)}
									</c:if>
									
									<c:if test="${thisDate==maintenanceStartDate && thisDate!=maintenanceEndDate}">
										${maintenance.getTimeslots_start().getTime().substring(0, 5)}-20:00
									</c:if>
									</button></a>
								</c:if>
							</c:forEach>
						</div>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>

	<script>
		function viewBooking(id){
			$('btn-booking-slot').load('MaintenanceFormNew.jsp');
		}
	</script>
</body>


</html>
