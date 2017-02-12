package com.neweducation.data.services;

import com.neweducation.data.persistence.daos.generics.IOperations;

public abstract class AbstractService<T> implements IOperations<T> {

	public T find(final long id) {
		return getDao().find(id);
	}

	public void create(final T entity) {
		getDao().create(entity);
	}

	public T update(final T entity) {
		return getDao().update(entity);
	}

	public void deleteById(final long entityId) {
		getDao().deleteById(entityId);
	}

	protected abstract IOperations<T> getDao();

}
