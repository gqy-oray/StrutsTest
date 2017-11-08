package com.onlineTest.bean;

import java.util.Set;

public class Student extends User {
	private String id;
	private String name;
	private String password;
	// private String departId;
	private department depart;// 多个学生与院系是多对一的关系，也就是一个学生属于一个院系，因此使用对象
	private String sex;
	private String phone;
	private String email;
	private Set<Score> scores;// 一个学生与成绩是一对多的关系，一个学生可以学多门课，因此有多门成绩记录
	private Set<TestPage> pages;

	public Student() {
	}

	public Student(String id, String name, String password, department depart, String sex, String phone, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.depart = depart;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public department getDepart() {
		return depart;
	}

	public void setDepart(department depart) {
		this.depart = depart;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	public Set<TestPage> getPages() {
		return pages;
	}

	public void setPages(Set<TestPage> pages) {
		this.pages = pages;
	}
	
}
