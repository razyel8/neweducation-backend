package com.neweducation.data.persistence.daos.impl;

import com.neweducation.data.persistence.daos.SondazDao;
import com.neweducation.data.persistence.daos.generics.AbstractHibernateDao;
import com.neweducation.data.persistence.entities.general.Sondaz;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 08.02.2017.
 */
@Repository
public class SondazDaoImpl extends AbstractHibernateDao<Sondaz> implements SondazDao {
    @Override
    public List<Sondaz> getSondaz(String authToken) {
        authToken = "abc123";
        return this.getCurrentSession().getNamedQuery("Sondaz.getForUser").list();
    }

    public SondazDaoImpl() {
        super();

        setClazz(Sondaz.class);
    }
}
