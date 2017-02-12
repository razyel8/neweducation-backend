package com.neweducation.data.persistence.daos;

import java.util.List;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.designations.StatusPowierzenia;
import com.neweducation.data.persistence.entities.general.Powierzenie;

/**
 * Created by Maciej Wolański maciekwski@gmail.com on 08.02.2017.
 */
public interface PowierzenieDao extends IOperations<Powierzenie> {
	void updateDesignationStatus(int designationId, StatusPowierzenia status);

	List<Powierzenie> getAllDesignationsOfUserInSemester(long userId, long semesterId);
}
