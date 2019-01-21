<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h4>
		Welcome
		<%=session.getAttribute("name")%></h4>
	<form action="logout" method="post">
		<input type="submit" value="Logout" />
	</form>
	<form action="Home" method="post">
		User-Name : <input type="text" name="username" value="<%=(String)request.getSession().getAttribute("name")%>"/><br /><br />
		Password : <input type="password" name="password" value="<%=(String)request.getSession().getAttribute("password")%>"/><br /><br />
		Nickname : <input type="text" name="nickname" value="<%=(String)request.getSession().getAttribute("nickname")%>"/><br /><br />
		City : <input type="text" name="city" value="<%=(String)request.getSession().getAttribute("city")%>"/><br /><br />
		<br />
		<%if(request.getSession().getAttribute("success") != null){ %>
			 <p>Changes saved successfully</p>
		<%}%>
		<input type="submit" value="Save" />
	</form>
</body>
</html>