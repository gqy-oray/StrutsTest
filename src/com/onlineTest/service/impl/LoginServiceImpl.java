package com.onlineTest.service.impl;

import java.io.Serializable;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.LoginService;

public class LoginServiceImpl<T> implements LoginService<T> {
	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T login(Class<T> entityClazz, Serializable id) throws Exception {
		return baseDao.findEntity(entityClazz, id);
	}

}
