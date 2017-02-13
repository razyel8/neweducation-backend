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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.neweducation.data.persistence.entities.designations.FormaKursu;
import com.neweducation.data.persistence.entities.designations.Zapotrzebowanie;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "Kurs.findCoursesForDesignationsInSemester", query = "SELECT k FROM Kurs k WHERE k.id in (:designationsIds)")

public class Kurs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nazwa;

	@Column
	private int liczbaGodzin;

	@ManyToOne
	private Przedmiot przedmiot;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Powierzenie> powierzenia = new ArrayList<Powierzenie>();

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Zapotrzebowanie> zapotrzebowanie = new ArrayList<Zapotrzebowanie>();

	@Enumerated
	private FormaKursu formaKursu;

	@ManyToOne
	private Semestr semestr;

}