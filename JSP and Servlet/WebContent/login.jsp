<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		Name:<input type="text" name="username" /><br /> <br /> 
		Password:<input type="password" name="password" /><br />
		<div>
			<%String s = (String) request.getAttribute("logmsg");%>
			<p style="color: red">
				<%if (s != null) {%>
					<%=s%>
				<%}%>	
			</p>
		</div>
		<br /> 
		<input type="submit" value="Login" />
	</form>
</body>
</html>