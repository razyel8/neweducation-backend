package com.neweducation.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.neweducation.application.security.Authenticator;
import com.neweducation.dpws.facades.DesignationPlanningFacade;

public class AbstractController {

	@Autowired
	protected DesignationPlanningFacade designationPlanningFacade;

	@Autowired
	@Qualifier("authenticator")
	protected Authenticator authenticator;
}
