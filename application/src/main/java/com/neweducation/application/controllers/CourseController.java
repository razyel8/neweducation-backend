package com.neweducation.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neweducation.application.security.NotAuthenticatedException;

import dtos.CourseTo;
import dtos.UserTo;

@RestController
public class CourseController extends AbstractController {

	// @Override
	// public List<LecturerTo> getLecturers(String courseId) {
	// return designationService.getLecturers(courseId);
	// }
	//
	// @Override
	// public List<DesignationTo> getDesignations(String courseId) {
	// return designationService.getDesignations(courseId);
	// }
	//
	// @Override
	// public void updateDesignationsForCourse(String courseId,
	// List<DesignationTo> designations) {
	// designationService.updateDesignationsForCourse(courseId, designations);
	// }

	@RequestMapping(value = "/designations/all", method = RequestMethod.GET)
	public ResponseEntity<List<CourseTo>> getCoursesFor(@RequestParam(value = "authToken") String authToken,
			@RequestParam(value = "semesterId") long semesterId, @RequestParam(value = "facultyId") long facultyId,
			@RequestParam(value = "fieldOfStudyId") long fieldOfStudyId) {

		UserTo user = null;
		try {
			user = authenticator.authenticateUser(authToken);
		} catch (NotAuthenticatedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		List<CourseTo> courses = this.designationPlanningFacade.getCoursesFor(semesterId, facultyId, fieldOfStudyId);

		return null;
		// ResponseEntity.ok().body(semesters);
	}

}
