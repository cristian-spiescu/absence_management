package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceTypeService {

	AbsenceTypeHibernateDao dao = new AbsenceTypeHibernateDao();
	
	public void addAbsenceType(AbsenceType absenceType){
		dao.save(absenceType);
	}
	
	public List<AbsenceType> getAllAbsenceTypes(){
		return dao.getAll();
	}
	
}
