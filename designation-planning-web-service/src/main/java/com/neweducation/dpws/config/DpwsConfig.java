package com.neweducation.dpws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.neweducation.data.config.PersistenceConfig;
import com.neweducation.dpws.core.model.CoursesModel;
import com.neweducation.dpws.core.model.DesignationsInSemesterModel;
import com.neweducation.dpws.core.model.DesignationsModel;
import com.neweducation.dpws.core.model.LecturersModel;
import com.neweducation.dpws.core.model.impl.CoursesModelImpl;
import com.neweducation.dpws.core.model.impl.DesignationsInSemesterModelImpl;
import com.neweducation.dpws.core.model.impl.DesignationsModelImpl;
import com.neweducation.dpws.core.model.impl.LecturersModelImpl;
import com.neweducation.dpws.facades.DesignationPlanningFacade;
import com.neweducation.dpws.facades.DesignationPlanningFacadeImpl;
import com.neweducation.dpws.service.DesignaitonsMailingService;
import com.neweducation.dpws.service.DesignaitonsMailingServiceImpl;
import com.neweducation.dpws.service.DesignationService;
import com.neweducation.dpws.service.DesignationServiceImpl;

@Configuration
@Import(PersistenceConfig.class)
public class DpwsConfig {

	@Bean
	public CoursesModel coursesModel() {
		return new CoursesModelImpl();
	}

	@Bean
	public DesignationsInSemesterModel designationsInSemesterModel() {
		return new DesignationsInSemesterModelImpl();
	}

	@Bean
	public DesignationsModel designationsModel() {
		return new DesignationsModelImpl();
	}

	@Bean
	public LecturersModel lecturersModel() {
		return new LecturersModelImpl();
	}

	@Bean
	public DesignationPlanningFacade designationPlanningFacade() {
		return new DesignationPlanningFacadeImpl();
	}

	@Bean
	public DesignaitonsMailingService designaitonsMailingService() {
		return new DesignaitonsMailingServiceImpl();
	}

	@Bean
	public DesignationService designationService() {
		return new DesignationServiceImpl();
	}

}
