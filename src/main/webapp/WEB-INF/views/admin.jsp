<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 --%>


<%-- <%@ taglib prefix="sec" uri="<a class="vglnk" href="http://www.springframework.org/security/tags"%" rel="nofollow"><span>http</span><span>://</span><span>www</span><span>.</span><span>springframework</span><span>.</span><span>org</span><span>/</span><span>security</span><span>/</span><span>tags</span><span>"%</span></a>>
 --%><%--  <%@ taglib prefix="sec" uri="<a class="vglnk" href="http://www.springframework.org/security/tags"%" rel="nofollow"> --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ADMIN')">
            <label><a href="#">Edit this page</a> | This part is visible only to ADMIN</label>
        </sec:authorize>

 
    <br/>

        <sec:authorize access="hasRole('USER')">
            <label><a href="#">Start backup</a> | This part is visible only to one who is both ADMIN & DBA</label>
        </sec:authorize>
 