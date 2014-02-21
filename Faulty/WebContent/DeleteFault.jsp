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
		
		List<String> faults = (List<String>)request.getAttribute("faults");
		List<String> id = (List<String>)request.getAttribute("id");
		//String id = request.getParameter("id").toString();
	
		if(faults==null)
		{
			%> <p>No Names Found </p> <%
		}else{
			
			Iterator<String> iterator;
			Iterator<String> it;
			
			iterator=faults.iterator();
			it = id.iterator();
			%> 
			<form action="DeleteFault" method="get">
				<select name="id"> 
				<option value="" disabled="disabled" selected="selected">Select A Fault To Delete?</option>
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
			
			<input type="submit" name="submit" value="Delete Fault">
			
			
		</form>
</body>
</html>