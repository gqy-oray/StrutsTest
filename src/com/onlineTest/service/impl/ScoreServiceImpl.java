package com.onlineTest.service.impl;

import java.io.Serializable;
import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.ScoreService;

public class ScoreServiceImpl<T> implements ScoreService<T> {
	private BaseDao<T> baseDao;

	@Override
	public Serializable scoreinsert(T entity) throws Exception {
		return baseDao.inserinto(entity);
	}

	@Override
	public List<T> findHql(String hql, Object... objects) throws Exception {
		return baseDao.findEntitys(hql, objects);
	}
	
	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T findEntity(Class<T> entityClazz, Serializable id) throws Exception {
		return baseDao.findEntity(entityClazz, id);
	}


	
	
}
