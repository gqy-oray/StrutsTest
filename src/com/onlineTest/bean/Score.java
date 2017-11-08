package com.onlineTest.bean;



public class Score {
	private ScoreKey scoreKey;
	private Integer score;
	private Student student;
	private Course course;// 成绩与课程是多对一的关系一条成绩记录只能对应一门课程

	public Score() {
	}

	public Score(ScoreKey scoreKey, Integer score, Student student, Course course) {
		this.scoreKey = scoreKey;
		this.score = score;
		this.student = student;
		this.course = course;
	}

	public ScoreKey getScoreKey() {
		return scoreKey;
	}

	public void setScoreKey(ScoreKey scoreKey) {
		this.scoreKey = scoreKey;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

}
