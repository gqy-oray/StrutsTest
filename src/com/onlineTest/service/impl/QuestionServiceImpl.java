package com.onlineTest.service.impl;

import java.io.Serializable;
import java.util.List;

import com.onlineTest.bean.Course;
import com.onlineTest.bean.Question;
import com.onlineTest.bean.Student;
import com.onlineTest.dao.BaseDao;
import com.onlineTest.dao.impl.BaseDaoImpl;
import com.onlineTest.service.QuestionService;

public class QuestionServiceImpl<T> implements QuestionService<T> {

	private BaseDao<T> baseDao;

	@Override
	public List<T> find(String hql, Object... objects) throws Exception {
		return baseDao.findEntitys(hql, objects);
	}

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

}
