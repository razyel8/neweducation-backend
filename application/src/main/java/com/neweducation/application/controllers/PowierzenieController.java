package com.neweducation.application.controllers;


import com.neweducation.data.persistence.entities.general.Powierzenie;
import com.neweducation.data.persistence.entities.general.Sondaz;
import dtos.PowierzenieTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PowierzenieController extends AbstractController{

    //Pobierz wszystkie powierzenia dla danego użytkownika
    @RequestMapping(value = "/powierzenie", method = RequestMethod.GET)
    public List<PowierzenieTo> getPowierzenia(@RequestParam(value = "authToken", required=false) String authToken) {
        return null;
    }

    //Pobierz wszystkie powierzenia dla danego użytkownika dla danego semestru
    @RequestMapping(value = "/powierzenie/semestr/{id}", method = RequestMethod.GET)
    public List<PowierzenieTo> getPowierzenia(@RequestParam(value = "authToken", required=false) String authToken, @PathVariable long id) {
        return null;
    }

    //Zaktualizuj dane powierzenie - akceptuj lub odrzuć
    @RequestMapping(value = "/powierzenie/{id}", method = RequestMethod.PUT)
    public ResponseEntity getPowierzenia(@RequestParam(value = "authToken", required=false) String authToken,
                                         @PathVariable long id,
                                         @RequestParam(value = "statusEnum", required=false) int statusEnum) {
        return null;
    }


}
