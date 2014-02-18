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
		<p>Summary:</p>
		 <input type="text" name="summary" size="100"><br>
		<p>Details:<p> 
		<textarea rows="10" cols="74"></textarea><br><br>
		
		
		<select>
			<option value="" disabled="disabled" selected="selected">Severity Of Fault</option>
  			<option value="crash">Crash: Loss of data or absent feature</option>
  			<option value="noWorkAround">Feature broken: No Workaround available</option>
  			<option value="workAround"> Feature broken: Workaround available</option>
  			<option value="works">Feature Works: Could be improved</option>
		</select>
		
		<br><br>
		<input type="submit" name="submit" value="submit">
	</form>
</body>
</html>