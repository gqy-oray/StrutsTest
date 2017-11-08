package com.onlineTest.bean;

public class FillQuestion {
	private String id;
	private String title;
	private String answer;
	private String analysis;
	// private String courseId;
	private Course course;

	public FillQuestion() {
	}

	public FillQuestion(String id, String title, String answer, String analysis, Course course) {
		this.id = id;
		this.title = title;
		this.answer = answer;
		this.analysis = analysis;
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
