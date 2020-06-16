<%@page import="com.model.Bill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="Cart.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill</title>
</head>
<body>
Bill Details
<%! Bill bill = null; %>
<%
	if(!session.isNew()) {
		Object object = session.getAttribute("Bill");
		if(object != null) {
			bill = (Bill) object;
%>
			<table border="1">
						<tr>
								<td>Bill Amount</td>
								<td>GST Amount</td>
								<td>Total Amount</td>
						</tr>
					 	<tr>
					 			<td><%= bill.getTotal() %></td>
								<td><%= bill.getGst() %></td>
								<td><%= bill.getFinal() %></td>
					 	</tr>
					 
			</table>
<%
		}
	}
%>
<a href="Welcome.jsp">Dashboard</a>
</body>
</html>