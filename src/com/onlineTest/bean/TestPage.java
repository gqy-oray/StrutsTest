package com.onlineTest.bean;

import java.util.Set;

public class TestPage {
	private Integer id;
	// private String studentId;
	private Student student;
	// private String courseId;
	private Course course;
	private Integer score;
	private Set<Question> questions;

	public TestPage() {
	}

	public TestPage(Integer id, Student student, Course course, int score) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}
