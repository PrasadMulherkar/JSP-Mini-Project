package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.model.Customer;
import com.model.Product;

public class Dao {
	Connection connection;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBProject", "root", "shubham");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public int createUser(Customer customer) {
		int i=0;
		return i;
	}
	public int validateUser(Customer customer) {
		int i=0;
		return i;
	}
	public int addProduct(Product product) {
		int i=0;
		return i;
	}
}
