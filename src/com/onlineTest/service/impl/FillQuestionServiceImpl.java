package com.onlineTest.service.impl;

import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.FillQuestionService;

public class FillQuestionServiceImpl<T> implements FillQuestionService<T> {

	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<T> findFillQuestion(String hql, Object... objects) throws Exception {
		return baseDao.findEntitys(hql, objects);
	}

}
