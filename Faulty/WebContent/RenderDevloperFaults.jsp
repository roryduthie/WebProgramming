<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.abc.rory.stores.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	
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
	
	
</body>
</html>