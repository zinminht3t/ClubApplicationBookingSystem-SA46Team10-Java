<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}/facilities"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<!doctype html>
<html lang="en">

<head>
	<title>Facility Booking</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/dh-row-text-image-right.css">
    <link rel="stylesheet" href="css/styles.css">
    <script src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<c:if test="${fn:length(allfacility) gt 0}">   
		<div class="container" width="60%" margin-right="10%" margin-left="10%">
			<div>
	            <div class="col-xs-12 col-sm-12 col-md-12 col-sm-pull-12" style="text-align:center" id="contactus">
	                <h1>Available Facilities</h1>
				</div>
			</div>
    		
    		</br>
    		</br>
    		
	        <c:forEach items="${allfacility}" var="facility">
	        
		        <div class="row clearmargin clearpadding row-image-txt">
			        <div class="col-xs-12 col-sm-6 col-md-6 clearmargin clearpadding col-sm-push-6"><img src="${facility.imagePath}" style="width:100%;"></div>
			        <div class="col-xs-12 col-sm-6 col-md-6 col-sm-pull-6" style="padding:20px;">
			            <h1>${facility.facilityName}</h1>
			            <hr>
			            <p>${facility.remark}</p>
			            <div style="text-align:center">
			            <a href="${pageContext.request.contextPath}/facilities/confirm-booking/${facility.facilityName}/${date}">
			            <button class="btn btn-light btn-lg" type="button">Book</button></a></div>
			        </div>
			    </div>
			    
			    </br>
			    </br>
			    </br>
			    
			</c:forEach>
	</c:if>
</body>

</html>