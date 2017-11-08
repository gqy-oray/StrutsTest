package com.onlineTest.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * 通过主键查询一个实体类对象
	 * 
	 * @param entityClazz
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T findEntity(Class<T> entityClazz, Serializable id) throws Exception;

	public List<T> findEntitys(String hql, Object... objects) throws Exception;

	public Serializable inserinto(T entity) throws Exception;

}
