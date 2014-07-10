package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeService {
	protected AbsenceTypeHibernateDao dao = new AbsenceTypeHibernateDao();

	public List<AbsenceType> getAllAbsenceTypes() {
		return AbsenceTypeHibernateDao.getAll();
	}

	public void save(AbsenceType absenceType) {
		dao.save(absenceType);
	}

	public void deleteAbsType(AbsenceType absenceType) {
		dao.delete(absenceType);
	}

	public void editAbsType(AbsenceType absenceType) {
		dao.update(absenceType);
	}
	
}
