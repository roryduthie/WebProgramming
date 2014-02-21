<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


		<%
		List<String> names = (List<String>)request.getAttribute("names");
	
		if(names==null)
		{
			%> <p>No Names Found </p> <%
		}else{
			
			Iterator<String> iterator;
			
			iterator=names.iterator();
			%> 
			<form action="DeleteUser" method="get">
				<select name="usernames"> 
				<option value="" disabled="disabled" selected="selected">Select A User To Delete?</option>
			<% 
			
			while(iterator.hasNext())
			{
				String md = (String)iterator.next();
				
			 %> 
				
				
				<option value="<%=md%>" > <%=md %> </option>
				<% 
			}
				%> </select> <%
			
		}
	%>
	
			<input type="submit" name="submit" value="Delete User">
			
		</form>
</body>
</html>