<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Woop</title>
</head>
<body>
	<h1> Converter</h1>
			<%
				double USD = 1.6;
				double AUD = 1.9;
				double CAD = 1.8;
			%>
			
	<table border="1" cellpadding="3">
		<% for(int pound = 10; pound <= 100; pound = pound+10){ %>
	<tr>
		<th> POUNDS </th>
		<th> USD </th>
		<th> AUD </th>
		<th> CAD </th>
	</tr>
	<tr>
		<td> <%=pound %> </td>
		<td> <%=pound*USD %> </td>
		<td> <%=pound*AUD %> </td>
		<td> <%=pound*CAD %> </td>
	
	
	</tr>
	<% } %>
	</table>
			
			
			
			
</body>
</html>