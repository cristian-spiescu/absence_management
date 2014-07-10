package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {

	protected AbsenceHibernateDao dao = new AbsenceHibernateDao();
	
	public List<Absence> getAllAbsences() {
		return dao.getAll();
	}
	
	public long addAbsence(Absence a) {
		return dao.save(a);
	}
	
	public void deleteAbsence(long id) {
		dao.delete(id + "");
	}
	
	public List<AbsenceType> getAbsencesTypes(){	
		return dao.getAbsencesTypes();
	}
	
	public List<Absence> getAbsencesByEmployee(Employee emp){
		List<Absence> l = new ArrayList<Absence>();
		if(emp.getAbsences() != null)
			l.addAll(emp.getAbsences());		
		return l;
	}
	
	public List<Absence> getAbsencesByType(long id){
		return dao.getAbsencesByType(id);
	}
	
	public List<Absence> getAbsencesByPeriod(Date startDate, Date endDate){
		return dao.getAbsencesByPeriod(startDate, endDate);
	}
	
	public List<Absence> getAbsencesByTP(long id, Date startDate, Date endDate){
		return dao.getAbsencesByTP(id, startDate, endDate);
	}
	
}
