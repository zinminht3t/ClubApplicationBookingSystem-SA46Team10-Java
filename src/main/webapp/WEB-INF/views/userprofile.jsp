<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<spring:url value="/css/register.css" var="register" />
<link rel="STYLESHEET" type="text/css" href="${register}" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="row" style="margin-top: 100px;">

		<div class="col-md-10 offset-md-1">

			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					id="pills-home-tab" data-toggle="pill" href="#pills-home"
					role="tab" aria-controls="pills-home" aria-selected="true">Edit
						Profile</a></li>

				<li class="nav-item"><a class="nav-link" id="pills-booking-tab"
					data-toggle="pill" href="#pills-booking" role="tab"
					aria-controls="pills-booking" aria-selected="false">Upcoming
						Bookings</a></li>

				<li class="nav-item"><a class="nav-link"
					id="pills-pastbooking-tab" data-toggle="pill"
					href="#pills-pastbooking" role="tab"
					aria-controls="pills-pastbooking" aria-selected="false">Past
						Bookings</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-sub-tab"
					data-toggle="pill" href="#pills-sub" role="tab"
					aria-controls="pills-sub" aria-selected="false">Subscription</a></li>
			</ul>
			<div class="tab-content shadow-lg p-3 mb-5 bg-white rounded"
				id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">



					<div class="row" style="padding: 50px;">
						<div class="col-md-5 col-sm-12">

							<h3>Edit Profile</h3>
							<hr>
							<form:form method="POST" id="users" commandName="userProfile"
								action="e.html">

								<div class="row">
									<h4>Account</h4>
									<div class="input-group input-group-icon">
										<form:input path="fullname" type="text"
											placeholder="Full Name" />
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
										<form:input path="contactno" type="text"
											placeholder="Phone Number" />
										<div class="input-icon">
											<i class="fa fa-phone"></i>
										</div>
									</div>
									<div class="input-group input-group-icon">
										<form:input path="address" type="text" placeholder="Address" />
										<div class="input-icon">
											<i class="fa fa-location-arrow"></i>
										</div>
									</div>
									<div class="input-group input-group-icon">
										<form:input path="email" type="email"
											placeholder="Email Address" />
										<div class="input-icon">
											<i class="fa fa-envelope"></i>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-half">
										<h4>Date of Birth</h4>
										<div class="input-group input-group-icon">
											<form:input path="dateofbirth" type="date" placeholder="Date" />
											<div class="input-icon">
												<i class="fa fa-calendar"></i>
											</div>
										</div>
									</div>
									<div class="col-half">
										<h4>Gender</h4>
										<div class="input-group">
											<form:radiobutton name="gender" path="gender"
												id="gender-male" value="male"/>
											<label for="gender-male">Male</label>
											<form:radiobutton name="gender" path="gender"
												id="gender-female" value="female"/>
											<label for="gender-female">Female</label>
										</div>
									</div>
								</div>

								<div style="text-align: center">
									<input type="submit" value="Change Profile"
										class="btn btn-outline-success" />
								</div>
							</form:form>

						</div>

						<div class="col-md-2"></div>

						<div class="col-md-5 col-sm-12">
							<h3>Change Password</h3>
							<hr>
							<form:form method="POST" id="changeUserPassword" commandName="changeUserPassword"
								action="e.html">

								<h4>Password</h4>
								<div class="input-group input-group-icon">
									<form:input path="password" type="password"
										placeholder="Old Password" />
									<div class="input-icon">
										<i class="fa fa-key"></i>
									</div>
								</div>
								<div class="input-group input-group-icon">
									<form:input path="password" type="password"
										placeholder="New Password" />
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

								<div style="text-align: center">
									<input type="submit" value="Change Password"
										class="btn btn-outline-success" />
								</div>
							</form:form>


						</div>
					</div>

				</div>
				<div class="tab-pane fade" id="pills-booking" role="tabpanel"
					aria-labelledby="pills-booking-tab">...</div>
				<div class="tab-pane fade" id="pills-pastbooking" role="tabpanel"
					aria-labelledby="pills-pastbooking-tab">...</div>
				<div class="tab-pane fade" id="pills-sub" role="tabpanel"
					aria-labelledby="pills-sub-tab">...</div>
			</div>

		</div>
	</div>
	</div>
</body>
</html>