package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeService {
	
	protected AbsenceTypeHibernateDao dao = new AbsenceTypeHibernateDao();

	public List<AbsenceType> getAll() {
		return dao.getAll();
	}
	
	public void addAbsenceType(AbsenceType type){
		dao.save(type);
	}
}
