package com.neweducation.data.persistence.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neweducation.data.persistence.daos.KierunekDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Kurs;

@Repository
public class KierunekDaoImpl extends AbstractHibernateDao<Kierunek> implements KierunekDao {

	public KierunekDaoImpl() {
		super();

		setClazz(Kierunek.class);
	}

	@Override
	public List<Kurs> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId) {
		return this.getCurrentSession().getNamedQuery("Kierunek.getCoursesFor").setParameter("semesterId", semesterId)
				.setParameter("facultyId", facultyId).setParameter("fieldOfStudyId", fieldOfStudyId).list();
	}

}
