package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.neweducation.data.persistence.entities.designations.LimityProwadzacego;
import com.neweducation.data.persistence.entities.designations.PowierzeniaProwadzacego;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProwadzacyZajecia extends Uzytkownik {

	@ManyToMany
	private List<Przedmiot> przedmioty = new ArrayList<Przedmiot>();

	@OneToMany
	private List<PowierzeniaProwadzacego> powierzeniaProwadzacego = new ArrayList<PowierzeniaProwadzacego>();

	@OneToMany
	private List<LimityProwadzacego> limityProwadzacego = new ArrayList<LimityProwadzacego>();

	@OneToMany
	private List<Powierzenie> powierzenia = new ArrayList<>();
}
