package com.crispico.absence_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;
import com.crispico.absence_management.model.AbsenceType;

public class AbsenceService {

	AbsenceHibernateDao dao = new AbsenceHibernateDao();
	
	public List<Absence> getAbsencesByEmployee(Employee employee){
		List<Absence> result = new ArrayList<Absence>() ;
		Set<Absence> absences = employee.getAbsences();
		for(Absence absence:absences){
			result.add(absence);
		}
		return result;	
	}
	
	public List<Absence> getAbsencesByType(AbsenceType absenceType){
		List<Absence> aux = dao.getAll() ;
		List<Absence> result = new ArrayList<Absence>();
		
		System.out.println("uaaaai " + absenceType.getType());
		
		for(Absence absence : aux){
			System.out.println(absence.getType().getType());
		}
		
		System.out.println("uaaaai");
		
		for(Absence absence : aux){
			if(absence.getType().getType().equals(absenceType.getType())){
				result.add(absence);
			}
		}
		
		
		
		for(Absence absence : result){
			System.out.println("uaiii " + absence.getType());
		}
		
		return result;	
	}
	
	public long addAbsence(Absence absence){
		return dao.save(absence);
	}
	
	public void deleteAbsence(Absence absence){
		dao.delete(absence.getId());
	}
	
	public List<Absence> getAllAbsences(){
		return dao.getAll();
	}
}
