package com.neweducation.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neweducation.data.persistence.daos.KursDao;
import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.services.AbstractHibernateService;
import com.neweducation.data.services.KursService;

@Service
public class KursServiceImpl extends AbstractHibernateService<Kurs> implements KursService {

	@Autowired
	@Qualifier("kursDao")
	private KursDao dao;

	public KursServiceImpl() {
		super();
	}

	@Override
	protected IOperations<Kurs> getDao() {
		return dao;
	}

	@Override
	public List<Kurs> getCoursesForDesignationsInSemester(List<Integer> designationsIds) {
		return dao.getCoursesForDesignationsInSemester(designationsIds);
	}

}