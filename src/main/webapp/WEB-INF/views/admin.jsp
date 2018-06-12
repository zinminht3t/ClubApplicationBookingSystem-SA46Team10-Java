<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<c:choose>
    <c:when test="${sessionScope.Role =='admin'}">
        can see page

<html lang="en">

<head>
<title>Admin</title>

</head>

<body>
 admin page. you must be admin
</body>

</html>
    </c:when>    
    <c:otherwise>
        Error
<%@include file="../decorators/AccessDenied.jsp"%>
</c:otherwise>
</c:choose>
