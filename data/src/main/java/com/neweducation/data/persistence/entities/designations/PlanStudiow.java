package com.neweducation.data.persistence.entities.designations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Przedmiot;
import com.neweducation.data.persistence.entities.general.RodzajStudiow;
import com.neweducation.data.persistence.entities.general.Student;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlanStudiow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String cyklNauczania;

	@ManyToMany
	private List<Przedmiot> przedmioty = new ArrayList<Przedmiot>();

	@ManyToOne
	private Kierunek kierunek;

	@ManyToMany
	private List<Student> studenci = new ArrayList<Student>();

	@Enumerated
	private RodzajStudiow rodzajStudiow;

}