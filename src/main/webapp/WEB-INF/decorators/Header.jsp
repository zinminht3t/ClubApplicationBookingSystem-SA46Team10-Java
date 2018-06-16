<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Parisienne"
	rel="stylesheet">
<link rel="icon" href="${contextPath}/image/springicon.ico"
	type="image/ico" sizes="16x16">
<link rel="stylesheet" href="${contextPath}/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/styles.css">
<script src="https://use.fontawesome.com/756b538f64.js"></script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.22.2/sweetalert2.all.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<body>
	<nav
		class="navbar navbar-expand-md bg-dark navbar-dark navbar-fixed-top navbar-static-top"
		style="height: 50px; position: fixed; width: 100%; top: 0; z-index: 100; padding-top: 0; padding-bottom: 0;'">
		<!-- Brand -->
		<a class="navbar-brand" href="${contextPath}/"> <img
			src="${contextPath}/image/springClubLogo1.png" width="50px"
			height="50px"> <label
			style="color: white; font-family: 'Parisienne', cursive; font-size: 25px;"><b>pring
					Club</b></label>
		</a>



		<!-- Toggler/collapsibe Button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon justify-content-end"></span>
		</button>

		<!-- Navbar links -->
		<div
			class="collapse navbar-fixed-top navbar-collapse justify-content-end"
			id="collapsibleNavbar">
			<!-- if logic here for admin -->
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.Role =='admin'}">

						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/reports"
							id="home">Reports</a></li>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;"
							href="${contextPath}/admin/facility/list">Manage Facilities</a></li>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/admin/user/list">Manage
								User</a></li>
						<%-- 					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/admin/userlist">Reports</a></li> --%>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;"
							href="${contextPath}/admin/viewCalendar">Manage Booking and
								Maintenances</a></li>
						<li class="nav-item"><a class="btn btn-outline-danger"
							href="${contextPath}/logout">Logout</a></li>

					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/#top" id="home">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/#aboutus">About
								Us</a></li>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/facilities">Facilities</a></li>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/membership">Membership</a></li>
						<li class="nav-item"><a class="nav-link"
							style="margin-right: 30px;" href="${contextPath}/#contactus">Contact
								Us</a></li>
						<c:choose>
							<c:when test="${sessionScope.Role == null}">

								<li class="nav-item"><a class="btn btn-outline-success"
									href="${contextPath}/login">Login</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link"
									style="margin-right: 30px;" href="${contextPath}/user/profile">Account</a></li>
								<li class="nav-item"><a class="btn btn-outline-danger"
									href="${contextPath}/logout">Logout</a></li>

							</c:otherwise>
						</c:choose>

					</c:otherwise>
				</c:choose>

			</ul>
		</div>


	</nav>
</body>
