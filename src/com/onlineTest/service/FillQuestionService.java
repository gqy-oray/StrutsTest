package com.onlineTest.service;

import java.util.List;

public interface FillQuestionService<T> {
	public List<T> findFillQuestion(String hql,Object...objects) throws Exception;

}
