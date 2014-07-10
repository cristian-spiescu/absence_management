package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {
	protected AbsenceHibernateDao dao = new AbsenceHibernateDao();

	public List<Absence> getAllAbsences() {
		return dao.getAll();
	}

	public long addAbsenceForEmployee(Absence abs, Employee e) {
		return dao.addAbsenceForEmployee(abs, e);
	}

	public void deleteAbsence(long id) throws Exception {
        dao.deleteAbsence(id);
	}
	
	public void editAbsence(Absence abs) throws Exception {
        dao.editAbsence(abs);
	}

}
