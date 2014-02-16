<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	
	Connection con = null;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
    
    try{
    	String stmt = "SELECT * FROM author WHERE name=? and passwrd=?";
    	
    	ps = con.prepareStatement(stmt);
    	ps.setString(1, username);
    	ps.setString(2, password);
    	
    	rs=ps.executeQuery();
    	
    	if(rs.next())
    	{
    		
    		//if((username.equals("username") && password.equals("password"))){
    			String userName=rs.getString("name")+ ""; 
    			String pass = rs.getString("passwrd")+ "";
    			String perms = rs.getString("permission");
    			session.setAttribute("username", username);
    			 
    			System.out.println(perms);
    			
    			if(perms.equals("admin"))
    			{
    				System.out.println("You Have all the permissions");
    			}
    			else
    			{
    				System.out.println("nah");
    			}
    			
    			response.sendRedirect("/Faulty/Faults");
    		//}
    		
    	}
    	else
		{
			response.sendRedirect("Login.jsp");
		}
    }
    catch(Exception e){
    	
    }
    
    con.close();
	
	
	
	
	
	
	%>

</body>
</html>