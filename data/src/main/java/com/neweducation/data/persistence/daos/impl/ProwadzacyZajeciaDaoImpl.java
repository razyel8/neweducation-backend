package com.neweducation.data.persistence.daos.impl;

import org.springframework.stereotype.Repository;

import com.neweducation.data.persistence.daos.ProwadzacyZajeciaDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.general.ProwadzacyZajecia;

@Repository
public class ProwadzacyZajeciaDaoImpl extends AbstractHibernateDao<ProwadzacyZajecia> implements ProwadzacyZajeciaDao {
	public ProwadzacyZajeciaDaoImpl() {
		super();

		setClazz(ProwadzacyZajecia.class);
	}
}
