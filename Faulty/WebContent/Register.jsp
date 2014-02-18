<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register As Reporter</title>
</head>
<body>
		<form action="RegisterCheck" method="get">
			<p> Email: </p>
				<input type="text" name="username"><br>
			<p>password:</p>
				<input type="text" name="password"><br><br>
				
				<input type="submit" name="register" value="register">
				
				<input type="hidden" name="permission" value="reporter">
		
		
		</form>
</body>
</html>