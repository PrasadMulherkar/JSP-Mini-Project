<%@page import="com.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to dashboard</title>
</head>
<body>
<h1>Customer Details</h1>
<%! Customer customer = null; %>
<%
	customer = (Customer) session.getAttribute("Customer");
%>
<%= customer.getName() %><br>
<%= customer.getMobile() %><br>
<%= customer.getEmail() %><br>
<h1>Product Details</h1>
<form action="ProductServlet" method="post">
		Product Name : <input type="text" name="prodname">
		Prdouct Price : <input type="number" name="prodprice">
		Product Quantity : <input type="number" name="prodqty">
		<input type="submit" value="Add product">
</form>
<a href="Cart.jsp">Cart</a>
<a href="Bill.jsp">Bill</a>
</body>
</html>