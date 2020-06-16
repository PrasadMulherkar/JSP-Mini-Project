<%@page import="com.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
<h2>Cart Details</h2>
<form action="CartServlet" method="post">
		<input type="submit" value="Get Details">
</form>
<%! List<Product> productList = null; %>
<%
	if(!session.isNew()) {
		Object object = session.getAttribute("ProductList");
		if(object != null) {
			productList = (List<Product>)object;
%>
			<table>
						<tr>
								<td>Product Name</td>
								<td>Product Price</td>
								<td>Product Quantity</td>
						</tr>
					 <% for(Product product : productList) { 
					 %>
					 	<tr>
					 			<td><%= product.getName() %></td>
								<td><%= product.getPrice() %></td>
								<td><%= product.getQuantity() %></td>
					 	</tr>
					 <%		
					 }%>
			</table>
<%
		}
	}
%>
<a href="Bill.jsp">Bill</a><br>
</body>
</html>