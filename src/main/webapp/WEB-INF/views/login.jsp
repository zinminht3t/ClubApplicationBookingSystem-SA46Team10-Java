<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<div class="container" position="center" margin="auto" width="400px"
	height="600px">
	<div class="card bg-light text-center" width="400px" height="600px">
		<div class="card-header">
			<h6>Login</h6>
		</div>
		<div class="card-body">
		
			<form action="${contextPath}/login" method="POST">
	<table class="framed" >
		<tr>
			<td colspan="3"><input name="user" type="text" size="40" /></td>
		</tr>
		<tr>
			<td colspan="3"><input name="password" size="40" type="password" /></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<button class="btn btn-success" name="submit" type="submit" value="s">Submit
				</button></td>
			<td>
			<button name="clear" type="reset" value="r">Reset
				</button>
				</td>
		</tr>
	</table>
</form>
		</div>
		<div class="card-footer text-muted">
			<a href="#" style="text-decoration: none">Forget Username /
				Password?</a>

		</div>
	</div>
</div>

</html>

