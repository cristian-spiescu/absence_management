package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {

	public List<Absence> getAbsencesByEmployee(Employee employee) {
		List<Absence> absenceList = new ArrayList<Absence>();
		Set<Absence> employeeAbsences = employee.getAbsences();
		
		if (employeeAbsences != null) {
			absenceList.addAll(employee.getAbsences());
		}
		
		return absenceList;
	}	

	public List<AbsenceType> getAllAbsenceType() {
		AbsenceTypeHibernateDao absenceTypeDao = new AbsenceTypeHibernateDao();
		
		return absenceTypeDao.getAll();
	}
	
	public long saveAbsence(Absence absence) {
		AbsenceHibernateDao absDao = new AbsenceHibernateDao();
		
		return absDao.save(absence);
	}
	
	public void deleteAbsence(String id) {
		AbsenceHibernateDao absDao = new AbsenceHibernateDao();
		absDao.delete(id);
	}
	
}
