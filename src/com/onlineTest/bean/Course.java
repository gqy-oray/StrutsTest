package com.onlineTest.bean;

import java.util.Set;

public class Course {
	private String id;
	private String name;
	private Integer credit;
	// private String departId;
	private department depart;
	// private String tno;
	private Teacher teacher;
	private Set<Score> scores;// 课程与成绩是一对多的关系，因为一门课可以被多个学生选，所有有多条成绩记录
	private Set<ChoiceQuestion> choiceQuestions;// 一门课有多个选择题
	private Set<FillQuestion> fillQuestions;
	private Set<JudgleQuestion> judgleQuestions;
	private Set<TestPage> pages;

	public Course() {
	}

	public Course(String id, String name, Integer credit, department depart, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.depart = depart;
		this.teacher = teacher;
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

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public department getDepart() {
		return depart;
	}

	public void setDepart(department depart) {
		this.depart = depart;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	public Set<ChoiceQuestion> getChoiceQuestions() {
		return choiceQuestions;
	}

	public void setChoiceQuestions(Set<ChoiceQuestion> choiceQuestions) {
		this.choiceQuestions = choiceQuestions;
	}

	public Set<FillQuestion> getFillQuestions() {
		return fillQuestions;
	}

	public void setFillQuestions(Set<FillQuestion> fillQuestions) {
		this.fillQuestions = fillQuestions;
	}

	public Set<JudgleQuestion> getJudgleQuestions() {
		return judgleQuestions;
	}

	public void setJudgleQuestions(Set<JudgleQuestion> judgleQuestions) {
		this.judgleQuestions = judgleQuestions;
	}

	public Set<TestPage> getPages() {
		return pages;
	}

	public void setPages(Set<TestPage> pages) {
		this.pages = pages;
	}

}
