package com.onlineTest.service;

import java.io.Serializable;
import java.util.List;

public interface TestPageService<T> {
	public Serializable createPage(T entity)throws Exception;
	public List<T> find(String hql,Object...objects) throws Exception;

}
