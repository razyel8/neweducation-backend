package com.neweducation.dpws.facades;

import java.util.List;

import dtos.CourseTo;
import dtos.DesignationTo;
import dtos.LecturerTo;
import dtos.UserTo;

public interface DesignationPlanningFacade {

	CourseTo tempzzzgetCourseById(long id);

	List<CourseTo> getCoursesForDesignationsInSemester(int designationId);

	void notifyLecturersOfDesignations(int disId);

	List<DesignationTo> getAllDesignationsInSemesterManagedBy(UserTo user);

	List<LecturerTo> getLecturers(String courseId);

	List<DesignationTo> getDesignations(String courseId);

	void updateDesignationsForCourse(String courseId, List<DesignationTo> designations);

	// (1)
	List<CourseTo> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId);

	void discardDesignation(int designationId);

	void acceptDesignation(int designationId);

	void addNewDesignation(long courseId, long lecturerId, long numberOfHours, long requestId,
			long designationInSemesterId);

	List<DesignationTo> getAllDesignationsOfUserInSemester(long id, long semesterId);

	// new

	// List<DesignationsInSemesterTo> getAllDesignationsInSemesterManagedBy(int
	// userId, String token);
}
