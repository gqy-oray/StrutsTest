package com.onlineTest.bean;

import java.io.Serializable;

public class ScoreKey implements Serializable {
	private String studentId;
	private String courseId;

	public ScoreKey() {
	}

	public ScoreKey(String studentId, String courseId) {
		this.studentId = studentId;
		this.courseId = courseId;

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		//当两个对象由同一个类创建时，将obj转换成ScoreKey对象
		ScoreKey key=(ScoreKey) obj;
		if(studentId.equals(key.getStudentId())&&courseId.equals(key.getCourseId())){
			return true;
		}
		
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return studentId.hashCode()+courseId.hashCode();
	}

}
