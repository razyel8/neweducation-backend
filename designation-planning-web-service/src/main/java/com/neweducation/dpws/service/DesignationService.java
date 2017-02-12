package com.neweducation.dpws.service;

import java.util.List;

import dtos.CourseTo;
import dtos.DesignationTo;
import dtos.LecturerTo;
import dtos.UserTo;

public interface DesignationService {

	// CoursesModel
	List<CourseTo> getCoursesForDesignationsInSemester(int designationId);

	void notifyLecturersOfDesignations(int disId);

	// DesignationsInSemesterModel
	List<DesignationTo> getAllDesignationsInSemesterManagedBy(UserTo user);

	// LecturersModel
	List<LecturerTo> getLecturers(String courseId);

	// DesignationsModel
	List<DesignationTo> getDesignations(String courseId);

	void updateDesignationsForCourse(String courseId, List<DesignationTo> designations);

	CourseTo zzzzzGetCourseById(long id);

	// (1)
	List<CourseTo> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId);

	void discardDesignation(int designationId);

	void acceptDesignation(int designationId);

	void addNewDesignation(long courseId, long lecturerId, long numberOfHours, long requestId,
			long designationInSemesterId);

	List<DesignationTo> getAllDesignationsOfUserInSemester(long userId, long semesterId);

	// List<DesignationsInSemesterTo> getAllDesignationsInSemesterManagedBy(int
	// userId, String token);

}
