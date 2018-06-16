<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="fonts/ionicons.min.css">
		<link rel="stylesheet" href="css/Login-Form-Dark.css">
		<link rel="stylesheet" href="css/styles.css">
		<script src="js/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
	</head>
<body>
	<div class="login-dark">
		<c:choose>
			<c:when test="${sessionScope.Role == null}">
				<form:form modelAttribute="user" method="POST"
					action="${pageContext.request.contextPath}/login"
					style="opacity: 0.95;">
					<h2 class="sr-only">Login Form</h2>
					<div class="illustration">
						<img src="image/springClubLogo1.png"></img>
					</div>
					<div class="form-group">
						<spring:message code="Email / Username: " />
						<form:input class="form-control" path="email" name="email"
							required="required" />
					</div>
					<div class="form-group">
						<spring:message code="Password: " />
						<form:input class="form-control" type="password" path="password"
							name="password" />
					</div>
					<div class="form-group">
						<button class="btn btn-primary btn-block" type="submit">Log
							In</button>
					</div>
					<div class="form-group">
						<span class="label label-danger">${errormsg}</span>
					</div>
				</form:form>
			</c:when>
			<c:otherwise>
				<form:form modelAttribute="user" method="POST"
					action="${pageContext.request.contextPath}/login">
					<h1>You are already logged in!</h1>
				</form:form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>

<%-- <html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
  <head>
    <title tiles:fragment="title">Messages : Create</title>
  </head>
  <body>
    <div tiles:fragment="content">
        <form name="f" th:action="@{/login}" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <div th:if="${param.error}" class="alert alert-error">    
                    Invalid username and password.
                </div>
                <div th:if="${param.logout}" class="alert alert-success"> 
                    You have been logged out.
                </div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
    </div>
  </body>
</html> --%>