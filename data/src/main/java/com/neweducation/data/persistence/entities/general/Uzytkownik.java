package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Uzytkownik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	@Column
	protected String imie;

	@Column
	protected String nazwisko;

	@Enumerated
	protected Uprawnienie uprawnienie;

	@OneToOne(cascade = CascadeType.ALL)
	private DaneLogowania daneLogowania;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Wydzial> wydzialy = new ArrayList<Wydzial>();

	public long getId() {
		return id;
	}

}