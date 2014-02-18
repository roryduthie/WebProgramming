<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FaultAdd" method="get">
		<select name="section">
			<option value="" disabled="disabled" selected="selected">Which System was Fault found?</option>
  			<option value="cassandra">Cassandra</option>
  			<option value="hadoop">Hadoop</option>
  			<option value="debian">Debian</option>
		</select>
		
		<p>Summary:</p>
		 <input type="text" name="summary" size="100"><br>
		<p>Details:<p> 
		<textarea rows="10" cols="74" name="details"></textarea><br><br>
		
		
		<select name="severity">
			<option value="" disabled="disabled" selected="selected">Severity Of Fault</option>
  			<option value="Crash: Loss of data or absent feature">Crash: Loss of data or absent feature</option>
  			<option value="Feature broken: No Workaround available">Feature broken: No Workaround available</option>
  			<option value="Feature broken: Workaround available"> Feature broken: Workaround available</option>
  			<option value="Feature Works: Could be improved">Feature Works: Could be improved</option>
		</select>
		
		<br><br>
		<input type="submit" name="submit" value="submit">
	</form>
</body>
</html>