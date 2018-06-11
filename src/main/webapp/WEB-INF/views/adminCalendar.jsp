<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Bookings List page</h3>

<a href="${pageContext.request.contextPath}/admin/bm/calendar">List
	Bookings</a>
	<c:if test="${fn:length(bookingList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				
			   <th>Booking Id</th>
			   <th>Transaction Time</th>
			   <th>User Id</th>
			   <th>User Name</th>
			   <th>Total ($)</th>
			   <th>Booking Status</th>				   
   			   <th>Facility Name</th>				   
   			   <th>Booked Time</th>				   
			   
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bookings" items="${bookingList}">
				<c:forEach var="bookingDetail" items="${bookings.getBookings()}">
			
					<tr class="bookingRecord">
						<td>${bookings.bookingid}</td>
						<td>${bookings.transactiontime}</td>
						<td>${bookings.getUser().userId}</td>
						<td>${bookings.getUser().fullname}</td>
						<td>${bookings.total}</td>
						<td>${bookings.status}</td>
						<td>${bookingDetail.getFacility().getFacilityName()}</td>
						<td>${bookingDetail.getTimeslot().getTime()}</td>	
					</tr>
					
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
</c:if>
