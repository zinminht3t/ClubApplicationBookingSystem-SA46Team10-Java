<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Sign Up Form</title>

<spring:url value="/css/register.css" var="register" />
<link rel="STYLESHEET" type="text/css" href="${register}" />


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>



</head>

<body>

<form:form method="POST" commandName="users"
	action="${pageContext.request.contextPath}/register/create.html">
	<div class="container">
		<form>
			<div class="row">
				<h4>Account</h4>
				<div class="input-group input-group-icon">
					<form:input path="fullname" type="text" placeholder="Full Name" />
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<form:input path="nric" type="text" placeholder="NRIC" />
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<form:input path="contactno" type="text" placeholder="Phone Number" />
					<div class="input-icon">
						<i class="fa fa-phone"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<form:input path="address"   type="text" placeholder="Address" />
					<div class="input-icon">
						<i class="fa fa-location-arrow"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<form:input path="email" type="email" placeholder="Email Address" />
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<form:input path="password" type="password" placeholder="Password" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Confirm Password" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-half">
					<h4>Date of Birth</h4>
					<div class="input-group">
						<div class="col-third">
							<input type="text" placeholder="DD" />
						</div>
						<div class="col-third">
							<input type="text" placeholder="MM" />
						</div>
						<div class="col-third">
							<input type="text" placeholder="YYYY" />
						</div>
					</div>
				</div>
				<div class="col-half">
					<h4>Gender</h4>
					<div class="input-group">
						<input type="radio" name="gender" value="male" id="gender-male" />
						<label for="gender-male">Male</label> <input type="radio"
							name="gender" value="female" id="gender-female" /> <label
							for="gender-female">Female</label>
					</div>
				</div>
			</div>

			<div class="row">
				<h4>Package</h4>
				<div class="input-group1">

					<c:set var="selectedPackage" value="${selectedPackage}" />
					<c:choose>
						<c:when test="${selectedPackage eq 'selectedPackage2'}">
							<input type="radio" name="chosen-package" value="package1"
								id="chosen-package-1" />
							<label for="chosen-package-1"><span>1 Year
									Membership $250</span></label>
							<input type="radio" name="chosen-package" value="package2"
								id="chosen-package-2" checked="true" />
							<label for="chosen-package-2"> <span>3 Years
									Membership $500</span></label>
						</c:when>
						<c:otherwise>
							<input type="radio" name="chosen-package" value="package1"
								id="chosen-package-1" checked="true" />
							<label for="chosen-package-1"><span>1 Year
									Membership $250</span></label>
							<input type="radio" name="chosen-package" value="package2"
								id="chosen-package-2" />
							<label for="chosen-package-2"> <span>3 Years
									Membership $500</span></label>
						</c:otherwise>
					</c:choose>
				</div>
			</div>


			<div class="row">
				<h4>Payment Details</h4>

				<div class="input-group">
					<input type="radio" name="payment-method" value="card"
						id="payment-method-card" checked="true" /> <label
						for="payment-method-card"><span><i
							class="fa fa-cc-visa"></i>Credit Card</span></label> <input type="radio"
						name="payment-method" value="paypal" id="payment-method-paypal" />
					<label for="payment-method-paypal"> <span><i
							class="fa fa-cc-paypal"></i>Paypal</span></label>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Card Number" />
					<div class="input-icon">
						<i class="fa fa-credit-card"></i>
					</div>
				</div>
				<div class="col-half">
					<div class="input-group input-group-icon">
						<input type="text" placeholder="Card CVC" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
				</div>

				<div class="col-half">
					<div class="input-group">
						<select>
							<option>Jan</option>
							<option>Feb</option>
							<option>Mar</option>
							<option>Apr</option>
							<option>May</option>
							<option>Jun</option>
							<option>Jul</option>
							<option>Aug</option>
							<option>Sep</option>
							<option>Oct</option>
							<option>Nov</option>
							<option>Dec</option>
						</select> <select>
							<option>2018</option>
							<option>2019</option>
							<option>2020</option>
							<option>2021</option>
							<option>2022</option>
						</select>
					</div>
				</div>
			</div>

			<div style="text-align: center">
				<input type="submit" value="Submit"/>
			</div>	



		</form>
	</div>



	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



	<script src="js/index.js"></script>


</form:form>

</body>

</html>

