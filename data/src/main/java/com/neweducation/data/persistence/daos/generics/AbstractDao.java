package com.neweducation.data.persistence.daos.generics;

import com.google.common.base.Preconditions;

public abstract class AbstractDao<T> implements IOperations<T> {

	protected Class<T> clazz;

	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = Preconditions.checkNotNull(clazzToSet);
	}
}
