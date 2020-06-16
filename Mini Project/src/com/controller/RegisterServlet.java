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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer(request.getParameter("name"), Long.parseLong(request.getParameter("mobileno")), 
					                     request.getParameter("email"), request.getParameter("username"), request.getParameter("password"));
		Dao dao = new Dao();
		int register = dao.createUser(customer);
		String str1=null, str2=null;
		if(register > 0) {
			str1 = "Register Successful";
			str2 = "Login.jsp";
		}
		else {
			str1 = "Register Unsuccessful";
			str2 = "Register.jsp";
		}
		//System.out.println(str1);
		HttpSession session = request.getSession();
		session.setAttribute("Register", str1);
		response.sendRedirect(str2);
	}
}