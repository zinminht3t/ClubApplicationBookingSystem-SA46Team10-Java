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

	<form:form method="POST" commandName="user"
		action="${pageContext.request.contextPath}/register/${selectedPackage}.html">
		<div class="container">
			<form>
				<div class="row">
					<h4>Account</h4>
					<div class="input-group input-group-icon">
						<form:input path="fullname" type="text" placeholder="Full Name" />
						<form:errors path="fullname" cssStyle="color: red;" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<form:input path="nric" type="text" placeholder="NRIC" />
						<form:errors path="nric" cssStyle="color: red;" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<form:input path="contactno" type="number"
							placeholder="Phone Number" />
						<form:errors path="contactno" cssStyle="color: red;" />
						<div class="input-icon">
							<i class="fa fa-phone"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<form:input path="address" type="text" placeholder="Address" />
						<form:errors path="address" cssStyle="color: red;" />
						<div class="input-icon">
							<i class="fa fa-location-arrow"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<form:input path="email" type="email" placeholder="Email Address" />
						<form:errors path="email" cssStyle="color: red;" />
						<div class="input-icon">
							<i class="fa fa-envelope"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<form:input path="password" type="password" placeholder="Password"
							id="password" required="required" />
						<form:errors path="password" cssStyle="color: red;" />
						<div class="input-icon">
							<i class="fa fa-key"></i>
						</div>
					</div>
					<div class="input-group input-group-icon">
						<input type="password" placeholder="Confirm Password"
							id="confirm_password" required />
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
								<input type="text" placeholder="DD" required name="dayOfBirth"/>								
							</div>
							<div class="col-third">
								<input type="text" placeholder="MM" required name="monthOfBirth"/>
							</div>
							<div class="col-third">
								<input type="text" placeholder="YYYY" required name="yearOfBirth"/>
							</div>
						</div>
					</div>
					<div class="col-half">
						<h4>Gender</h4>
						<div class="input-group">
							<form:radiobutton path="gender" value="Male" label="Male" /> 							
							<form:radiobutton path="gender" value="Female" label="Female"/>
							<form:errors path="gender" cssStyle="color: red;" />
						</div>
					</div>
				</div>

				<div class="row">
					<h4>Package</h4>
					<div class="input-group">
						<c:set var="selectedPackage" value="${selectedPackage}" />
						<c:choose>
							<c:when test="${selectedPackage eq 'selectedPackage2'}">
								<input type="radio" name="chosen-package" value="package1"
									id="chosen-package-1" />
								<label for="chosen-package-1"><span>1 Year
										Membership ${oneYear}</span></label>
								<input type="radio" name="chosen-package" value="package2"
									id="chosen-package-2" checked="true" />
								<label for="chosen-package-2"> <span>3 Years
										Membership ${threeYears}</span></label>
							</c:when>
							<c:otherwise>
								<input type="radio" name="chosen-package" value="package1"
									id="chosen-package-1" checked="true" />
								<label for="chosen-package-1"><span>1 Year
										Membership ${oneYear}</span></label>
								<input type="radio" name="chosen-package" value="package2"
									id="chosen-package-2" />
								<label for="chosen-package-2"> <span>3 Years
										Membership ${threeYears}</span></label>
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
						<input type="text" placeholder="Card Number" required />
						<div class="input-icon">
							<i class="fa fa-credit-card"></i>
						</div>
					</div>
					<div class="col-half">
						<div class="input-group input-group-icon">
							<input type="text" placeholder="Card CVC" required />
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

				<div class="row" style="text-align: center">
					<input type="submit" value="Submit" />
				</div>



			</form>
		</div>

		<script>
			var password = document.getElementById("password"), confirm_password = document
					.getElementById("confirm_password");

			function validatePassword() {
				if (password.value != confirm_password.value) {
					confirm_password.setCustomValidity("Passwords Don't Match");
				} else {
					confirm_password.setCustomValidity('');
				}
			}

			password.onchange = validatePassword;
			confirm_password.onkeyup = validatePassword;
		</script>


		<script
			src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>



		<script src="js/index.js"></script>


	</form:form>

</body>

</html>

