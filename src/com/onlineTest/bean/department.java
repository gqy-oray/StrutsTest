package com.onlineTest.bean;

import java.util.Set;

public class department {
	private String id;
	private String name;
	private Set<Student> students;// 院系与学生是一对多的关系，因此一个院系下面由多个学生所以使用对象集
	private Set<Teacher> teachers;
	private Set<Course> courses;

	public department() {
	}

	public department(String id, String name) {
		this.id = id;
		this.name = name;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
