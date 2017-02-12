package com.neweducation.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neweducation.data.persistence.daos.PowierzeniaWSemestrzeDao;
import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.designations.PowierzeniaWSemestrze;
import com.neweducation.data.services.AbstractHibernateService;
import com.neweducation.data.services.PowierzeniaWSemestrzeService;

@Service
public class PowierzeniaWSemestrzeServiceImpl extends AbstractHibernateService<PowierzeniaWSemestrze>
		implements PowierzeniaWSemestrzeService {

	@Autowired
	@Qualifier("powierzeniaWSemestrzeDao")
	private PowierzeniaWSemestrzeDao dao;

	public PowierzeniaWSemestrzeServiceImpl() {
		super();
	}

	@Override
	protected IOperations<PowierzeniaWSemestrze> getDao() {
		return dao;

	}

	// @Override
	// protected IOperations<PowierzeniaWSemestrze> getDao() {
	// return dao;
	// }

}

// @Service
// public class KursServiceImpl extends AbstractHibernateService<Kurs>
// implements KursService {
//
// @Autowired
// @Qualifier("kursDao")
// private KursDao dao;
//
// public KursServiceImpl() {
// super();
// }
//
// @Override
// protected IOperations<Kurs> getDao() {
// return dao;
// }
//
// @Override
// public List<Kurs> getCoursesForDesignationsInSemester(List<Integer>
// designationsIds) {
// return dao.getCoursesForDesignationsInSemester(designationsIds);
// }
//
// }