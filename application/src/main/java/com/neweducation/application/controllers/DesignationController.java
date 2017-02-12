package com.neweducation.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neweducation.application.security.NotAuthenticatedException;

import dtos.DesignationTo;
import dtos.UserTo;

@RestController
public class DesignationController extends AbstractController {

	@RequestMapping(value = "/designation/{designationId}", method = RequestMethod.POST)
	public void notifyLecturersOfDesignations(@RequestParam(value = "designationId") int designationId) {
		this.designationPlanningFacade.notifyLecturersOfDesignations(designationId);
	}

	// TODO
	// (1) input - (id kursu, semestr)
	// (1) output - List<Powierzenie>, List<ProwadzacyZajecia>,
	// List<ProwadzacyZajecia>
	// @RequestMapping(value = "TODO", method = RequestMethod.GET)
	// public void zzz() {
	// List<DesignationTo> designations =
	// this.designationPlanningFacade.getAllDesignationsFor(long courseId, long
	// semesterId);
	// List<LecturerTo> classesLecturers =
	// this.designationPlanningFacade.getLecturersFor(long courseId);
	// List<LecturerTo>
	// }

	// (2) input - (id kursu, id powierzenia, id prowadzacego, liczba
	// godzin(Powierzenie.class)

/*

	Implementacja:


	POST /powierzenie/{id}/odrzuc
	Odrzuc dane powierzenie
	StatusPowierzenia -> niezaakc
*/

//    @RequestMapping(value = "/designation/{designationId}/discard", method = RequestMethod.POST)
//    public ResponseEntity<Object> discardDesignation(@RequestParam(value = "designationId") int designationId, String authToken) {
//        UserTo user = null;
//        try {
//            user = authenticator.authenticateUser(authToken);
//        } catch (NotAuthenticatedException e) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//        }
//        this.designationPlanningFacade.discardDesignation(designationId);
//        return ResponseEntity.ok().body(new Object());
//    }

	/*
	 * Implementacja:
	 * 
	 * POST /powierzenie/{id}/akceptuj Akceptuj dane powierzenie dataAkceptacji
	 * -> Date.now() i StatusPowierzenia -> zaakc.
	 * 
	 */

	@RequestMapping(value = "/designation/{designationId}/discard", method = RequestMethod.POST)
	public ResponseEntity<Object> acceptDesignation(@RequestParam(value = "designationId") int designationId,
			String authToken) {
		UserTo user = null;
		try {
			user = authenticator.authenticateUser(authToken);
		} catch (NotAuthenticatedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		this.designationPlanningFacade.acceptDesignation(designationId);
		return ResponseEntity.ok().body(new Object());
	}

	// 2
	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/designation/new", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewDesignation(@RequestParam(value = "authToken") String authToken,
			@RequestParam(value = "kursId") long courseId, @RequestParam(value = "prowadzącyId") long lecturerId,
			@RequestParam(value = "liczbaGodzin") long numberOfHours,
			@RequestParam(value = "zapotrzebowanieId") long requestId,
			@RequestParam(value = "powierzenieWSemestrzeId") long designationInSemesterId) {
		UserTo user = null;
		try {
			user = authenticator.authenticateUser(authToken);
		} catch (NotAuthenticatedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		this.designationPlanningFacade.addNewDesignation(courseId, lecturerId, numberOfHours, requestId,
				designationInSemesterId);
		return ResponseEntity.ok().body(new Object());
	}

	@RequestMapping(value = "/designation/semestr/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<DesignationTo>> getAllDesignationsOfUser(
			@RequestParam(value = "authToken") String authToken, @RequestParam(value = "semesterId") long semesterId) {
		UserTo user = null;
		try {
			user = authenticator.authenticateUser(authToken);
		} catch (NotAuthenticatedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		List<DesignationTo> designationTos = this.designationPlanningFacade
				.getAllDesignationsOfUserInSemester(user.getId(), semesterId);

		return ResponseEntity.ok().body(designationTos);
	}

	// auth_token
	// kursId: number
	// prowadzącyId: number
	// liczbaGodzin: number
	// status: w przygotowaniu
	// zapotrzebowanieId: Kurs.Zapotrzebowanie.id
	// powierzenieWSemestrzeId: (kierunek,wyklad).PowierzeniaWSemestrze.id

	// POST /powierzenie/nowe
	// Dodaje nowe powierzenie
	// params:
	// auth_token
	// kursId: number
	// prowadzącyId: number
	// liczbaGodzin: number
	// status: w przygotowaniu
	// zapotrzebowanieId: Kurs.Zapotrzebowanie.id
	// powierzenieWSemestrzeId: (kierunek,wyklad).PowierzeniaWSemestrze.id
}
