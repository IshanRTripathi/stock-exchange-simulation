package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	private String fullname;
	private String password;
	private String email;
	
	public User() {}

	public User(int userId, String fullname, String password, String email) {
		super();
		this.userId = userId;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullname=" + fullname + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
	
	
	

}
