package com.neweducation.data.persistence.daos.generics;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T> extends AbstractDao<T> implements IOperations<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public T find(final long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public void create(final T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public T update(final T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	@Override
	public void deleteById(final long entityId) {
		throw new NotImplementedException("not implemented yet");
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}