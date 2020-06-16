package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.model.Bill;
import com.model.Customer;
import com.model.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CartServlet() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("Customer");
		double total=0, gst, finaltotal;
		Dao dao = new Dao();
		List<Product> productList = dao.getProducts(customer);
		for(Product product : productList) {
			total += product.getPrice()*product.getQuantity();
		}
		gst = total*0.18;
		finaltotal = gst + total;
		Bill bill = new Bill(gst, finaltotal, total);
		HttpSession session = request.getSession();
		session.setAttribute("ProductList", productList);
		session.setAttribute("Bill", bill);
		response.sendRedirect("Cart.jsp");
	}
}
