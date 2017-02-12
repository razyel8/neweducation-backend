package com.neweducation.dpws.core.model;

import java.util.List;

import dtos.DesignationTo;

public interface DesignationsModel {

	List<DesignationTo> getDesignations();

	void updateDesignationsForCourse(String courseId, List<DesignationTo> designations);

	void discardDesignation(int designationId);

	void acceptDesignation(int designationId);

	void addNewDesignation(long courseId, long lecturerId, long numberOfHours, long requestId,
			long designationInSemesterId);

	List<DesignationTo> getAllDesignationsOfUserInSemester(long userId, long semesterId);
}
