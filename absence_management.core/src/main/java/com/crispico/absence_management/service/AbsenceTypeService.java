package com.crispico.absence_management.service;

import java.util.List;

import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceTypeService {

	protected AbsenceTypeHibernateDao dao = new AbsenceTypeHibernateDao();
	
	public List<AbsenceType> getAllAbsenceTypes() {
		return dao.getAbsenceTypes();
	}
	
	public AbsenceType getAbsenceTypeById(long id){
		return dao.getAbsenceTypeById(id);
	}
	
	public AbsenceType addAbsenceType(AbsenceType absenceType){
		dao.save(absenceType);
		return absenceType;
	}
	
	public void deleteAbsenceType(AbsenceType absenceType){
		dao.delete(absenceType);
	}
	
	public void updateAbsenceType(AbsenceType absenceType){
		dao.update(absenceType);
	}

}
