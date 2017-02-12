
package com.neweducation.application.surveyhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neweducation.application.controllers.AbstractController;
import com.neweducation.application.external.IStudyDescriptionProviderService;
import com.neweducation.application.external.MockStudyDescriptionProviderService;
import com.neweducation.application.security.NotAuthenticatedException;

import dtos.UserTo;

/**
 * Created by Maciej Wolański maciekwski@gmail.com on 08.02.2017.
 */
@RestController
public class SurveyController extends AbstractController {
	IStudyDescriptionProviderService descriptionProviderService = new MockStudyDescriptionProviderService();
	// DataFacade dataFacade = new DataFacadeImpl();

	// wybor specjalnosci - input: userid, sondazid, wybor(string, nazwa
	// opis specjalnosci - ZAMOCKOWANE - externale, input - idspecjalnosci
	@RequestMapping(value = "/surveys/{studyId}/getStudyDescription", method = RequestMethod.GET)
	public ResponseEntity<String> getStudyDescription(@RequestParam(value = "studyId") long studyId, String authToken) {
		UserTo user = null;
		try {
			user = authenticator.authenticateUser(authToken);
		} catch (NotAuthenticatedException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		return ResponseEntity.ok().body(this.descriptionProviderService.getStudyDescription(studyId));
	}

	/*
	 * GET /sondaze Zwraca wszystkie sondaże dla danego użytkownika
	 * Student.GlosStudentaWSondazu.Sondaz (lista)
	 * 
	 * params: auth_token
	 * 
	 * return tabela obiektów z wartosciami: id: number nazwa: string dataUtw:
	 * string dataRozp: string dataZak: string statusSondazu: string
	 * statusSondazuEnum: number #0- Aktywny, 1-Nieaktywny, 2-Zakonczony
	 * semestrId: number
	 * 
	 */
	// zaciagniecie wszystkich sondazy, input - userid
	// @RequestMapping(value = "/surveys", method = RequestMethod.GET)
	// public ResponseEntity<List<SurveyTo>>
	// getStudyDescription(@RequestParam("authToken") String authToken) {
	// UserTo user = null;
	// try {
	// user = authenticator.authenticateUser(authToken);
	// } catch (NotAuthenticatedException e) {
	// return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	// }
	// List<Sondaz> sondaze = this.dataFacade.getSurveys(authToken);
	// return ResponseEntity.ok().body(this.mapSondazeToDTO(sondaze,
	// authToken));
	// }
	//
	// private List<SurveyTo> mapSondazeToDTO(List<Sondaz> sondaze, String
	// authToken) {
	// return sondaze.stream().map(s -> mapSondazToDTO(s,
	// authToken)).collect(Collectors.toList());
	// }
	//
	// private SurveyTo mapSondazToDTO(Sondaz s, String authToken) {
	// SurveyTo survey = new SurveyTo();
	// survey.setId(s.getId());
	// survey.setNazwa(s.getNazwa());
	// survey.setDataUtw(s.getDataUtw());
	// survey.setDataZak(s.getDataZak());
	// survey.setDataRozp(s.getDataRozp());
	// survey.setSemestrId(s.getSemestr().getId());
	// survey.setStatusSondazu(s.getStatusSondazu(authToken));
	// survey.setStatusSondazuEnum(s.getStatusSondazuEnum(authToken));
	// return survey;
	// }
}
