package com.onlineTest.bean;

import java.io.Serializable;

public class QuestionKey implements Serializable {
	private String questionId;
	private Integer pageId;
	public QuestionKey() {
	}
	
	public QuestionKey(String questionId,Integer pageId) {
		this.questionId=questionId;
		this.pageId=pageId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		QuestionKey key=(QuestionKey) obj;
		if(questionId.equals(key.questionId)&&pageId==key.pageId){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return questionId.hashCode()+pageId;
	}
	
	
	
	

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	
	
	
}
