package com.onlineTest.service;

import java.io.Serializable;

public interface LoginService<T> {
	/*
	 * 登录，通过id获取一个登录对象
	 */
	public T login(Class<T> entityClazz, Serializable id) throws Exception;
}
