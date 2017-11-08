package com.onlineTest.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.onlineTest.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public T findEntity(Class<T> entityClazz, Serializable id) throws Exception {

		return (T) sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	@Override
	public List<T> findEntitys(String hql, Object... objects) throws Exception {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(String.valueOf(i), objects[i]);
		}
		return query.list();
	}


	@Override
	public Serializable inserinto(T entity) throws Exception {
		
		return sessionFactory.getCurrentSession().save(entity);
	}


}
