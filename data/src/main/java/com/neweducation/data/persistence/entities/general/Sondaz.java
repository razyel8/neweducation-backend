package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.neweducation.data.persistence.entities.survey.GlosStudentaWSondazu;
import com.neweducation.data.persistence.entities.survey.StatusSondazu;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "Sondaz.getForUser", query =  "SELECT sond FROM Sondaz sond JOIN sond.glosy g JOIN g.student stud")
public class Sondaz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nazwa;

	@Column
	private String dataUtw;

	@Column
	private String dataRozp;

	@Column
	private String dataZak;

	@Column
	private String opis;

	@ManyToMany
	private List<Specjalnosc> specjalnosci = new ArrayList<Specjalnosc>();

	@OneToMany
	private List<GlosStudentaWSondazu> glosy = new ArrayList<>();

	@ManyToOne
	private Semestr semestr;

	@Enumerated
	private StatusSondazu statusSondazu;

}