package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {
	protected AbsenceHibernateDao dao = new AbsenceHibernateDao();
	
	public List<Absence> getAbsences(Employee e) {
		List<Absence> result = new ArrayList<Absence>();
		if(e.getAbsences() != null)
			for(Absence a : e.getAbsences())
				result.add(a);
		return result;
	}
	
	public long addAbsence(Absence a){
		return dao.save(a);
		
	}
	
	public void addType(AbsenceType t) {
		AbsenceTypeHibernateDao daot = new AbsenceTypeHibernateDao();
		daot.save(t);
	}
	
	public void deleteAbsence(Absence abs){
		dao.delete(abs.getAbsenceId());
	}
	
	public List<Absence> getAll(){
		return dao.getAll();
	}

}
