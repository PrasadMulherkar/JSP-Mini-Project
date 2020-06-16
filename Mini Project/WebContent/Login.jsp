<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styl.css" />
</head>
<body>
<%! String str = null; %>
<% if(!session.isNew()) {
		Object object = session.getAttribute("Login");
		if(object != null) {
			str = (String) object;
			%>
				<h2><%= str %></h2>			
			<%
		}
} %>
<div class="loginbox">
   
        <h1>Login Here</h1>
        <form action="LoginServlet" method="post">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">
            
            <input type="submit" value="Login">
            
        </form>
        <a href="Register.jsp">New User Register Here</a><br>
            <a href="Home.jsp">Home</a>
    </div>
<!--  <a href="Home.jsp">Home</a>
<a href="Register.jsp">Register</a>
<a href="Welcome.jsp">Dashboard</a>-->
</body>
</html>
