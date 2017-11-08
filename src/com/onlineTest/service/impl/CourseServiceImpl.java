package com.onlineTest.service.impl;

import java.io.Serializable;
import java.util.List;

import com.onlineTest.dao.BaseDao;
import com.onlineTest.service.CourseService;

public class CourseServiceImpl<T> implements CourseService<T> {
private BaseDao<T> baseDao;

		
	public BaseDao<T> getBaseDao() {
	return baseDao;
}


public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
}


	@Override
	public List<T> findHqlCurse(String hql, Object... objects) throws Exception {
		return baseDao.findEntitys(hql, objects);
	}


	@Override
	public T find(Class<T> entityClazz, Serializable id) throws Exception {
		return baseDao.findEntity(entityClazz, id);
	}

}
