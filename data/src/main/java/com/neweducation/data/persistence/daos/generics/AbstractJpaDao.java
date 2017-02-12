package com.neweducation.data.persistence.daos.generics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJpaDao<T> extends AbstractDao<T> implements IOperations<T> {

	@PersistenceContext
	private EntityManager em;

	// API

	@Override
	public T find(final long id) {
		return em.find(clazz, Long.valueOf(id).intValue());
	}

	@Override
	public void create(final T entity) {
		em.persist(entity);
	}

	@Override
	public T update(final T entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(long id) {
		this.em.remove(this.em.getReference(clazz, id));
	}

}
