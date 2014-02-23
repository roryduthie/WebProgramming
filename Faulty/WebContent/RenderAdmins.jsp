<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
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
		List<UserStore> names = (List<UserStore>)request.getAttribute("Users");
	
		if(names==null)
		{
			%> <p>No Names Found </p> <%
		}else{
			
			Iterator<UserStore> iterator;
			
			iterator=names.iterator();
			
			
			while(iterator.hasNext())
			{
				UserStore md = (UserStore)iterator.next();
				
			 %> 
				
				
				<a href="FaultAdmin?idsection=<%=md.getSection()%>" ><%=md.getUsername()%></a><br/>
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