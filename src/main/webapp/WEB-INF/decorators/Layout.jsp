<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<<<<<<< HEAD
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
=======
	<head>
		<%@include file="Header.jsp"%>
		<link rel="STYLESHEET" type="text/css" href="${ss}" />
		<link rel="stylesheet" href="css/Layout.css">
		<dec:head />
	</head>
>>>>>>> branch 'master' of https://github.com/zinminht3t/SA46Team12CABProject
	
	<body id="top">
		<dec:body />
	</body>
	
	<footer>
		<%@include file="Footer.jsp"%>
	</footer>

</html>
