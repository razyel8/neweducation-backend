package com.neweducation.data.persistence.daos;

import java.util.List;

import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.general.Kurs;

public interface KursDao extends IOperations<Kurs> {
	List<Kurs> getCoursesForDesignationsInSemester(List<Integer> designationsIds);

}
