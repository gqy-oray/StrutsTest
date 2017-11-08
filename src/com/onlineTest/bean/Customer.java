package com.onlineTest.bean;

public class Customer {
	private String id;
	private String password;
	private String career;

	public Customer() {
	}

	public Customer(String id, String password, String career) {
		this.id = id;
		this.password = password;
		this.career = career;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

}
