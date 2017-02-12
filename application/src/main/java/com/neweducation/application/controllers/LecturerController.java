package com.neweducation.application.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dtos.LecturerTo;

@RestController
public class LecturerController extends AbstractController {

	@RequestMapping(value = "/lecturers", method = RequestMethod.GET)
	public List<LecturerTo> getLecturers(@RequestParam(value = "courseId") String courseId) {

		return designationPlanningFacade.getLecturers(courseId);
	}
}
