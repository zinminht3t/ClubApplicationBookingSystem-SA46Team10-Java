<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}/facilities"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<!doctype html>
<html lang="en">

<head>
<title>Facility Booking</title>

</head>

<body>
	
        <div class="container" width="60%" margin-right="10%" margin-left="10%">
            <div class="card">
            <div class="card-block text-center" id="contactus">
                <h2>Facility Bookings</h2>
            </div></div>

        <br/>
<c:if test="${fn:length(allfacility) gt 0}">       
        <c:forEach items="${allfacility}" var="facility">
            <div class="card bg-light mb-3" style="width: 100%" >
                <div class="card-header text-center">
                    <h5>Location</h5>
                </div>
                <div class="card-block" display="inline-block">
                    <img src="Images/WhatsappImage.jpeg" width="40%" float="left" display="inline-block" height="200px" styles="margin-left:0;">
                       Swimming pool
                       <p>Opening hours:  9am - 9am</p>
                       <p>Entrance Fees:  $0</p>
						<p>${facility.facilityID}</p>
						<p>${facility.facilityName}</p>
						<p>${facility.remark}</p>
						<p>${facility.price}</p>
						<p>${facility.imagePath}</p>
						<p>${facility.active}</p>
						<a href="${pageContext.request.contextPath}/facilities/confirm-booking/${facility.facilityName}/${date}">
						<button	type="button" class="btn btn-warning btn-xs">Book</button></a>
                </div>
            </div>
</c:forEach>
</c:if>
        </div>

</body>

</html>