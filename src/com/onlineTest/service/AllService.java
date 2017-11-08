package com.onlineTest.service;

import java.io.Serializable;
import java.util.List;

public interface AllService<T> {
	
	public List<T> findHql(String hql,Object...objects) throws Exception;
	
	/**
	 * 选课以后添加在成绩表中
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Serializable addScore(T entity) throws Exception;
	public Serializable sava(T entity) throws Exception;
	
	

}
