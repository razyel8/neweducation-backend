package com.neweducation.data.services;

import java.util.List;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Kurs;

public interface KursService extends IOperations<Kurs> {
	List<Kurs> getCoursesForDesignationsInSemester(List<Integer> designationsIds);
}

// @Service
// public class FooService extends AbstractHibernateService<Foo> implements
// IFooService {
//
// @Autowired
// @Qualifier("fooHibernateDao")
// private IFooDao dao;
//
// public FooService() {
// super();
// }
//
// // API
//
// @Override
// protected IOperations<Foo> getDao() {
// return dao;
// }
//
// }
