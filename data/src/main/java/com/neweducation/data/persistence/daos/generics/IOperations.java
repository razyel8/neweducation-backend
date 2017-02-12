package com.neweducation.data.persistence.daos.generics;

public interface IOperations<T> {

	void create(final T entity);

	T find(final long id);

	T update(final T entity);

	void deleteById(final long entityId);

}
