package com.onlineTest.service;

import java.io.Serializable;
import java.util.List;

import sun.print.resources.serviceui;

public interface ScoreService<T> {
	public Serializable scoreinsert(T entity) throws Exception;

	public T findEntity(Class<T> entityClazz, Serializable id) throws Exception;

	public List<T> findHql(String hql, Object... objects) throws Exception;
}
