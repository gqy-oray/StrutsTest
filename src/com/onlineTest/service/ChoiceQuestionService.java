package com.onlineTest.service;

import java.util.List;

public interface ChoiceQuestionService<T> {
	public List<T> findChoiceQuestion(String hql,Object...objects) throws Exception;
}
