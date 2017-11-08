package com.onlineTest.service.impl;

import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.JudgleQuesrionService;

public class JudgleQuesrionServiceImpl<T> implements JudgleQuesrionService<T> {

	private BaseDao<T> baseDao;

	@Override
	public List<T> find(String hql, Object... objects) throws Exception {

		return baseDao.findEntitys(hql, objects);
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

}
