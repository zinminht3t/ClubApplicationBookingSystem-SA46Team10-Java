<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

	<head>
		<%@include file="Header.jsp"%>
		<link rel="STYLESHEET" type="text/css" href="${ss}" />
		<link rel="stylesheet" href="css/Layout.css">
		<title>Spring Club</title>
		<dec:head />
	</head>
		
	<body id="top">
		<dec:body />
	</body>
	
	<footer>
		<%@include file="Footer.jsp"%>
	</footer>

</html>
