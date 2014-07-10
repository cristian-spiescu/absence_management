package com.crispico.absence_management.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class AbsenceService {
	protected AbsenceHibernateDao ahd = new AbsenceHibernateDao();
	
	public List<Absence> getAllAbsences() {
		return ahd.getAll();
	}
	
	public List<Absence> getAbsences(long i) {
		return ahd.getEmployeeAbsences(i);
	}
	
	public Absence addAbsenceToEmployee(Employee emp,String sd, String fd, AbsenceType tip) throws Exception {
		
		Date start_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(sd);
		Date finish_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(fd);
		
//		System.out.println(sd);
//		System.out.println(fd);
//		
//		System.out.println(start_date);
//		System.out.println(finish_date);
		Absence ab = new Absence();
		ab.setEmployee(emp);
		ab.setStart(start_date);
		ab.setFinish(finish_date);
		ab.setType(tip);
		if ( ahd.save(ab)) {
			return ab;
		}
		return null;	
	}
	
	public boolean deleteAbsence(long i) {
		boolean b = ahd.deleteAbsence(i); 
//		System.out.println(b+" pentru absenta cu id "+i);
		return b;
	}
	
	public Absence editAbsence(long i,AbsenceType aty,String sd,String fd ) throws Exception{
		Date start_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(sd);
		Date finish_date = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(fd);
		
		System.out.println(sd);
		System.out.println(fd);
		
		System.out.println(start_date);
		System.out.println(finish_date);
		
		List<Absence> ab = ahd.getAbsence(i);
		ab.get(0).setStart(start_date);
		ab.get(0).setFinish(finish_date);
		ab.get(0).setType(aty);
		if ( ahd.editAbsence(ab.get(0))) {
			return ab.get(0);
		}
		return null;
		
	}
	
	public long howMany() {
		return ahd.howManyAbsences();
	}
	
	public List<Absence> getAbsencesFromTo(int i) {
		return ahd.getFromTo(i);
	}
}
