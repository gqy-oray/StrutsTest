package com.onlineTest.bean;

public class Question {
	private QuestionKey questionKey;
	private Integer type;// 1表示选择题 2填空题 3判断题
	private String answer;// 学生输入的答案
	private TestPage page;

	public Question() {
	}

	public Question(QuestionKey questionKey, Integer type, String answer, TestPage page) {
		this.questionKey = questionKey;
		this.type = type;
		this.answer = answer;
		this.page = page;

	}

	public QuestionKey getQuestionKey() {
		return questionKey;
	}

	public void setQuestionKey(QuestionKey questionKey) {
		this.questionKey = questionKey;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public TestPage getPage() {
		return page;
	}

	public void setPage(TestPage page) {
		this.page = page;
	}

}
