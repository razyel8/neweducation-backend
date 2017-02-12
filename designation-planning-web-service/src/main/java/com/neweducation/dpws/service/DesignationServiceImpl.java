package com.neweducation.dpws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neweducation.dpws.core.model.CoursesModel;
import com.neweducation.dpws.core.model.DesignationsInSemesterModel;
import com.neweducation.dpws.core.model.DesignationsModel;
import com.neweducation.dpws.core.model.LecturersModel;

import dtos.CourseTo;
import dtos.DesignationTo;
import dtos.LecturerTo;
import dtos.UserTo;

public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private CoursesModel coursesModel;

	@Autowired
	private DesignationsInSemesterModel designationsInSemesterModel;

	@Autowired
	private DesignationsModel designationsModel;

	@Autowired
	private LecturersModel lecturersModel;

	@Autowired
	private DesignaitonsMailingService designaitonsMailingService;

	// int or list of integers
	// ?????????????????????????????????????????????????????????????????????????????
	// (id vs ids)
	@Override
	public List<CourseTo> getCoursesForDesignationsInSemester(int designationId) {
		return coursesModel.getCoursesForDesignationInSemester(designationId);
	}

	// TO-DO
	@Override
	public void notifyLecturersOfDesignations(int designationId) {
		designaitonsMailingService.notifyLecturersOfDesignations(designationId);
	}

	@Override
	public List<DesignationTo> getAllDesignationsInSemesterManagedBy(UserTo user) {
		return designationsInSemesterModel.getAllDesignationsInSemesterManagedBy(user);
	}

	@Override
	public List<LecturerTo> getLecturers(String courseId) {
		return lecturersModel.getLecturers();
	}

	@Override
	public List<DesignationTo> getDesignations(String courseId) {
		return designationsModel.getDesignations();
	}

	@Override
	public void updateDesignationsForCourse(String courseId, List<DesignationTo> designations) {
		designationsModel.updateDesignationsForCourse(courseId, designations);
	}

	@Override
	public CourseTo zzzzzGetCourseById(long id) {
		return coursesModel.getById(id);

	}

	// (1)
	@Override
	public List<CourseTo> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId) {
		return coursesModel.getCoursesFor(semesterId, facultyId, fieldOfStudyId);
	}

	@Override
	public void discardDesignation(int designationId) {
		designationsModel.discardDesignation(designationId);
	}

	@Override
	public void acceptDesignation(int designationId) {
		this.designationsModel.acceptDesignation(designationId);
	}

	@Override
	public void addNewDesignation(long courseId, long lecturerId, long numberOfHours, long requestId,
			long designationInSemesterId) {
		this.designationsModel.addNewDesignation(courseId, lecturerId, numberOfHours, requestId,
				designationInSemesterId);
	}

	@Override
	public List<DesignationTo> getAllDesignationsOfUserInSemester(long userId, long semesterId) {
		return this.designationsModel.getAllDesignationsOfUserInSemester(userId, semesterId);
	}

	// new

	// @Override
	// public List<DesignationsInSemesterTo>
	// getAllDesignationsInSemesterManagedBy(int userId, String token) {
	// return
	// this.designationsInSemesterModel.getAllDesignationsInSemesterManagedBy(userId,
	// token);
	// }

}
