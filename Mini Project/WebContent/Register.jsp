<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="styl.css" />
</head>
<body>
<%! String str = null; %>
<% if(!session.isNew()) {
		Object object = session.getAttribute("Register");
		if(object != null) {
			str = (String) object;
			%>
				<h2 style="text-align: center;"><%= str %></h2>			
			<%
		}
} %>
<div class="registerbox">
   
        <h1>Register Here</h1>
        <form action="RegisterServlet" method="post">
            <p>Name</p>
            <input type="text" name="name" placeholder="Enter your name">
            
            <p>Mobile No</p>
            <input type="number" name="mobileno" placeholder="Enter Number">
            
            <p>Email id</p>
            <input type="text" name="email" placeholder="Enter your Email">
            
            <p>User Name</p>
            <input type="text" name="username" placeholder="User id">
            
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">
            
            <input type="submit" value="Register">
            
        </form>
        <a href="Login.jsp">Login Here</a><br>
            <a href="Home.jsp">Home</a>
        
    </div>
<!--  <form action="RegisterServlet">
		Name : <input type="text" name="name">
		Mobile No. : <input type="number" name="mobileno">
		Email ID : <input type="email" name="email">
		UserName : <input type="text" name="username">
		Password : <input type="password" name="password">
		<input type="submit" value="Register">
</form>
<a href="Home.jsp">Home</a>
<a href="Login.jsp">Login</a>
-->
</body>
</html>
