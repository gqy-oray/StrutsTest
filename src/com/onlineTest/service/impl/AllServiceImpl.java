package com.onlineTest.service.impl;

import java.io.Serializable;
import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.AllService;

public class AllServiceImpl<T> implements AllService<T>{
	private BaseDao<T> baseDao;

	@Override
	public List<T> findHql(String hql, Object... objects) throws Exception {
		
		return baseDao.findEntitys(hql, objects);
	}
	@Override
	public Serializable addScore(T entity) throws Exception {
		return baseDao.inserinto(entity);
	}
	
	@Override
	public Serializable sava(T entity) throws Exception {
		return baseDao.inserinto(entity);
	}
	


	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	

	

}
