<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.abc.rory.stores.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fault Details</title>
</head>
<body>
	<h1>Full Fault Details</h1>
	
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
				
				
				
				
				<p> <%=md.getFaultSummary() %>   <%=md.getFaultDetails() %> </p>
				<% 
			}
				
			
		}
	%>
	  
</body>
</html>