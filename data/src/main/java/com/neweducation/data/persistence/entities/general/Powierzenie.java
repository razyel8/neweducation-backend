package com.neweducation.data.persistence.entities.general;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.neweducation.data.persistence.entities.designations.PowierzeniaProwadzacego;
import com.neweducation.data.persistence.entities.designations.PowierzeniaWSemestrze;
import com.neweducation.data.persistence.entities.designations.StatusPowierzenia;
import com.neweducation.data.persistence.entities.designations.Zapotrzebowanie;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "Powierzenie.getAllDesignationsOfUserInSemester", query = "SELECT p FROM Powierzenie p JOIN p.prowadzacyZajecia pz JOIN p.powierzeniaWSemestrze pws JOIN pws.semestr s WHERE pz.id = :userId AND s.id = :semesterId")
public class Powierzenie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private int liczbaGodzin;

	@Column
	private String dataUtworzenia;

	@Column
	private String dataAkceptacji;

	@Column
	private String dataEdycji;

	@Enumerated
	private StatusPowierzenia statusPowierzenia;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Zapotrzebowanie zapotrzebowanie;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private PowierzeniaWSemestrze powierzeniaWSemestrze;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Kurs kurs;

	@ManyToOne
	private PowierzeniaProwadzacego powierzeniaProwadzacego;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private ProwadzacyZajecia prowadzacyZajecia;

	// tego chyba nie ma
	// private PelnomocnikDziekanaDsKierunku pelnomocnikDziekanaDsKierunku2;
	//
	// private PelnomocnikDziekanaDsKierunku pelnomocnikDziekanaDsKierunku;
	// private SekretarzKierunkuStudiow sekretarzKierunkuStudiow;
	// private Semestr semestr;

}