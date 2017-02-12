package com.neweducation.data.persistence.entities.designations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.persistence.entities.general.Powierzenie;
import com.neweducation.data.persistence.entities.general.Semestr;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Zapotrzebowanie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private int liczbaGodzin;

	@Column
	private int przydzielonaLiczbaGodzin; // suma z Powierzenie.liczbaGodzin
											// patrz nizej

	@OneToMany
	private List<Powierzenie> powierzenia = new ArrayList<Powierzenie>();

	@ManyToOne
	private Kurs kurs;

	@ManyToOne
	private Semestr semestr;
}