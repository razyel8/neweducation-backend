package com.neweducation.application.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neweducation.application.security.NotAuthenticatedException;
import dtos.UserTo;

@RestController
public class SemestrController extends AbstractController {

	@RequestMapping(value = "/semestr", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Map<String, Object>>> getAllSemesters(
			@RequestParam(value = "authToken") String authToken) {

		UserTo user = null;
		try {
			user = authenticator.authenticateUser(authToken);
		} catch (NotAuthenticatedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		ArrayList<Map<String, Object>> semesters = new ArrayList<>();

		Map<String, Object> semestrOne = new HashMap<String, Object>();
		semestrOne.put("id", 333L);
		semestrOne.put("nazwa", "Semestr I 2016/2017");
		semestrOne.put("dataRozpoczecia", "11-11-2016");
		semestrOne.put("dataZakonczenia", "11-11-2017");
		semestrOne.put("sampleEnum", RodzajStudiow.Stacjonarne);

		Map<String, Object> semestrTwo = new HashMap<String, Object>();
		// Tu get User z bazy
		semestrTwo.put("id", 321L);
		semestrTwo.put("nazwa", "Semestr I 2016/2017");
		semestrTwo.put("dataRozpoczecia", "11-11-2016");
		semestrTwo.put("dataZakonczenia", "11-11-2017");

		semesters.add(semestrOne);
		semesters.add(semestrTwo);

		return ResponseEntity.ok().body(semesters);
	}
	
	public enum RodzajStudiow {
		Stacjonarne, Niestacjonarne;
	}
}
