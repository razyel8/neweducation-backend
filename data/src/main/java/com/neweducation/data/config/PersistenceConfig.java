package com.neweducation.data.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;
import com.neweducation.data.facade.DataFacade;
import com.neweducation.data.facade.DataFacadeImpl;
import com.neweducation.data.persistence.daos.KierunekDao;
import com.neweducation.data.persistence.daos.KursDao;
import com.neweducation.data.persistence.daos.PowierzeniaWSemestrzeDao;
import com.neweducation.data.persistence.daos.PowierzenieDao;
import com.neweducation.data.persistence.daos.ProwadzacyZajeciaDao;
import com.neweducation.data.persistence.daos.SondazDao;
import com.neweducation.data.persistence.daos.ZapotrzebowanieDao;
import com.neweducation.data.persistence.daos.impl.KierunekDaoImpl;
import com.neweducation.data.persistence.daos.impl.KursDaoImpl;
import com.neweducation.data.persistence.daos.impl.PowierzeniaWSemestrzeDaoImpl;
import com.neweducation.data.persistence.daos.impl.PowierzenieDaoImpl;
import com.neweducation.data.persistence.daos.impl.ProwadzacyZajeciaDaoImpl;
import com.neweducation.data.persistence.daos.impl.SondazDaoImpl;
import com.neweducation.data.persistence.daos.impl.ZapotrzebowanieDaoImpl;
import com.neweducation.data.services.KierunekService;
import com.neweducation.data.services.KursService;
import com.neweducation.data.services.PowierzeniaWSemestrzeService;
import com.neweducation.data.services.PowierzenieService;
import com.neweducation.data.services.SondazService;
import com.neweducation.data.services.impl.KierunekServiceImpl;
import com.neweducation.data.services.impl.KursServiceImpl;
import com.neweducation.data.services.impl.PowierzeniaWSemestrzeServiceImpl;
import com.neweducation.data.services.impl.PowierzenieServiceImpl;
import com.neweducation.data.services.impl.SondazServiceImpl;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.neweducation.data.persistence" }, transactionManagerRef = "jpaTransactionManager")
@EnableJpaAuditing
@PropertySource({ "classpath:persistence-mysql.properties" })
// @ComponentScan({ "com.neweducation.data.persistence" })
public class PersistenceConfig {

	@Autowired
	private Environment env;

	public PersistenceConfig() {
		super();
	}

	@Bean
	@Primary
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.neweducation.data.persistence.entities" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(restDataSource());
		emf.setPackagesToScan(new String[] { "com.neweducation.data.persistence.entities" });

		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(hibernateProperties());

		return emf;
	}

	@Bean
	public DataSource restDataSource() {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
		dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
		dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public PlatformTransactionManager jpaTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public KursDao kursDao() {
		return new KursDaoImpl();
	}

	@Bean
	public KursService kursService() {
		return new KursServiceImpl();
	}

	@Bean
	public DataFacade dataFacade() {
		return new DataFacadeImpl();
	}

	@Bean
	public PowierzeniaWSemestrzeService powierzeniaWSemestrzeService() {
		return new PowierzeniaWSemestrzeServiceImpl();
	}

	@Bean
	public PowierzeniaWSemestrzeDao powierzeniaWSemestrzeDao() {
		return new PowierzeniaWSemestrzeDaoImpl();
	}

	@Bean
	public KierunekDao kierunekDao() {
		return new KierunekDaoImpl();
	}

	@Bean
	public KierunekService kierunekService() {
		return new KierunekServiceImpl();
	}

	@Bean
	public PowierzenieDao powierzenieDao() {
		return new PowierzenieDaoImpl();
	}

	@Bean
	public SondazDao sondazDao() {
		return new SondazDaoImpl();
	}

	@Bean
	public PowierzenieService powierzenieService() {
		return new PowierzenieServiceImpl();
	}

	@Bean
	public SondazService sondazService() {
		return new SondazServiceImpl();
	}

	@Bean
	public ProwadzacyZajeciaDao prowadzacyZajeciaDao() {
		return new ProwadzacyZajeciaDaoImpl();
	}

	@Bean
	public ZapotrzebowanieDao zapotrzebowanieDao() {
		return new ZapotrzebowanieDaoImpl();
	}

	private final Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		return hibernateProperties;
	}

}