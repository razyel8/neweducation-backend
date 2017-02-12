package com.neweducation.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.neweducation.data.persistence.daos" })
@ImportResource({ "classpath:hibernate5Config.xml" })
public class PersistenceXmlConfig {

	public PersistenceXmlConfig() {
		super();
	}

}