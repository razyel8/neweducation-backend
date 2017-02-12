package com.neweducation.dpws.core.model;

import java.util.List;

import dtos.CourseTo;

public interface CoursesModel {

	List<CourseTo> getCoursesForDesignationInSemester(int designationId);

	List<CourseTo> getCoursesForDesignationsInSemester(List<Integer> designationsIds);

	CourseTo getById(long id);

	// (1)
	List<CourseTo> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId);
}