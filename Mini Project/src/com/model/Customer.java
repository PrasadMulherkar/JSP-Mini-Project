package com.model;

public class Customer {
	//Name, Mobile, Email, UserName, Password
	
	private String Name;
	private long Mobile;
	private String Email;
	private String UserName;
	private String Password;
	public Customer(String userName, String password) {
		UserName = userName;
		Password = password;
	}
	public Customer(String name, long mobile, String email) {
		Name = name;
		Mobile = mobile;
		Email = email;
	}
	public Customer(String name, long mobile, String email, String userName, String password) {
		Name = name;
		Mobile = mobile;
		Email = email;
		UserName = userName;
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getMobile() {
		return Mobile;
	}
	public void setMobile(long mobile) {
		Mobile = mobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
