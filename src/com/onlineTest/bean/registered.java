package com.onlineTest.bean;

public class registered {
	private String id;
	private String password;
	private String rePass;
	private String career;
	
	public registered() {
	}
	public registered(String id,String password,String rePass,String career) {
		this.id=id;
		this.password=password;
		this.rePass=rePass;
		this.career=career;
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
	public String getRePass() {
		return rePass;
	}
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}

	
}
