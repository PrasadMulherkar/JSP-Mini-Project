<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styl.css" />
<script src="script.js"></script>
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
<header id="header" class="alt">
					
<nav>						
<ul class="links">
	
	<li><a href="Home.jsp" >Home</a></li>
	<li><a href="Login.jsp" ><button>login </button></a></li>
	<li><a href="Register.jsp" >Register here</a></li>
</ul>
</nav>
</header>
<div class="loginbox">
   
        <h1>Login Here</h1>
      <div id="error"></div>
        <form action="LoginServlet" method="post" >
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username" id="name" required>
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password" id="password" >
            
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
