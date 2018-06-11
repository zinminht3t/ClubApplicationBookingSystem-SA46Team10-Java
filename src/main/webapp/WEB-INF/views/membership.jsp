<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Membership</title>

<spring:url value="/css/member.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />

</head>
<body>
	<form:form method="POST" action="${pageContext.request.contextPath}/register">
		<div class="background">
			<div class="container">
				<div class="panel pricing-table">

					<div class="pricing-plan">
						<img src="image/Membership-Bronze-1.png" alt=""
							class="pricing-img">
						<h2 class="pricing-header">1 Year Membership</h2>
						<ul class="pricing-features">
							<li class="pricing-features-item">Access to Booking
								Facilities</li>
							<li class="pricing-features-item">Discounts at various
								Restaurants</li>
						</ul>
						<span class="pricing-price">$250</span> <a
							href="${pageContext.request.contextPath}/register/selectedPackage1"
							class="pricing-button">Sign up</a>
					</div>


					<div class="pricing-plan">
						<img src="image/Membership-Gold.png" alt="" class="pricing-img">
						<h2 class="pricing-header">3 Years Membership</h2>
						<ul class="pricing-features">
							<li class="pricing-features-item">Personal Chauffeur</li>
							<li class="pricing-features-item">Access to Booking Private
								Auditorium</li>
						</ul>
						<span class="pricing-price">$500</span> <a
							href="${pageContext.request.contextPath}/register/selectedPackage2"
							class="pricing-button">Sign up</a>
					</div>

				</div>
			</div>
		</div>

	</form:form>


</body>
</html>
