package com.neweducation.data.services.impl;

import com.neweducation.data.persistence.daos.SondazDao;
import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Sondaz;
import com.neweducation.data.services.AbstractHibernateService;
import com.neweducation.data.services.SondazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 08.02.2017.
 */
@Service
public class SondazServiceImpl extends AbstractHibernateService<Sondaz> implements SondazService {

    @Autowired
    @Qualifier("sondazDao")
    private SondazDao dao;

    @Override
    public List<Sondaz> getSondaz(String authToken) {
        return dao.getSondaz(authToken);
    }

    @Override
    protected IOperations<Sondaz> getDao() {
        return dao;
    }
}
