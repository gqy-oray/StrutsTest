package com.onlineTest.service.impl;

import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.ChoiceQuestionService;
public class ChoiceQuestionServiceImpl<T> implements ChoiceQuestionService<T>{
	private BaseDao<T> baseDao;
	
	@Override
	public List<T> findChoiceQuestion(String hql, Object... objects) throws Exception {
		return baseDao.findEntitys(hql, objects);
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	

}
