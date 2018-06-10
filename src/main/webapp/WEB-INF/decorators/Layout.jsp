<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@include file="Header.jsp"%>
<dec:head/>
</head>
<body>

<table style="width: 100%">
		<tr>
			<td style="width: 180; border: 1" valign="top">
				<div>
					
					<%@ include file="Menu.jsp"%>
				</div>
			</td>
			<td>
				<div>
					<dec:body />
				</div>
			</td>
		</tr>
	</table>
	
	<!-- ======== Footer ======== -->
				<div id="footer" align="center">
				  <hr>
					<small> &copy; ISS NUS SA42 2016 </small>
				</div>
</body>
</html>
