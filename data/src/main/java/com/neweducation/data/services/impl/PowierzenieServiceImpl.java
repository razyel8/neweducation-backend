package com.neweducation.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.neweducation.data.persistence.daos.KursDao;
import com.neweducation.data.persistence.daos.PowierzeniaWSemestrzeDao;
import com.neweducation.data.persistence.daos.PowierzenieDao;
import com.neweducation.data.persistence.daos.ProwadzacyZajeciaDao;
import com.neweducation.data.persistence.daos.ZapotrzebowanieDao;
import com.neweducation.data.persistence.daos.generics.IOperations;
import com.neweducation.data.persistence.entities.designations.PowierzeniaWSemestrze;
import com.neweducation.data.persistence.entities.designations.StatusPowierzenia;
import com.neweducation.data.persistence.entities.designations.Zapotrzebowanie;
import com.neweducation.data.persistence.entities.general.Kurs;
import com.neweducation.data.persistence.entities.general.Powierzenie;
import com.neweducation.data.persistence.entities.general.ProwadzacyZajecia;
import com.neweducation.data.services.AbstractHibernateService;
import com.neweducation.data.services.PowierzenieService;

import dtos.DesignationTo;

/**
 * Created by Maciej Wolański maciekwski@gmail.com on 08.02.2017.
 */
@Service
public class PowierzenieServiceImpl extends AbstractHibernateService<Powierzenie> implements PowierzenieService {

	@Autowired
	@Qualifier("powierzenieDao")
	private PowierzenieDao dao;

	@Autowired
	@Qualifier("kursDao")
	private KursDao kursDao;

	@Autowired
	@Qualifier("prowadzacyZajeciaDao")
	private ProwadzacyZajeciaDao prowadzacyZajeciaDao;

	@Autowired
	@Qualifier("zapotrzebowanieDao")
	private ZapotrzebowanieDao zapotrzebowanieDao;

	@Autowired
	@Qualifier("powierzeniaWSemestrzeDao")
	private PowierzeniaWSemestrzeDao powierzeniaWSemestrzeDao;

	@Override
	public void discardDesignation(int designationId) {
		dao.updateDesignationStatus(designationId, StatusPowierzenia.Niezaakceptowane);
	}

	@Override
	public void acceptDesignation(int designationId) {
		dao.updateDesignationStatus(designationId, StatusPowierzenia.Zaakceptowane);
	}

	@Override
	protected IOperations<Powierzenie> getDao() {
		return dao;
	}

	@Override
	public void addNewDesignation(long courseId, long lecturerId, long numberOfHours, long requestId,
			long designationInSemesterId) {

		Powierzenie powierzenie = new Powierzenie();
		Kurs kurs = kursDao.find(courseId);
		ProwadzacyZajecia prowadzacyZajecia = prowadzacyZajeciaDao.find(lecturerId);
		Zapotrzebowanie zapotrzebowanie = zapotrzebowanieDao.find(requestId);
		PowierzeniaWSemestrze powierzeniaWSemestrze = powierzeniaWSemestrzeDao.find(designationInSemesterId);

		// others: cascade - persist/save/refresh
		powierzenie.setKurs(kurs);
		powierzenie.setProwadzacyZajecia(prowadzacyZajecia);
		powierzenie.setLiczbaGodzin((int) numberOfHours);
		powierzenie.setStatusPowierzenia(StatusPowierzenia.WPrzygotowaniu);
		powierzenie.setZapotrzebowanie(zapotrzebowanie);
		powierzenie.setPowierzeniaWSemestrze(powierzeniaWSemestrze);

		dao.create(powierzenie);

	}

	@Override
	public List<DesignationTo> getAllDesignationsOfUserInSemester(long userId, long semesterId) {
		List<DesignationTo> designationTos = new ArrayList<>();
		List<Powierzenie> powierzenia = this.dao.getAllDesignationsOfUserInSemester(userId, semesterId);

		for (Powierzenie p : powierzenia) {
			DesignationTo dto = new DesignationTo();
			dto.setId(p.getId());

			try {
				dto.setTypStudiow(p.getPowierzeniaWSemestrze().getKierunek().getPlanyStudiows().get(0)
						.getRodzajStudiow().toString());
			} catch (Exception e) {
				// nullpointer / indexoutofbounds
			}

			try {
				dto.setWydzial(p.getPowierzeniaWSemestrze().getKierunek().getWydzial().getNazwa());
			} catch (Exception e) {
				// nullpointer / indexoutofbounds
			}
			try {
				dto.setKierunek(p.getPowierzeniaWSemestrze().getKierunek().getNazwa());
			} catch (Exception e) {
				// nullpointer / indexoutofbounds
			}

			dto.setKurs(p.getKurs().getNazwa());
			dto.setKursId(p.getKurs().getId());
			dto.setForma(p.getKurs().getFormaKursu().toString());

			try {
				dto.setNrSem(
						Integer.parseInt(p.getKurs().getPrzedmiot().getKartyPrzedmiotu().get(0).getNumerSemestru()));
			} catch (Exception e) {
				// nullpointer / indexoutofbounds
			}

			dto.setGodziny(p.getLiczbaGodzin());
			dto.setStatus(p.getStatusPowierzenia().toString());
			dto.setStatusEnum(statusEnum(p.getStatusPowierzenia()));
		}

		return designationTos;
	}

	private int statusEnum(StatusPowierzenia sp) {
		if (sp.equals(StatusPowierzenia.Zaakceptowane)) {
			return 1;
		}
		if (sp.equals(StatusPowierzenia.Niezaakceptowane)) {
			return 2;
		}
		return 0;
	}

}
