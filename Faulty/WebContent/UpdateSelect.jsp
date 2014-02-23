<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
 <link rel="stylesheet" type="text/css" href="StyleSheet.css">
<title>Insert title here</title>
</head>
<body>
	<br><br>
	<%
		
		List<String> faults = (List<String>)request.getAttribute("faults");
		List<String> id = (List<String>)request.getAttribute("id");
	
		if(faults==null)
		{
			%> <p>No Names Found </p> <%
		}else{
			
			Iterator<String> iterator;
			Iterator<String> it;
			
			iterator=faults.iterator();
			it=id.iterator();
			%> 
	<form action="UpdateFault" method="get">
				<select name="id"> 
				<option value="" disabled="disabled" selected="selected">Select A Fault To Update?</option>
			<% 
			
			while(iterator.hasNext())
			{
				String md = (String)iterator.next();
				String m = (String)it.next();
				
			 %> 
				
				
				<option value="<%=m%>" > <%=md %> </option>
				<% 
			}
				%> </select> <%
			
		}
	%>
			
			
			
			
		
		
		<select name="section">
			<option value="" disabled="disabled" selected="selected">Which System was Fault found?</option>
  			<option value="cassandra">Cassandra</option>
  			<option value="hadoop">Hadoop</option>
  			<option value="debian">Debian</option>
		</select>
		
		<p>Summary:</p>
		 <input type="text" name="summary" size="100"><br>
		<p>Details:<p> 
		<textarea rows="10" cols="74" name="details"></textarea><br><br>
		
		
		<select name="severity">
			<option value="" disabled="disabled" selected="selected">Severity Of Fault</option>
  			<option value="Crash: Loss of data or absent feature">Crash: Loss of data or absent feature</option>
  			<option value="Feature broken: No Workaround available">Feature broken: No Workaround available</option>
  			<option value="Feature broken: Workaround available"> Feature broken: Workaround available</option>
  			<option value="Feature Works: Could be improved">Feature Works: Could be improved</option>
		</select>
		
		<br><br>
		<input type="submit" name="submit" value="Update Fault">
	</form>
	<br><br>
	<% 
	if(session.getAttribute("permission").toString().equals("admin"))
	{
		%> <a href="AdminHome.jsp"> Home </a> <% 
	}
	if(session.getAttribute("permission").toString().equals("developer"))
	{
		%> <a href="DeveloperHome.jsp"> Home </a> <% 
	}
	if(session.getAttribute("permission").toString().equals("reporter"))
	{
		%> <a href="ReporterHome.jsp"> Home </a> <% 
	}

%>
</body>
</html>