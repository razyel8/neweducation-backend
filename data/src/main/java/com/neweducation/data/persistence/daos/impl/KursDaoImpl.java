package com.neweducation.data.persistence.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neweducation.data.persistence.daos.KursDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.general.Kurs;

@Repository
public class KursDaoImpl extends AbstractHibernateDao<Kurs> implements KursDao {

	public KursDaoImpl() {
		super();

		setClazz(Kurs.class);
	}

	public List<Kurs> getCoursesForDesignationsInSemester(List<Integer> designationsIds) {

		return this.getCurrentSession().getNamedQuery("Kurs.findCoursesForDesignationsInSemester")
				.setParameter("designationsIds", designationsIds).list();
	}

}
