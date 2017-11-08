package com.onlineTest.service;

import java.io.Serializable;
import java.util.List;

import com.onlineTest.bean.Course;
import com.onlineTest.bean.Question;
import com.onlineTest.bean.Student;



public interface QuestionService<T> {
	

	public List<T> find(String hql,Object...objects) throws Exception;

	

	

}
