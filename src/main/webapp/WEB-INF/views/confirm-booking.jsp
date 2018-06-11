<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Booking page</h3>

<a href="${pageContext.request.contextPath}/facilities/confirm-booking">List
	Bookings</a>
	<c:if test="${fn:length(bookingDetailsList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				
			   <th>BookingID</th>
			   <th>FacilityID</th>
			   <th>TimeslotID</th>
			   <th>time</th>
			   <th>			   
			   
			</tr>
		</thead>
		<tbody>
				<c:forEach var="bookingDetailsList" items="${bookingDetailsList}">
			
					<tr class="bookingRecord">
						<td>${bookingDetailsList.bookingid}</td>
						<td>${bookingDetailsList.facilityid}</td>
						<td>${bookingDetailsList.timeslotid}</td>
						<td>${bookingDetailsList.getTimeslot().time}</td>
						<td>${bookingDetailsList.bookingdate}</td>
					</tr>
					
				</c:forEach>
		</tbody>
	</table>
</c:if>
