package com.onlineTest.service.impl;

import java.io.Serializable;
import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.TestPageService;

public class TestPageServiceImpl<T> implements TestPageService<T> {
	private BaseDao<T> baseDao;

	@Override
	public Serializable createPage(T entity) throws Exception {
		return baseDao.inserinto(entity);
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<T> find(String hql, Object... objects) throws Exception {
		return baseDao.findEntitys(hql, objects);
	}

}
