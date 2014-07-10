package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;

public class AbsenceService {
	protected AbsenceHibernateDao dao = new AbsenceHibernateDao();

	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}

	public List<Absence> getAllAbsences() {
		return dao.getAll();
	}

	public void save(Absence absence) {
		dao.save(absence);
	}

	public void deleteAbs(Absence absence) {
		dao.delete(absence);
	}

	public void edit(Absence absence) {
		dao.update(absence);
	}

}
