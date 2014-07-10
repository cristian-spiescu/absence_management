package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeService {
	protected AbsenceTypeHibernateDao athd = new AbsenceTypeHibernateDao();
	
	public List<AbsenceType> getAllAbsenceTypes() {
		return athd.getAll();
	}
}
