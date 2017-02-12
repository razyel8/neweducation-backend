package com.neweducation.application.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dtos.DesignationTo;
import dtos.Role;
import dtos.UserTo;

@RestController
public class UserController extends AbstractController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {

		Map<String, Object> response = new HashMap<String, Object>();
		// Tu get User z bazy
		response.put("id", 123L);
		response.put("imie", "Dariusz");
		response.put("nazwisko", "Małysz");
		response.put("login", 123L);
		response.put("uprawnienie", Role.STUDENT);
		response.put("auth_token", "abc123");

		return response;
	}

	@RequestMapping(value = "/users/{user}", method = RequestMethod.GET)
	public List<DesignationTo> getAllDesignationsInSemesterManagedBy(@RequestParam(value = "user") UserTo user) {

		return designationPlanningFacade.getAllDesignationsInSemesterManagedBy(user);
	}

}
