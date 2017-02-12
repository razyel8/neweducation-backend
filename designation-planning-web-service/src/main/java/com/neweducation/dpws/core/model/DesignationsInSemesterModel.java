package com.neweducation.dpws.core.model;

import java.util.List;

import dtos.DesignationTo;
import dtos.UserTo;

public interface DesignationsInSemesterModel {
	List<DesignationTo> getAllDesignationsInSemesterManagedBy(UserTo user);

	// List<DesignationsInSemesterTo> getAllDesignationsInSemesterManagedBy(int
	// userId, String token);
}
