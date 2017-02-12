package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.neweducation.data.persistence.entities.designations.PlanStudiow;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Przedmiot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nazwa;

	@OneToMany
	private List<KartaPrzedmiotu> kartyPrzedmiotu = new ArrayList<KartaPrzedmiotu>();

	@ManyToMany
	private List<PlanStudiow> planyStudiow = new ArrayList<PlanStudiow>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Kurs> kursy = new ArrayList<Kurs>();

	@ManyToMany
	private List<ProwadzacyZajecia> prowadzacyZajecia = new ArrayList<ProwadzacyZajecia>();

}