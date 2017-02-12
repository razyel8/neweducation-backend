package com.neweducation.data.persistence.daos.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neweducation.data.persistence.daos.PowierzenieDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.designations.StatusPowierzenia;
import com.neweducation.data.persistence.entities.general.Powierzenie;
import com.neweducation.data.persistence.entities.general.Sondaz;
import org.springframework.stereotype.Repository;

/**
 * Created by Maciej Wolański maciekwski@gmail.com on 08.02.2017.
 */
@Repository
public class PowierzenieDaoImpl extends AbstractHibernateDao<Powierzenie> implements PowierzenieDao {

	public PowierzenieDaoImpl() {
		super();

		setClazz(Powierzenie.class);
	}

	@Override
	public void updateDesignationStatus(int designationId, StatusPowierzenia status) {
		Powierzenie pow = this.find(designationId);
		pow.setStatusPowierzenia(status);
		if (status == StatusPowierzenia.Zaakceptowane) {
			pow.setDataAkceptacji(new Date().toString()); // TODO: Formatter
		}
	}

	@Override
	public List<Powierzenie> getAllDesignationsOfUserInSemester(long userId, long semesterId) {
		return this.getCurrentSession().getNamedQuery("Powierzenie.getAllDesignationsOfUserInSemester")
				.setParameter("userId", userId).setParameter("semesterId", semesterId).list();
	}
}
