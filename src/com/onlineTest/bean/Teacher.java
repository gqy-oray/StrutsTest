package com.onlineTest.bean;

import java.util.Set;

public class Teacher extends User {
	private String id;
	private String name;
	private String password;
	// private String departId;
	private department depart;// 教师与院系是多对一的关系，也就是一个教师只属于一个院系，因此使用对象
	private String sex;
	private String phone;
	private String email;
	private Set<Course> courses;// 教师与课程是一对多的关系，也就是一个老师可以教多门课，因此使用集合

	public Teacher() {
	}

	public Teacher(String id, String name, String password, department depart, String sex, String phone, String email) {
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
