package com.baeldung.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
import com.neweducation.data.persistence.entities.designations.LimityProwadzacego;
import com.neweducation.data.persistence.entities.designations.PlanStudiow;
import com.neweducation.data.persistence.entities.designations.PowierzeniaWSemestrze;
import com.neweducation.data.persistence.entities.designations.Zapotrzebowanie;
import com.neweducation.data.persistence.entities.general.KartaPrzedmiotu;
import com.neweducation.data.persistence.entities.general.Kierunek;
import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.persistence.entities.general.PelnomocnikDziekanaDsKierunku;
import com.neweducation.data.persistence.entities.general.Powierzenie;
import com.neweducation.data.persistence.entities.general.ProwadzacyZajecia;
import com.neweducation.data.persistence.entities.general.Przedmiot;
import com.neweducation.data.persistence.entities.general.Semestr;
import com.neweducation.data.persistence.entities.general.Specjalnosc;
import com.neweducation.data.persistence.entities.general.Wydzial;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class FillTableWithSampleData {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Before
	public final void before() {
		session = sessionFactory.openSession();
	}

	@After
	public final void after() {
		session.close();
	}
	
	@Test
	public void x() {


		EntityManager em = entityManagerFactory.createEntityManager();

		Semestr s1 = new Semestr();
		// Semestr s2 = new Semestr();
		PelnomocnikDziekanaDsKierunku pelnomocnik = new PelnomocnikDziekanaDsKierunku();

		em.getTransaction().begin();
		em.persist(s1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.persist( pelnomocnik);
		em.getTransaction().commit();
		
		Wydzial w2 = new Wydzial();
		w2.setNazwa("Wydzial I");
		// 
		em.getTransaction().begin();
		em.persist(w2);
		em.getTransaction().commit();;
		Kierunek w2_k3 = new Kierunek();
		w2_k3.setNazwa("Kierunek I");
		w2_k3.setStopien("II");
		w2_k3.setWydzial(w2);

		em.getTransaction().begin();
		em.persist(w2_k3);
		em.getTransaction().commit();

		Specjalnosc w2_k3_sp1 = new Specjalnosc();
		w2_k3_sp1.setNazwa("Specjalnosc I");

		em.getTransaction().begin();
		em.persist(w2_k3_sp1);
		em.getTransaction().commit();

		Specjalnosc w2_k3_sp2 = new Specjalnosc();
		w2_k3_sp2.setNazwa("Specjalnosc II");
		// em.persist(w2_k3_sp2);

		em.getTransaction().begin();
		em.persist(w2_k3_sp2);
		em.getTransaction().commit();

		Specjalnosc w2_k3_sp3 = new Specjalnosc();
		w2_k3_sp3.setNazwa("Specjalnosc III");
		// em.persist(w2_k3_sp3);

		em.getTransaction().begin();
		em.persist(w2_k3_sp3);
		em.getTransaction().commit();

		w2_k3.getSpecjalnosci().add(w2_k3_sp1);
		w2_k3.getSpecjalnosci().add(w2_k3_sp2);
		w2_k3.getSpecjalnosci().add(w2_k3_sp3);

		PlanStudiow w2_k3_ps1 = new PlanStudiow();
		w2_k3_ps1.setCyklNauczania("Cykl nauczania");
		w2_k3_ps1.setKierunek(w2_k3);
		// em.persist(w2_k3_ps1);

		em.getTransaction().begin();
		em.persist(w2_k3_ps1);
		em.getTransaction().commit();

		Przedmiot w2_k3_ps1_p1 = new Przedmiot();
		w2_k3_ps1_p1.setNazwa("Przedmiot I");
		// em.persist(w2_k3_ps1_p1);

		em.getTransaction().begin();
		em.persist(w2_k3_ps1_p1);
		em.getTransaction().commit();

		w2_k3_ps1_p1.getPlanyStudiow().add(w2_k3_ps1);
		KartaPrzedmiotu w2_k3_ps1_p1_kp1 = new KartaPrzedmiotu();

		w2_k3_ps1_p1_kp1.setOpis("Opis karty przemiotu I ...");
		w2_k3_ps1_p1.getKartyPrzedmiotu().add(w2_k3_ps1_p1_kp1);
		// em.persist(w2_k3_ps1_p1_kp1);

		em.getTransaction().begin();
		em.persist(w2_k3_ps1_p1_kp1);
		em.getTransaction().commit();

		Przedmiot w2_k3_ps1_p2K = new Przedmiot();
		w2_k3_ps1_p2K.setNazwa("Przedmiot II");
		w2_k3_ps1_p2K.getPlanyStudiow().add(w2_k3_ps1);
		// em.persist(w2_k3_ps1_p2K);

		em.getTransaction().begin();
		em.persist(w2_k3_ps1_p2K);
		em.getTransaction().commit();

		KartaPrzedmiotu w2_k3_ps1_p1_kp2 = new KartaPrzedmiotu();
		w2_k3_ps1_p2K.getKartyPrzedmiotu().add(w2_k3_ps1_p1_kp2);
		w2_k3_ps1_p1_kp2.setOpis("Opis karty przemiotu II ...");
		// em.persist(w2_k3_ps1_p1_kp2);

		em.getTransaction().begin();
		em.persist(w2_k3_ps1_p1_kp2);
		em.getTransaction().commit();

		Kurs w2_k3_ps1_p1_k1 = new Kurs();
		w2_k3_ps1_p1_k1.setLiczbaGodzin(60);
		w2_k3_ps1_p1_k1.setNazwa("Kurs I");

		w2_k3_ps1_p1_k1.setPrzedmiot(w2_k3_ps1_p1);
		w2_k3_ps1_p1.getKursy().add(w2_k3_ps1_p1_k1);
		// em.persist(w2_k3_ps1_p1_k1);
		
		em.getTransaction().begin();
		em.persist(w2_k3_ps1_p1_k1);
		em.getTransaction().commit();

		Kurs w2_k3_ps1_p1_k2 = new Kurs();
		w2_k3_ps1_p1_k2.setLiczbaGodzin(45);
		w2_k3_ps1_p1_k2.setNazwa("Kurs II");
		w2_k3_ps1_p1_k2.setPrzedmiot(w2_k3_ps1_p2K);
		w2_k3_ps1_p2K.getKursy().add(w2_k3_ps1_p1_k2);
		// em.persist(w2_k3_ps1_p1_k2);
		
		em.getTransaction().begin();
		em.persist(w2_k3_ps1_p1_k2);
		em.getTransaction().commit();

		Zapotrzebowanie z1 = new Zapotrzebowanie();
		z1.setLiczbaGodzin(100);
		z1.setSemestr(s1);
		z1.setKurs(w2_k3_ps1_p1_k1);
		// em.persist(z1);
		
		em.getTransaction().begin();
		 em.persist(z1);
		em.getTransaction().commit();


		ProwadzacyZajecia pz1 = new ProwadzacyZajecia();
		pz1.setImie("ProwImie");
		pz1.setNazwisko("ProwNazw");
		pz1.getWydzialy().add(w2);
		
		em.getTransaction().begin();
		em.persist(pz1);
		em.getTransaction().commit();


		LimityProwadzacego lp1 = new LimityProwadzacego();
		
		
		em.getTransaction().begin();
		em.persist(lp1);
		em.getTransaction().commit();

		pz1.getLimityProwadzacego().add(lp1);
		pz1.getPrzedmioty().add(w2_k3_ps1_p2K);
		pz1.getPrzedmioty().add(w2_k3_ps1_p1);

		LimityProwadzacego pz1_lp1 = new LimityProwadzacego();
		em.getTransaction().begin();
		em.persist(pz1_lp1);
		em.getTransaction().commit();
		pz1_lp1.setSemestr(s1);
		
		PowierzeniaWSemestrze pws1 = new PowierzeniaWSemestrze();

		pws1.setKierunek(w2_k3);
		pws1.setPelnomocnikDziekanaDsKierunku(pelnomocnik);
		pws1.setSemestr(s1);
		
		
		System.out.println(1111111111);
		
		Powierzenie pz1_pow1 = new Powierzenie();
		pz1_pow1.setZapotrzebowanie(z1);
		pz1_pow1.setKurs(w2_k3_ps1_p1_k1);
		
		pz1_pow1.setPowierzeniaWSemestrze(pws1);
		
		Powierzenie pz1_pow2 = new Powierzenie();
		pz1_pow2.setZapotrzebowanie(z1);
		pz1_pow2.setKurs(w2_k3_ps1_p1_k2);
		
		
		pz1_pow2.setPowierzeniaWSemestrze(pws1);

		
		pws1.getPowierzenia().add(pz1_pow1);
		pws1.getPowierzenia().add(pz1_pow2);
		
		em.getTransaction().begin();
		em.persist(pws1);
		em.getTransaction().commit();
		

		ProwadzacyZajecia pz2 = new ProwadzacyZajecia();
		pz2.setImie("ProwImie2");
		pz2.setNazwisko("ProwNazw2");
	

		em.getTransaction().begin();
		em.persist(pz2);
		em.getTransaction().commit();;

		//--------------
		
		em.getTransaction().begin();
		 em.merge(w2);
		em.getTransaction().commit();

		em.getTransaction().begin();
		em.merge(w2_k3);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_sp1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_sp2);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_sp3);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1_p1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1_p1_kp1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1_p2K);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1_p1_kp2);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1_p1_k1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(w2_k3_ps1_p1_k2);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(z1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(pz1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(lp1);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(pz1_lp1);
		em.getTransaction().commit();

		em.getTransaction().begin();
		em.merge(pz2);
		em.getTransaction().commit();
	}
	
}
