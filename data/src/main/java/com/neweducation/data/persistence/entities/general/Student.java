package com.neweducation.data.persistence.entities.general;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.neweducation.data.persistence.entities.designations.PlanStudiow;

import com.neweducation.data.persistence.entities.survey.GlosStudentaWSondazu;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends Uzytkownik {

	@OneToMany
	private List<GlosStudentaWSondazu> sondaze = new ArrayList<>();

	@ManyToMany
	private List<PlanStudiow> planyStudiow = new ArrayList<PlanStudiow>();
}