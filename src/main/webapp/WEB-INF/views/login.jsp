<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<%-- <form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/home/authenticate" >
	<table class="framed" >
		<tr>
			<td>
			<spring:message code="fieldLabel.username" /></td>
			<td colspan="3"><form:input path="name" size="40" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.password" /></td>
			<td colspan="3"><form:password path="password" size="40" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<form:button name="submit" type="submit" value="s">
					<img src="${pageContext.request.contextPath}/image/button_login.gif" alt="" align="middle">
				</form:button></td>
			<td>
			<form:button name="clear" type="reset" value="r">
					<img src="${pageContext.request.contextPath}/image/button_clear.gif" alt="" align="middle">
				</form:button>
				</td>
		</tr>
	</table>
</form:form> --%>

<div class="container" position="center" margin="auto" width="400px" height="600px">
        <div class="card bg-light text-center" width="400px" height="600px">
                <div class="card-header">
                    <h6>Login</h6>
                </div>
                <div class="card-body">
                    <p class="card-text">Replace with Login form</p>
                    <a href="#" class="btn btn-success">Login</a>
                </div>
                <div class="card-footer text-muted">
                    <a href="#" style="text-decoration: none">Forget Username / Password?</a>
        
                </div>
                </div>
                </div>

</html>

