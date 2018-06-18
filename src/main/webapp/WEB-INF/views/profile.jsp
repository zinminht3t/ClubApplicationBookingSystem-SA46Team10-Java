<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/css/register.css" var="register" />
<link rel="STYLESHEET" type="text/css" href="${register}" />
</head>

<body>

	<c:choose>
		<c:when test="${not empty showNotification}">
			<script>
				swal('${NotiTitle}', '${NotiMessage}', 'success')
			</script>
		</c:when>
		<c:when test="${not empty showErrorNotification}">
			<script>
				swal('${NotieTitle}', '${NotieMessage}', 'error')
			</script>
		</c:when>
	</c:choose>

	<br />
	<div class="row">

		<div class="col-md-12" style="margin-top: 50px;">
			<h2 class="text-secondary text-center">
				<i class="fa fa-user"></i> User Profile
			</h2>
			<br />
		</div>

		<div class="col-md-8 offset-md-2  mb-3 shadow-lg rounded"
			style="background: white;">

			<ul class="nav nav-pills" id="pills-tab" role="tablist"
				style="margin: 10px;">
				<li class="nav-item"><a class="nav-link active"
					id="pills-home-tab" data-toggle="pill" href="#pills-home"
					role="tab" aria-controls="pills-home" aria-selected="true"><i
						class="fa fa-user"></i> Edit Profile</a></li>

				<li class="nav-item"><a class="nav-link" id="pills-booking-tab"
					data-toggle="pill" href="#pills-booking" role="tab"
					aria-controls="pills-booking" aria-selected="false"><i
						class="fa fa-book"></i> Upcoming Bookings</a></li>

				<li class="nav-item"><a class="nav-link"
					id="pills-pastbooking-tab" data-toggle="pill"
					href="#pills-pastbooking" role="tab"
					aria-controls="pills-pastbooking" aria-selected="false"><i
						class="fa fa-list-ul"></i> Past Bookings</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-sub-tab"
					data-toggle="pill" href="#pills-sub" role="tab"
					aria-controls="pills-sub" aria-selected="false"><i
						class="fa fa-id-card"></i> Subscription</a></li>
			</ul>
			<hr>
			<div class="tab-content shadow-lg p-3 mb-5 bg-white rounded"
				id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">



					<div class="row" style="padding: 20px;">
						<div class="col-md-6 col-sm-12">

							<h3>Edit Profile</h3>
							<hr>
							<form:form method="POST" id="user" modelAttribute="user"
								action="${pageContext.request.contextPath}/user/edit">

								<div class="row">
									<h4>Account</h4>
									<div class="input-group input-group-icon">
										<form:input path="fullname" type="text"
											placeholder="Full Name" required="required" />
										<div class="input-icon">
											<i class="fa fa-user"></i>
										</div>

										<form:errors path="fullname" cssStyle="color: red;" />
									</div>
									<div class="input-group input-group-icon">
										<form:input path="nric" type="text" placeholder="NRIC"
											required="required" />
										<div class="input-icon">
											<i class="fa fa-user"></i>
										</div>
										<form:errors path="nric" cssStyle="color: red;" />
									</div>
									<div class="input-group input-group-icon">
										<form:input path="contactno" type="text"
											placeholder="Phone Number" required="required" />
										<div class="input-icon">
											<i class="fa fa-phone"></i>
										</div>
										<form:errors path="contactno" cssStyle="color: red;" />
									</div>
									<div class="input-group input-group-icon">
										<form:input path="address" type="text" placeholder="Address"
											required="required" />
										<div class="input-icon">
											<i class="fa fa-location-arrow"></i>
										</div>
										<form:errors path="address" cssStyle="color: red;" />
									</div>
									<div class="input-group input-group-icon">
										<form:input path="email" type="email"
											placeholder="Email Address" required="required" />
										<div class="input-icon">
											<i class="fa fa-envelope"></i>
										</div>
										<form:errors path="email" cssStyle="color: red;" />
									</div>
								</div>
								<div class="row">
									<div class="col-half">
										<h4>Date of Birth</h4>
										<div class="input-group input-group-icon">
											<fmt:formatDate value="${userProfile.dateofbirth}"
												var="dateString" pattern="yyyy-MM-dd" />
											<form:input path="dateofbirth" type="date"
												value="${dateString}" placeholder="Date" required="required" />
											<div class="input-icon">
												<i class="fa fa-calendar"></i>
											</div>
											<form:errors path="dateofbirth" cssStyle="color: red;" />
										</div>
									</div>
									<div class="col-half">
										<h4>Gender</h4>
										<div class="input-group">
											<form:radiobutton name="gender" path="gender"
												id="gender-male" value="male" required="required" />
											<label for="gender-male">Male</label>
											<form:radiobutton name="gender" path="gender"
												id="gender-female" value="female" required="required" />
											<label for="gender-female">Female</label>
											<form:errors path="gender" cssStyle="color: red;" />
										</div>
									</div>
								</div>

								<div style="text-align: center">
									<input type="submit" value="Change Profile"
										class="btn btn-outline-success" />
								</div>
							</form:form>

						</div>

						<div class="col-md-1"></div>

						<div class="col-md-5 col-sm-12">
							<h3>Change Password</h3>
							<hr>
							<form:form method="POST" id="password" commandName="password"
								action="${pageContext.request.contextPath}/user/password">

								<h4>Password</h4>
								<div class="input-group input-group-icon">
									<form:input path="password" type="password"
										placeholder="Old Password" required="required" />
									<div class="input-icon">
										<i class="fa fa-key"></i>
									</div>
									<form:errors path="password" cssStyle="color: red;" />
								</div>
								<form:errors path="password" cssStyle="color: red;" />
								<div class="input-group input-group-icon">
									<form:input path="newpassword" type="password"
										placeholder="New Password" required="required" />
									<div class="input-icon">
										<i class="fa fa-key"></i>
									</div>
									<form:errors path="newpassword" cssStyle="color: red;" />
								</div>
								<form:errors path="newpassword" cssStyle="color: red;" />
								<div class="input-group input-group-icon">
									<form:input type="password" path="confirmpassword"
										placeholder="Confirm Password" required="required" />
									<div class="input-icon">
										<i class="fa fa-key"></i>
									</div>
									<form:errors path="confirmpassword" cssStyle="color: red;" />
								</div>
								<form:errors path="confirmpassword" cssStyle="color: red;" />

								<div style="text-align: center">
									<input type="submit" value="Change Password"
										class="btn btn-outline-success" />
								</div>
							</form:form>


						</div>
					</div>

				</div>
				<div class="tab-pane fade" id="pills-booking" role="tabpanel"
					aria-labelledby="pills-booking-tab">

					<h6 class="text-info"><i class="fa fa-info"></i> Please note that we have 3 days
						cancellation policy. So some bookings cannot be cancelled.</h6>
						<hr/>


					<c:if test="${fn:length(upcomingbookings) gt 0}">

						<c:forEach var="ubookings" items="${upcomingbookings}">


							<div class="row"
								style="padding: 40px 0px; border-bottom: 1px solid #dddddd;">



								<div class="col-md-4">
									<img src="" id="${ubookings.bookingid}uphoto"
										alt="facilityphoto" width="100%" class="rounded-circle" />
								</div>

								<div class="col-md-5">
									<div style="overflow: hidden;">
										<h4 class="float-left text-dark">
											<strong id="${ubookings.bookingid}uname"></strong>
										</h4>
									</div>

									<h4 class="text-secondary">
										<strong id="${ubookings.bookingid}udate"></strong>


									</h4>

									<div id="${ubookings.bookingid}utimeslots"></div>

									<h5>
										<em>Price : $ ${ubookings.total }.00</em>
									</h5>

									<h6 class="text-warning">Status : ${ubookings.status }</h6>


									<c:forEach var="ubookingDetail"
										items="${ubookings.getBookings()}">

										<fmt:parseDate value="${ ubookingDetail.bookingdate }"
											pattern="yyyy-MM-dd'T'HH:mm" var="ubDateTime" type="both" />
										<fmt:formatDate dateStyle="medium" timeStyle="medium"
											value="${ ubDateTime }" var="ubdate" />

										<script>
											document
													.getElementById("${ubookings.bookingid}uphoto").src = "${pageContext.request.contextPath}/image/${ubookingDetail.getFacility().getImagePath()}";
											document
													.getElementById("${ubookings.bookingid}uname").innerHTML = "${ubookingDetail.getFacility().getFacilityName()}";
											document
													.getElementById("${ubookings.bookingid}udate").innerHTML = "${ubdate}";
											document
													.getElementById("${ubookings.bookingid}utimeslots").innerHTML += "<span class=\"badge badge-info\">${ubookingDetail.getTimeslot().getTime()}</span> &nbsp;&nbsp;"
										</script>
									</c:forEach>
								</div>

								<div class="col-md-3">


									<em><i class="fa fa-stopwatch"></i> <fmt:parseDate
											value="${ ubookings.transactiontime }"
											pattern="yyyy-MM-dd'T'HH:mm" var="uDateTime" type="both" />
										<fmt:formatDate dateStyle="medium" timeStyle="medium"
											type="both" value="${ uDateTime }" /> </em> <br /> <br /> <br />
									<c:choose>
										<c:when test="${ubookings.status =='CONFIRMED'}">
											<button id="${ubookings.bookingid}cancelbookingbtn"
												class="btn btn-outline-danger">
												<i class="fa fa-ban"></i> Cancel Booking
											</button>

											<script>
											 	document.getElementById("${ubookings.bookingid}cancelbookingbtn").addEventListener('click',function ()
													{
														swal({
															  title: 'Booking Cancellation',
															  text: "Are you sure you want to cancel booking!",
															  type: 'warning',
															  showCancelButton: true,
															  confirmButtonColor: '#3085d6',
															  cancelButtonColor: '#d33',
															  confirmButtonText: 'Yes, I am Sure!'
															}).then((result) => {
															  if (result.value) {
																  window.location.href = "${pageContext.request.contextPath}/user/booking/cancel/${ubookings.bookingid}";
															  }
															});
													}); 
											</script>
										</c:when>
									</c:choose>
								</div>
							</div>

						</c:forEach>


					</c:if>



				</div>
				<div class="tab-pane fade" id="pills-pastbooking" role="tabpanel"
					aria-labelledby="pills-pastbooking-tab">

					<c:if test="${fn:length(pastbookings) gt 0}">

						<c:forEach var="bookings" items="${pastbookings}">


							<div class="row"
								style="padding: 40px 0px; border-bottom: 1px solid #dddddd;">
								<div class="col-md-4">
									<img src="" id="${bookings.bookingid}photo" alt="facilityphoto"
										width="100%" class="rounded-circle" />
								</div>
								<div class="col-md-5">
									<div style="overflow: hidden;">
										<h4 class="float-left text-dark">
											<strong id="${bookings.bookingid}name"></strong>
										</h4>
									</div>
									<h4 class="text-secondary">
										<strong id="${bookings.bookingid}date"></strong>
									</h4>
									<div id="${bookings.bookingid}timeslots"></div>
									<h5>
										Price : $ ${bookings.total }.00</em>
									</h5>
									<h6 class="text-warning">Status : ${bookings.status }</h6>
									<c:forEach var="bookingDetail"
										items="${bookings.getBookings()}">

										<fmt:parseDate value="${ bookingDetail.bookingdate }"
											pattern="yyyy-MM-dd'T'HH:mm" var="bDateTime" type="both" />
										<fmt:formatDate dateStyle="medium" timeStyle="medium"
											value="${ bDateTime }" var="bdate" />

										<script>
											document
													.getElementById("${bookings.bookingid}photo").src = "${pageContext.request.contextPath}/image/${bookingDetail.getFacility().getImagePath()}";

											document
													.getElementById("${bookings.bookingid}name").innerHTML = "${bookingDetail.getFacility().getFacilityName()}";
											document
													.getElementById("${bookings.bookingid}date").innerHTML = "${bdate}";
											document
													.getElementById("${bookings.bookingid}timeslots").innerHTML += "<span class=\"badge badge-info\">${bookingDetail.getTimeslot().getTime()}</span> &nbsp;&nbsp;"
										</script>
									</c:forEach>

								</div>

								<div class="col-md-3">



									<em><i class="fa fa-stopwatch"></i> <fmt:parseDate
											value="${ bookings.transactiontime }"
											pattern="yyyy-MM-dd'T'HH:mm" var="DateTime" type="both" /> <fmt:formatDate
											dateStyle="medium" timeStyle="medium" type="both"
											value="${ DateTime }" /> </em>

								</div>
							</div>

						</c:forEach>


					</c:if>

				</div>
				<div class="tab-pane fade" id="pills-sub" role="tabpanel"
					aria-labelledby="pills-sub-tab">

					<div class="row">
						<div class="col-md-12">
							<c:choose>
								<c:when test="${subpackage.packageyears=='1 Year'}">
									<img
										src="${pageContext.request.contextPath}/image/Membership-Bronze-1.png"
										width="40%" class="mx-auto d-block">
									<br />
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/image/Membership-Gold.png"
										width="40%" class="mx-auto d-block">
									<br />
								</c:otherwise>
							</c:choose>
						</div>
						<hr />

						<div class="col-md-6 offset-md-3">


							<em>Your membership progress is : </em>

							<div class="progress">
								<c:choose>
									<c:when test="${percentage < 10}">
										<div class="progress-bar progress-bar-striped bg-danger"
											role="progressbar" style="width: ${percentage }%"
											aria-valuenow="${percentage }" aria-valuemin="0"
											aria-valuemax="100">${percentage }%</div>
									</c:when>
									<c:when test="${percentage > 90}">
										<div class="progress-bar progress-bar-striped bg-success"
											role="progressbar" style="width: ${percentage }%"
											aria-valuenow="${percentage }" aria-valuemin="0"
											aria-valuemax="100">${percentage }%</div>
									</c:when>
									<c:otherwise>
										<div class="progress-bar progress-bar-striped bg-warning"
											role="progressbar" style="width: ${percentage }%"
											aria-valuenow="${percentage }" aria-valuemin="0"
											aria-valuemax="100">${percentage }%</div>
									</c:otherwise>
								</c:choose>
							</div>

							<br />

							<div class="card">
								<div class="card-body">
									<h5 class="card-title text-success">${subpackage.packageyears}
										Membership</h5>

									<c:choose>
										<c:when test="${dayleft <= 0}">
											<h6 class="card-subtitle mb-2 text-danger">Your account
												has already been expired! Please Renew!</h6>
										</c:when>
										<c:otherwise>
											<em class="card-subtitle mb-2 text-info">Your
												Subscription will be expired in ${dayleft } days</em>
										</c:otherwise>
									</c:choose>
									<br />
									<p class="card-text">You have these privileges</p>
									<ul class="card-text">
										<c:choose>
											<c:when test="${subpackage.packageyears=='1 Year'}">
												<li>ACCESS TO BOOKING FACILITIES</li>
												<li>DISCOUNTS AT VARIOUS RESTAURANTS</li>


											</c:when>
											<c:otherwise>
												<li>PERSONAL CHAUFFEUR</li>
												<li>ACCESS TO BOOKING PRIVATE AUDITORIUM</li>
											</c:otherwise>
										</c:choose>
									</ul>
									<hr />
									<div id="renewbuttondiv">
										<button id="renew"
											class="btn btn btn-outline-success float-right">Renew
											Membership</button>
									</div>
									<div id="renewdiv" style="display: none;">
										<h6>Choose Package</h6>
										<a
											href="${pageContext.request.contextPath}/user/renewmembership/${oneYearPackage.packageid}"
											class="btn btn-info"><i class="fa fa-cube"></i> 1 Year :
											${oneYear}</a> <a
											href="${pageContext.request.contextPath}/user/renewmembership/${threeYearsPackage.packageid}"
											class="btn btn-success"><i class="fa fa-cubes"></i> 3
											Years : ${threeYears}</a>


										<button id="cancelbtn" class="btn btn-danger float-right">
											<i class="fa fa-close"></i>
										</button>
									</div>


								</div>
							</div>
						</div>



						<script>
							$(document).ready(function() {
								$("#renew").click(function() {
									$("#renew").hide();
									$("#renewdiv").show();
								});
								$("#cancelbtn").click(function() {
									$("#renew").show();
									$("#renewdiv").hide();
								});
							});
						</script>
					</div>


				</div>
			</div>

		</div>
	</div>
</body>
</html>