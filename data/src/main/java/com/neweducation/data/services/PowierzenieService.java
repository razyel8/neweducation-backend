package com.neweducation.data.services;

import java.util.List;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Powierzenie;

import dtos.DesignationTo;

/**
 * Created by Maciej Wolański maciekwski@gmail.com on 08.02.2017.
 */
public interface PowierzenieService extends IOperations<Powierzenie> {
	void discardDesignation(int designationId);

	void acceptDesignation(int designationId);

	void addNewDesignation(long courseId, long lecturerId, long numberOfHours, long requestId,
			long designationInSemesterId);

	List<DesignationTo> getAllDesignationsOfUserInSemester(long userId, long semesterId);
}
