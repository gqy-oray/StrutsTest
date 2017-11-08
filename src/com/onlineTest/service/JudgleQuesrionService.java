package com.onlineTest.service;

import java.util.List;

public interface JudgleQuesrionService<T> {
	public List<T> find(String hql,Object...objects) throws Exception;

}
