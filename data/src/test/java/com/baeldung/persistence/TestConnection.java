package com.baeldung.persistence;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.neweducation.data.config.PersistenceConfig;
import com.neweducation.data.facade.DataFacade;
import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.services.KursService;
import com.neweducation.data.services.PowierzenieService;

import dtos.DesignationTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)

public class TestConnection {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private KursService kursService;

	@Autowired
	private DataFacade dataFacade;

	@Autowired
	private PowierzenieService powierzenieService;

	private Session session;

	@Before
	public final void before() {
		session = sessionFactory.openSession();
	}

	@After
	public final void after() {
		// session.flush();
		// session.getTransaction().rollback();
		session.close();
	}

	@Test
	public final void whenEntityIsCreated_thenNoExceptions() {
		// kursService.find(1);

		// Kurs k = new Kurs();
		// k.setLiczbaGodzin(10);
		// k.setNazwa("nazwa");
		// k.setPowierzenia(null);
		// k.setPrzedmiot(null);
		// k.setZapotrzebowanie(null);
		//
		// kursService.create(k);

		printBeans();

		// Kurs k1 = dataFacade.find(1);// null
		// System.out.println(k1.getLiczbaGodzin());

		// @NamedQuery(name = "Kierunek.getCoursesFor", query = "SELECT ku FROM
		// Kierunek k JOIN k.planyStudiows ps JOIN ps.przedmioty p JOIN
		// p.kursyku WHERE k.id = facultyId AND k.wydzial = :facultyId AND
		// ku.semestr.id = :semesterId ")

		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery<Kurs> q = em.createNamedQuery("Kierunek.getCoursesFor", Kurs.class);
		q.setParameter("facultyId", 1l); // try it with 1L if Hibernate barks
		// about it
		q.setParameter("semesterId", 1l);
		q.setParameter("fieldOfStudyId", 1l);
		List<Kurs> l = q.getResultList();

		em.getTransaction().rollback();

		List<DesignationTo> l2 = powierzenieService.getAllDesignationsOfUserInSemester(1l, 1l);
		System.out.println(l2);
	}

	// @Autowired
	// @Qualifier("fooKursDao")
	// KursDao kursDao;
	//
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	//
	// @Autowired
	// private SessionFactory sessionFactory;
	//
	// private Session session;
	//
	// @Before
	// public void setUp() throws Exception {
	// session = sessionFactory.openSession();
	// }
	//
	// @After
	// public void tearDown() throws Exception {
	// session.close();
	// }
	//
	public void printBeans() {
		List<String> beans = Arrays.asList(applicationContext.getBeanDefinitionNames());
		for (String b : beans) {
			System.out.println(b);
		}
	}

}
