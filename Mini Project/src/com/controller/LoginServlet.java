package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.model.Customer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer(request.getParameter("username"), request.getParameter("password"));
		Dao dao = new Dao();
		int login = dao.validateUser(customer);
		HttpSession session = request.getSession();
		String str1 = null, str2 = null;
		if(login > 0) {
			Customer customerDetails = dao.getCustomerDetails(customer);
			session.setAttribute("Customer", customerDetails);
			str1 = "Login Successful";
			str2 = "Welcome.jsp";
		}
		else {
			str1 = "Login Unsuccessful";
			str2 = "Login.jsp";
		}
		
		session.setAttribute("Login", str1);
		response.sendRedirect(str2);
	}
}