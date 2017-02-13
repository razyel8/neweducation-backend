package com.neweducation.application.controllers;

import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Sondaz;
import com.neweducation.data.persistence.entities.general.Specjalnosc;
import dtos.LecturerTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SondazController extends AbstractController {

    //Pobierz wszystkie sondaże dla danego użytkownika
    @RequestMapping(value = "/sondaz", method = RequestMethod.GET)
    public List<Sondaz> getSondaze(@RequestParam(value = "authToken", required=false) String authToken) {

        List<Specjalnosc> specjalnosci = new ArrayList<>();

        Kierunek k1 = new Kierunek();
        k1.setId(1);
//        k1.
//
//
        List<Sondaz> sondaze = new ArrayList<>();

        Sondaz s1 = new Sondaz();
        s1.setId(1);
        s1.setNazwa("Sondaż specjalności nr 1");
        s1.setDataRozp("");
        s1.setDataUtw("");
        s1.setDataZak("");

        s1.setOpis("Opsdcmk cd dsjc dscds cds cds cds cd cdscds cdsc ds cds cdsc");



        sondaze.add(s1);

        return sondaze;
    }


}
