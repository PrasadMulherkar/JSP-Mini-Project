package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.model.Customer;
import com.model.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product(request.getParameter("prodname"), Double.parseDouble(request.getParameter("prodprice")), 
										Integer.parseInt(request.getParameter("prodqty")));
		Customer customer = (Customer) request.getSession().getAttribute("Customer");
		Dao dao = new Dao();
		String str1 = null;
		int Add = dao.addProduct(product, customer.getName());
		if(Add > 0) {
			str1 = "Product added";
		}
		else {
			str1 = "Product not added";
		}
		System.out.println(str1);
		response.sendRedirect("Welcome.jsp");
	}
}