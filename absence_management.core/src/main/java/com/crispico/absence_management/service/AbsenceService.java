package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {
	
	public List<Absence> getAllAbsences(Employee employee){
		List<Absence> list = new ArrayList<Absence>();
		if( employee.getAbsenceList() != null){
			list.addAll(employee.getAbsenceList());
		}
		return list;
	}
	
	public List<AbsenceType> getAllAbsencesType(){
		AbsenceTypeHibernateDao dao = new AbsenceTypeHibernateDao();
		
		return dao.getAll();
	}
	
	public long saveAbsence(Absence absence){
		AbsenceHibernateDao dao = new AbsenceHibernateDao();
		dao.save(absence);
		return absence.getId();
	}
	
	public void deleteAbsence(String id){
		AbsenceHibernateDao dao = new AbsenceHibernateDao();
		dao.delete(id);
	}
	
}
