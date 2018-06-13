<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>


<div class="container" position="center" margin="auto" width="400px"
	height="600px">
	<div class="card bg-light text-center" width="400px" height="600px">
		<div class="card-header">
			<h6>Login</h6>
		</div>
		<div class="card-body">
		
<form:form method="POST" commandName="userLogin"
	action="${pageContext.request.contextPath}/login/">
	<table class="framed" >
		<tr>
			<td colspan="3"><input name="user" type="text" size="40" /></td>
		</tr>
		<tr>
			<td colspan="3"><input name="password" size="40" type="password" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;${errormsg}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<input class="btn btn-success" name="submit" type="submit" value="submit"/></td>
			<td>
			<button name="clear" type="reset" value="r">Reset
				</button>
				</td>
		</tr>
	</table>
</form:form>

		</div>
		<div class="card-footer text-muted">
			<a href="#" style="text-decoration: none">Forget Username /
				Password?</a>

		</div>
	</div>
</div>

</html>

 --%>
 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:choose>
				<c:when test="${sessionScope.Role == null}">
				<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/login/authenticate" >
	<table class="framed" >
		<tr>
			<td>
			<spring:message code="Email / Username: " /></td>
			<td colspan="3"><form:input path="email" size="40" required="required" /></td>
		</tr>
		<tr>
			<td><spring:message code="Password: " /></td>
			<td colspan="3"><form:password path="password" size="40" required="required" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;<p class="label label-danger">${errormsg}</p></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<form:button class="btn btn-success" name="submit" type="submit" value="Login">

				</form:button></td>
			<td>
			<form:button class="btn btn-danger" name="clear" type="reset" value="Reset">

				</form:button>
				</td>
		</tr>
	</table>
</form:form>
				</c:when>
				<c:otherwise>
You are already logged in!
				</c:otherwise>
			</c:choose>



</html>