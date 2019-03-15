<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Przelicznik temperatur</title>
	</head>
	<body>
		<h1>Przelicznik temperatur</h1>
	
		<h2>
		<%=(Double)request.getAttribute("value")%>
		<sup>o</sup>
		<%=(String)request.getAttribute("scale")%>
		=
		<%=(Double)request.getAttribute("result")%>
		<sup>o</sup>
		<%=(String)request.getAttribute("resultScale")%>
		</h2>
	</body>
</html>