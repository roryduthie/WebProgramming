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
<title>Insert title here</title>
</head>
<body>
	<br><br>
	
	
		<% 
	List<FaultsStore> faults = (List<FaultsStore>)request.getAttribute("list");
	
		if(faults==null)
		{
			%> <p>No Faults Found </p> <%
		}else{
			
			Iterator<FaultsStore> iterator;
			
			iterator=faults.iterator();
			
			
			while(iterator.hasNext())
			{
				FaultsStore md = (FaultsStore)iterator.next();
				
				System.out.println(md.getFaultid());
				
			 %> 
				
				
				
				
				<p> <%=md.getFaultSummary() %>   <%=md.getFaultDetails() %> </p>
				<% 
			}
				
			
		}
	%>
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