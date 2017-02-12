package com.neweducation.data.services;

import java.util.List;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Kurs;

public interface KierunekService extends IOperations<Kierunek> {
	List<Kurs> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId);

}
