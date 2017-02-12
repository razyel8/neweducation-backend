package com.neweducation.data.persistence.daos;

import java.util.List;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Kurs;

public interface KierunekDao extends IOperations<Kierunek> {

	List<Kurs> getCoursesFor(long semesterId, long facultyId, long fieldOfStudyId);
}
