package com.neweducation.data.persistence.daos;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Sondaz;

import java.util.List;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 08.02.2017.
 */
public interface SondazDao extends IOperations<Sondaz> {
    public List<Sondaz> getSondaz(String authToken);
}
