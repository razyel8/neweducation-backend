package com.neweducation.data.services;

import org.springframework.transaction.annotation.Transactional;

import com.neweducation.data.persistence.daos.generics.IOperations;

@Transactional(value = "hibernateTransactionManager")
public abstract class AbstractHibernateService<T> extends AbstractService<T> implements IOperations<T> {

	@Override
	public T find(final long id) {
		return super.find(id);
	}

	@Override
	public void create(final T entity) {
		super.create(entity);
	}

	@Override
	public T update(final T entity) {
		return super.update(entity);
	}

	@Override
	public void deleteById(final long entityId) {
		super.deleteById(entityId);
	}

}
