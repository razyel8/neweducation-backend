package com.neweducation.dpws.core.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.persistence.entities.general.Powierzenie;
import com.neweducation.data.persistence.entities.general.RodzajStudiow;
import com.neweducation.dpws.core.model.AbstractModel;
import com.neweducation.dpws.core.model.CoursesModel;

import dtos.CourseTo;
import dtos.TypStudiow;
import utils.DozerBeanCollectionMapper;

@Component
public class CoursesModelImpl extends AbstractModel implements CoursesModel {

	public List<CourseTo> getCoursesForDesignationInSemester(int designationId) {
		return getCoursesForDesignationsInSemester(Collections.singletonList(designationId));
	}

	public List<CourseTo> getCoursesForDesignationsInSemester(List<Integer> designationsIds) {
		List<Kurs> courses = dataFacade.getCoursesForDesignationsInSemester(designationsIds);
		return DozerBeanCollectionMapper.map(courses, CourseTo.class);
	}

	public CourseTo getById(long id) {

		Kurs example = dataFacade.find(id);
		CourseTo cto = new CourseTo();
		// cto.id = example.getId();
		// cto.liczbaGodzin = example.getLiczbaGodzin();
		// cto.nazwa = example.getNazwa();
		return cto;
	}

	@Override
	public List<CourseTo> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId) {
		List<Kurs> kursy = dataFacade.getCoursesFor(semesterId, facultyId, fieldOfStudyId);
		List<CourseTo> coursesTOs = new ArrayList<>();

		for (Kurs kurs : kursy) {
			CourseTo courseTo = new CourseTo();
			courseTo.setIdKurs(kurs.getId());
			courseTo.setTypStudiow(findOutTypStudiow(kurs));
			courseTo.setKurs(kurs.getNazwa());
			courseTo.setForma(kurs.getFormaKursu().toString());
			courseTo.setNrSem(findOutNrSemestru(kurs));
			courseTo.setZapotrzebowanie(findOutZapotrzebowanie(kurs));
			coursesTOs.add(courseTo);

		}
		return coursesTOs;
	}

	private TypStudiow findOutTypStudiow(Kurs kurs) {
		TypStudiow typStudiow = null;
		try {
			typStudiow = kurs.getPrzedmiot().getPlanyStudiow().get(0).getRodzajStudiow() == RodzajStudiow.Stacjonarne
					? TypStudiow.Stacjonarne : TypStudiow.Niestacjonarne;
		} catch (Exception e) {
			// NullPointer or IndexOutOfBounds - do nothing
		}
		return typStudiow;
	}

	private String findOutNrSemestru(Kurs kurs) {
		String nrSemestru = null;
		try {
			nrSemestru = kurs.getPrzedmiot().getKartyPrzedmiotu().get(0).getNumerSemestru();
		} catch (Exception e) {
			// NullPointer or IndexOutOfBounds - do nothing
		}
		return nrSemestru;
	}

	private int findOutZapotrzebowanie(Kurs kurs) {
		int zapotrzebowanie = -1;
		try {
			// TODO -> NamedQuery
			zapotrzebowanie = kurs.getZapotrzebowanie().get(0).getLiczbaGodzin();
		} catch (Exception e) {
			// NullPointer or IndexOutOfBounds - do nothing
		}
		return zapotrzebowanie;
	}

	private int findOutPrzydzielono(Kurs kurs) {
		int przydzielono = 0;
		try {
			// TODO -> NamedQuery
			// TODO - dla jednego semestru zawsze MAX 1 zapotrzebowanie?
			List<Powierzenie> powierzenia = kurs.getZapotrzebowanie().get(0).getPowierzenia();
			for (Powierzenie p : powierzenia) {
				przydzielono += p.getLiczbaGodzin();
			}

		} catch (Exception e) {
			// NullPointer or IndexOutOfBounds - do nothing
		}
		return przydzielono;
	}

	// public static void main(String[] args) {
	// FormaKursu f = FormaKursu.Cwiczenia;
	// System.out.println(f.toString());
	// }

}
