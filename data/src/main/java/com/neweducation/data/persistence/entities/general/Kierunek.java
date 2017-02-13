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

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Specjalnosc> specjalnosci = new ArrayList<Specjalnosc>();

	@ManyToOne
	private PelnomocnikDziekanaDsKierunku pelnomocnikDziekanaDsKierunku;

	
//	@OneToOne(optional= true)
//	private SekretarzKierunkuStudiow sekretarzKierunkuStudiow;

	@ManyToOne
	private Wydzial wydzial;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<PlanStudiow> planyStudiows = new ArrayList<PlanStudiow>();

	//DELETED !!!
//	@Enumerated
//	private RodzajStudiow rodzajStudiow;

	@OneToMany
	private List<PowierzeniaWSemestrze> powierzeniaWSemestrze = new ArrayList<PowierzeniaWSemestrze>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kierunek other = (Kierunek) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}