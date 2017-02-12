package com.neweducation.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neweducation.data.persistence.daos.KierunekDao;
import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.services.AbstractHibernateService;
import com.neweducation.data.services.KierunekService;

@Service
public class KierunekServiceImpl extends AbstractHibernateService<Kierunek> implements KierunekService {

	@Autowired
	@Qualifier("kierunekDao")
	private KierunekDao dao;

	public KierunekServiceImpl() {
		super();
	}

	@Override
	protected IOperations<Kierunek> getDao() {
		return dao;
	}

	@Override
	public List<Kurs> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId) {
		return dao.getCoursesFor(semesterId, facultyId, fieldOfStudyId);
	}
}
