<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Home.css">
<!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav
	class="navbar navbar-expand-md bg-dark navbar-dark navbar-fixed-top navbar-static-top"
	style="height: 50px; position: fixed; width: 100%; top: 0; z-index: 100; padding-top: 0; padding-bottom: 0;'">
	<!-- Brand -->
	<a class="navbar-brand" href="${contextPath}/"> <img
		src="image/springClubLogo1.png" width="50px" height="50px">
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
						href="${contextPath}/admin" id="home">Admin Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/admin/facility/list">Manage Facilities</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/admin/user/list">Manage User</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/admin/userlist">Reports</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}//admin/bm">Manage Booking</a></li>
					<li class="nav-item"><a class="btn btn-outline-danger"
						href="${contextPath}/logout">Logout</a></li>

				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/#top" id="home">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/#aboutus">About Us</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/facilities">Facilities</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/membership">Membership</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${contextPath}/#contactus">Contact Us</a></li>
					<c:choose>
						<c:when test="${sessionScope.Role == null}">

							<li class="nav-item"><a class="btn btn-outline-success"
								href="${contextPath}/login">Login</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="btn btn-outline-danger"
								href="${contextPath}/logout">Logout</a></li>

						</c:otherwise>
					</c:choose>

				</c:otherwise>
			</c:choose>

		</ul>
	</div>


</nav>

