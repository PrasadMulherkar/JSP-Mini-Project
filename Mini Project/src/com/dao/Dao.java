package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import com.model.Product;

public class Dao {
	Connection connection;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MiniProject", "root", "shubham");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public int createUser(Customer customer) {
		connection = getConnection();
		int i=0;
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO User VALUES(?, ?, ?, ?, ?)");
			ps.setString(1, customer.getName());
			ps.setLong(2, customer.getMobile());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getUserName());
			ps.setString(5, customer.getPassword());
			i = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public int validateUser(Customer customer) {
		connection = getConnection();
		int i=0;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM User WHERE UserName=? AND Password=?");
			ps.setString(1, customer.getUserName());
			ps.setString(2, customer.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i++;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public Customer getCustomerDetails(Customer customer) {
		Customer customerDetails = null;
		ResultSet rs = null;
		connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM User WHERE UserName=?");
			ps.setString(1, customer.getUserName());
			rs = ps.executeQuery();
			rs.next();
			customerDetails = new Customer(rs.getString(1), rs.getLong(2), rs.getString(3));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return customerDetails;
	}
	public int addProduct(Product product, String custName) {
		connection = getConnection();
		int i = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Product VALUES(?, ?, ?, ?)");
			ps.setString(1, custName);
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			i = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public List<Product> getProducts(Customer customer) {
		List<Product> productList = new ArrayList<Product>();
		connection = getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product WHERE CustomerName=?");
			ps.setString(1, customer.getName());
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getString(2), rs.getDouble(3), rs.getInt(4));
				productList.add(product);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
}
