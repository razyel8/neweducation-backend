package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wydzial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nazwa;

	@Column
	private String numer;

	@OneToMany
	private List<Kierunek> kierunki = new ArrayList<Kierunek>();

	@ManyToMany
	private List<Uzytkownik> uzytkownicy = new ArrayList<Uzytkownik>();
}