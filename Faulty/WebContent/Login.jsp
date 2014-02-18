<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginCheck" method="get">
    <p>Username:</p>
    <input type="text" name="username" align="top"><br>
	<p>Password</p>
	<input type="password" name="password" align="top"><br><br>
	<input type="submit" name="login" value="Login">
	</form>
	
	<a href="Register.jsp"> Register As Reporter Here!</a>
	<a href="DeveloperRegister.jsp"> Register As A Developer Here!</a>
	
	
</body>
</html>