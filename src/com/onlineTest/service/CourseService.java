package com.onlineTest.service;

import java.io.Serializable;
import java.util.List;

public interface CourseService<T> {
	public List<T> findHqlCurse(String hql, Object... objects) throws Exception;

	public T find(Class<T> entityClazz, Serializable id) throws Exception;
}
