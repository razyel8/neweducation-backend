package com.neweducation.dpws.core.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.neweducation.data.facade.DataFacade;

public class AbstractModel {

	@Autowired
	protected DataFacade dataFacade;
}
