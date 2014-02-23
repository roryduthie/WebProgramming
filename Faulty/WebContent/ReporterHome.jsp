<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
 <link rel="stylesheet" type="text/css" href="StyleSheet.css">
<title>Reporter Home</title>
</head>
<body>
		<h1>Reporter Homepage</h1>
		
	<div id="Username" >
	<%
		String a=session.getAttribute("username").toString();
		String b=session.getAttribute("section").toString();
		out.println("Logged In As:  "+a); 
	%>
	</div>
		
		
	<ul id="navigation-bar">
  		<li><a href="/Faulty/Faults"> List Faults</a></li>
 		<li><a href="Form.jsp"> Add A Fault</a></li>
  		<li><a href="ListAdmin"> List Admin</a></li>
  		<li><a href="Logout.jsp">Logout</a></li>
	</ul>

</body>
</html>