<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="RegisterServlet">
		Name : <input type="text" name="name">
		Mobile No. : <input type="number" name="mobileno">
		Email ID : <input type="email" name="email">
		UserName : <input type="text" name="username">
		Password : <input type="password" name="password">
		<input type="submit" value="Register">
</form>
<a href="Home.jsp">Home</a>
<a href="Login.jsp">Login</a>
<a href="Welcome.jsp">Dashboard</a>
</body>
</html>