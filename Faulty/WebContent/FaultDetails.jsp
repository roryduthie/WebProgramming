<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.abc.rory.stores.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
 <link rel="stylesheet" type="text/css" href="StyleSheet.css">
<title>Fault Details</title>
</head>
<body>
	<h1>Full Fault Details</h1>
	
	<br><br>
	
	<% 
	List<FaultsStore> faults = (List<FaultsStore>)request.getAttribute("faults");
	
		if(faults==null)
		{
			%> <p>No Faults Found </p> <%
		}else{
			
			Iterator<FaultsStore> iterator;
			
			iterator=faults.iterator();
			
			
			while(iterator.hasNext())
			{
				FaultsStore md = (FaultsStore)iterator.next();
				
				
				
			 %> 
				
				<table cellpadding="10">
		
					<tr>
						<th> Summary </th>
						<th> Details </th>
						<th> Severity </th>
		
					</tr>
					<tr>
						<td> <%=md.getFaultSummary() %> </td>
						<td> <%=md.getFaultDetails() %> </td>
						<td> <%=md.getSeverity() %> </td>
					</tr>
				
				</table>
				<br><br>
	<% 
			}
				
			
		}
	
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