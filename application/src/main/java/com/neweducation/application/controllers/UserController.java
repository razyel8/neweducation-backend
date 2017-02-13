package com.neweducation.application.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dtos.DesignationTo;
import dtos.Role;
import dtos.UserTo;

@RestController
public class UserController extends AbstractController {

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserTo> login(@RequestParam(value = "login") String login,
								@RequestParam(value = "password") String password) {

		UserTo user = new UserTo();

		switch(login){
			case "stud":
				user.setId(1);
				user.setImie("Wojciech");
				user.setNazwisko("Małysz");
				user.setRole(1);
				user.setAuthToken("abc1");
				break;
			case "prac":
				user.setId(2);
				user.setImie("Dariusz");
				user.setNazwisko("Kot");
				user.setRole(2);
				user.setAuthToken("abc1");
				break;

			case "pelno":
				user.setId(3);
				user.setImie("Maciej");
				user.setNazwisko("Kubica");
				user.setRole(3);
				user.setAuthToken("abc1");
				break;
			default:
				return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);
	}

	@RequestMapping(value = "/users/{user}", method = RequestMethod.GET)
	public List<DesignationTo> getAllDesignationsInSemesterManagedBy(@RequestParam(value = "user") UserTo user) {

		return designationPlanningFacade.getAllDesignationsInSemesterManagedBy(user);
	}

}
