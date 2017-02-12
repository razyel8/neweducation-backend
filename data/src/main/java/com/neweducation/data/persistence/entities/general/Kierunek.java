package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.neweducation.data.persistence.entities.designations.PlanStudiow;
import com.neweducation.data.persistence.entities.designations.PowierzeniaWSemestrze;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "Kierunek.getCoursesFor", query = "SELECT ku FROM Kierunek k JOIN k.planyStudiows ps JOIN ps.przedmioty p JOIN p.kursy ku WHERE k.id = :fieldOfStudyId AND k.wydzial.id = :facultyId AND ku.semestr.id = :semesterId ")
public class Kierunek {

	// return
	// this.getCurrentSession().getNamedQuery("Kierunek.getCoursesFor").setParameter("semesterId",
	// semesterId)
	// .setParameter("facultyId", facultyId).setParameter("fieldOfStudyId",
	// fieldOfStudyId).list();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String nazwa;

	@Column
	private String stopien;

	@OneToMany
	private List<Specjalnosc> specjalnosci = new ArrayList<Specjalnosc>();

	@ManyToOne
	private PelnomocnikDziekanaDsKierunku pelnomocnikDziekanaDsKierunku;

	@OneToOne
	private SekretarzKierunkuStudiow sekretarzKierunkuStudiow;

	@ManyToOne
	private Wydzial wydzial;

	@OneToMany
	private List<PlanStudiow> planyStudiows = new ArrayList<PlanStudiow>();

	@Enumerated
	private RodzajStudiow rodzajStudiow;

	@OneToMany
	private List<PowierzeniaWSemestrze> powierzeniaWSemestrze = new ArrayList<PowierzeniaWSemestrze>();
}