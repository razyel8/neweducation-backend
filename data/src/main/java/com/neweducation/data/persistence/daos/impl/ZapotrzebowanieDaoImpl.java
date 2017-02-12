package com.neweducation.data.persistence.daos.impl;

import org.springframework.stereotype.Repository;

import com.neweducation.data.persistence.daos.ZapotrzebowanieDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.designations.Zapotrzebowanie;

@Repository
public class ZapotrzebowanieDaoImpl extends AbstractHibernateDao<Zapotrzebowanie> implements ZapotrzebowanieDao {
	public ZapotrzebowanieDaoImpl() {
		super();

		setClazz(Zapotrzebowanie.class);
	}
}