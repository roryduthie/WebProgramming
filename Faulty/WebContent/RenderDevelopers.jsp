<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.abc.rory.stores.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<UserStore> names = (List<UserStore>)request.getAttribute("develops");
	
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
				
				
				<a href="FaultDeveloper?idauthor=<%=md.getId()%>" ><%=md.getUsername()%></a><br/>
				<% 
			}
				
			
		}
	%>
	

</body>
</html>