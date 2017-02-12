package com.neweducation.data.persistence.daos.impl;

import org.springframework.stereotype.Repository;

import com.neweducation.data.persistence.daos.PowierzeniaWSemestrzeDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.designations.PowierzeniaWSemestrze;

@Repository
public class PowierzeniaWSemestrzeDaoImpl extends AbstractHibernateDao<PowierzeniaWSemestrze>
		implements PowierzeniaWSemestrzeDao {

	public PowierzeniaWSemestrzeDaoImpl() {
		super();

		setClazz(PowierzeniaWSemestrze.class);
	}
}
